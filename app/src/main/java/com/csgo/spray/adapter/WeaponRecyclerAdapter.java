package com.csgo.spray.adapter;

import java.util.List;

import com.csgo.spray.model.Utility;
import com.csgo.spray.model.Weapon;
import com.csgo.spray.activities.ExtendedSprayPatternView;
import com.csgo.spray.activities.SprayPatternView;
import com.csgospray.R;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class WeaponRecyclerAdapter extends RecyclerView.Adapter<WeaponRecyclerAdapter.WeaponHolder> {
    private List<Weapon> objects;
    private Context context;
    private Utility utility;

    public WeaponRecyclerAdapter(Context context, List<Weapon> objects) {
        this.context = context;
        this.objects = objects;
        utility = new Utility(context);
    }

    @Override
    public WeaponHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_weapon_item, parent, false);
        return new WeaponHolder(view);
    }

    @Override
    public void onBindViewHolder(WeaponHolder holder, int position) {
        Weapon weapon = objects.get(position);
        Resources res = context.getResources();
        int weaponID = weapon.getWeapon_image_id();
        int width = 100;
        int height = 100;
        Bitmap bitmap = utility.bitmapHandler(res, weaponID, width, height);
        holder.imageView.setImageBitmap(bitmap);
        holder.weaponName.setText(objects.get(position).getWeapon_name());
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class WeaponHolder extends RecyclerView.ViewHolder implements OnClickListener {
        ImageView imageView;
        TextView weaponName;
        String key = "com.csgo.spray.SprayPatternView";
        public WeaponHolder(View itemRow) {
            super(itemRow);
            imageView = (ImageView) itemRow
                    .findViewById(R.id.imageWeapon);
            weaponName = (TextView) itemRow.findViewById(R.id.weaponName);
            itemRow.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String weaponName = objects.get(getLayoutPosition()).getWeapon_name().toLowerCase();
            if (weaponName.equals("aug") || weaponName.equals("sg 553")) {
                Intent intent = new Intent(context.getApplicationContext(), ExtendedSprayPatternView.class);
                intent.putExtra(key, weaponName);
                context.startActivity(intent);
            } else {
                Log.v("WEAPON_TYPE", String.valueOf(weaponName.equals("dessert eagle")) + " Weopon Name: " + weaponName);
                Intent intent = new Intent(context.getApplicationContext(), SprayPatternView.class);
                intent.putExtra(key, weaponName);
                context.startActivity(intent);
            }
        }
    }


}
