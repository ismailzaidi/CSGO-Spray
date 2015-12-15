package com.csgo.spray.tabfragments;

import java.util.ArrayList;

import com.csgo.spray.adapter.CustomListViewAdapter;
import com.csgo.spray.model.Model;
import com.csgo.spray.model.Weapon;
import com.csgospray.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public  class WeaponFragment extends Fragment {
	private static String KEY_WEAPON = "com.csgo.spray.key";
	private CustomListViewAdapter adapter;
	private Model model;
	private ArrayList<Weapon> list;
	public static WeaponFragment InstanceOf(String weaponCategory) {
		WeaponFragment fragment = new WeaponFragment();
		Bundle bundle = new Bundle();
		bundle.putString(KEY_WEAPON, weaponCategory);
		fragment.setArguments(bundle);
		return fragment;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String category = getArguments().getString(KEY_WEAPON);
		list = Model.getInstance(getActivity()).getCategory(category);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.weapon_fragment_item, container,
				false);
		ListView listView = (ListView) view.findViewById(R.id.listViewWeapons);
		adapter = new CustomListViewAdapter(getActivity(), list);
		listView.setAdapter(adapter);
		return view;
	}

}
