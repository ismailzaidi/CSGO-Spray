package com.csgo.spray.tabfragments;

import com.csgospray.R;
import com.koushikdutta.ion.Ion;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class SprayPatternFragmentTab extends Fragment{
	private static String KEY_WEAPON = "com.csgo.spray.key";
	public static SprayPatternFragmentTab InstanceOf(String weaponName) {
		SprayPatternFragmentTab fragment = new SprayPatternFragmentTab();
		Bundle bundle = new Bundle();
		bundle.putString(KEY_WEAPON, weaponName);
		fragment.setArguments(bundle);
		return fragment;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_tab_spray_pattern, container,
				false);
		ImageView imageView = (ImageView) view.findViewById(R.id.sprayImageButton);
		String weapon = getArguments().getString(KEY_WEAPON);
		int image_resrouce = SprayPatternRetriever(weapon);
		String url = "android.resource://com.csgospray/" + image_resrouce;
		Ion.with(imageView).load(url);
		return view;
	}
	public int SprayPatternRetriever(String weapon){
		String packageName = getActivity().getPackageName();
		String defType = "drawable";
		weapon = weapon.replaceAll("\\s", "_");
		weapon = weapon.replaceAll("-", "_").toLowerCase();
		int resID = getActivity().getResources().getIdentifier(weapon, defType, packageName);
		Log.v("Image Resource: ",  "Image Weapon: " + weapon +  " Image Resource: " + resID);
		return resID;
	}
	
	
	
}
