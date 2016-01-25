package com.csgo.spray.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;

import com.csgospray.R;

public class DataFetcher {
	private static DataFetcher instance;
	private ArrayList<Weapon> weaponlist;
	private Context context;

	private DataFetcher(Context context) {
		weaponlist = new ArrayList<Weapon>();
		this.context = context;
		populateWeapons();
	}
	public static DataFetcher getInstance(Context context) {
		if (instance == null) {
			instance = new DataFetcher(context);
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
			int imageCount = 0;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				String weaponName = data[0];
				String catergory = data[1];
				int weaponImageID = icons_array.getResourceId(imageCount, -1);
				Log.v("Image_Data", "Image Icon: " +  imageCount +  " ID: " + weaponImageID);
				weaponlist.add(new Weapon(weaponImageID,weaponName, catergory));
				imageCount++;
			}
			// Collections.sort(weaponlist);
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
