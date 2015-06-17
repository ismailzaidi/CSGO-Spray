package com.csgo.spray.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.content.Context;
import android.content.res.TypedArray;

import com.csgospray.R;

public class Model {
	private static Model instance;
	private ArrayList<Weapon> weaponlist;
	private Context context;

	private Model(Context context) {
		weaponlist = new ArrayList<Weapon>();
		this.context = context;
		populateWeapons();
	}

	public static synchronized Model getInstance(Context context) {
		if (instance == null) {
			instance = new Model(context);
		}
		return instance;
	}


	public ArrayList<Weapon> getCategory(String category) {
		ArrayList<Weapon> tempList = new ArrayList<Weapon>();
		for (Weapon item : weaponlist) {
			if (item.getCategory().equals(category)) {
				tempList.add(item);
			}
		}

		return tempList;
	}

	private void populateWeapons() {
		InputStream input;
		TypedArray icons_array = context.getResources().obtainTypedArray(
				R.array.weapon_icons);
		try {
			input = context.getResources().getAssets()
					.open("csgo_collection_csv.csv");
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					input));
			String line = "";
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				String weaponName = data[0];
				String catergory = data[1];
				String price = "$" + data[2];
				String price_per_kill = "$" + data[3];
				weaponlist.add(new Weapon(weaponName, catergory, price,
						price_per_kill));
			}
			for (int i = 0; i < weaponlist.size(); i++) {
				int icon = icons_array.getResourceId(i, -1);
				weaponlist.get(i).setWeapon_image_id(icon);
			}
			// Collections.sort(weaponlist);
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
