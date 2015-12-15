package com.csgo.spray.adapter;

import java.util.List;

import com.csgo.spray.model.Utility;
import com.csgo.spray.model.Weapon;
import com.csgo.spray.view.ExtendedSprayPatternView;
import com.csgo.spray.view.SprayPatternView;
import com.csgospray.R;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListViewAdapter extends ArrayAdapter<Weapon> implements OnClickListener{
	private String key = "com.csgo.spray.SprayPatternView";
	private List<Weapon> objects;
	private FragmentActivity context;
	private Utility utility;
	private int position;
	public CustomListViewAdapter(FragmentActivity context, List<Weapon> objects) {
		super(context, R.layout.custom_weapon_item, objects);
		this.objects = objects;
		this.context = context;
		utility = new Utility(context);

	}
	private static class ViewHolder{
		ImageView imageView;
		TextView weaponName;
		TextView weaponPattern;
	}
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder holder = new ViewHolder();
		this.position = position;
		if(convertView==null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.custom_weapon_item, null, false);
			holder.imageView = (ImageView) convertView
					.findViewById(R.id.imageWeapon);
			holder.weaponName = (TextView) convertView.findViewById(R.id.weaponName);
			holder.weaponPattern = (TextView) convertView.findViewById(R.id.showSprayPattern);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.imageView.setImageResource(objects.get(position).getWeapon_image_id());
		holder.weaponName.setText(objects.get(position).getWeapon_name());
		String weaponName = objects.get(position).getWeapon_name();
		holder.weaponPattern.setOnClickListener(this);
		return convertView;
	}

	@Override
	public void onClick(View v) {
		String weaponName = objects.get(position).getWeapon_name().toLowerCase();
		if(weaponName.equals("aug")|| weaponName.equals("sg 553")){
			Intent intent = new Intent(context, ExtendedSprayPatternView.class);
			intent.putExtra(key, weaponName);
			context.startActivity(intent);
		}else{
			Log.v("Check Weapon Eagle", String.valueOf(weaponName.equals("dessert eagle")) + " Weopon Name: " + weaponName);
			Intent intent = new Intent(context, SprayPatternView.class);
			intent.putExtra(key, weaponName);
			context.startActivity(intent);
		}
	}
}
