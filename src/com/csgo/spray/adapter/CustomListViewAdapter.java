package com.csgo.spray.adapter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.csgo.spray.model.Utility;
import com.csgo.spray.model.Weapon;
import com.csgo.spray.view.ExtendedSprayPatternView;
import com.csgo.spray.view.SprayPatternView;
import com.csgospray.R;

public class CustomListViewAdapter extends ArrayAdapter<Weapon> {
	private String key = "com.csgo.spray.SprayPatternView";
	private List<Weapon> objects;
	private SherlockFragmentActivity context;
	private Utility utility;

	public CustomListViewAdapter(SherlockFragmentActivity context, List<Weapon> objects) {
		super(context, R.layout.list_custom, objects);
		this.objects = objects;
		this.context = context;

	}
	private static class ViewHolder{
		ImageView imageView;
		TextView weaponName;
		TextView weaponPrice;
		TextView weaponPattern;
	}
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		convertView = inflater.inflate(R.layout.list_custom, null, false);
		ViewHolder holder = new ViewHolder();

		holder.imageView = (ImageView) convertView
				.findViewById(R.id.imageWeapon);
		holder.weaponName = (TextView) convertView.findViewById(R.id.weaponName);
		holder.weaponPrice = (TextView) convertView
				.findViewById(R.id.weaponPrice);
		holder.weaponPattern = (TextView) convertView.findViewById(R.id.showSprayPattern);
		String price = "Cost: "+objects.get(position).getWeapon_price()+"\nMoney Per Kill:" + objects.get(position).getWeapon_kill_price();
		holder.imageView.setImageResource(objects.get(position).getWeapon_image_id());
		holder.weaponName.setText(objects.get(position).getWeapon_name());
		holder.weaponPrice.setText(price);
		holder.weaponPattern.setOnClickListener(new OnClickListener() {
			
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
		});
		utility = new Utility(context);
		utility.setFontForView((ViewGroup) convertView);
		return convertView;
	}
}
