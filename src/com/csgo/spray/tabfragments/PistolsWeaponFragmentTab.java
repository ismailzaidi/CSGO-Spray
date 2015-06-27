package com.csgo.spray.tabfragments;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;
import com.csgo.spray.adapter.CustomListViewAdapter;
import com.csgo.spray.model.Model;
import com.csgo.spray.model.Weapon;
import com.csgospray.R;

public  class PistolsWeaponFragmentTab extends SherlockFragment {
	private static String KEY_WEAPON = "com.csgo.spray.key";
	private CustomListViewAdapter adapter;
	private Model model;
	private ArrayList<Weapon> list;

	private static class ViewHolder {
		private ListView listView;
		private View view;
	}

	public static PistolsWeaponFragmentTab InstanceOf(String category) {
		PistolsWeaponFragmentTab fragment = new PistolsWeaponFragmentTab();
		Bundle bundle = new Bundle();
		bundle.putString(KEY_WEAPON, category);
		fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		ViewHolder holder = new ViewHolder();
		holder.view = inflater.inflate(R.layout.fragment_tab_weapon, container,
				false);
		holder.listView = (ListView) holder.view.findViewById(R.id.listViewWeapons);
		String category = getArguments().getString(KEY_WEAPON);
		list = Model.getInstance(getSherlockActivity()).getCategory(category);
		adapter = new CustomListViewAdapter(getSherlockActivity(), list);
		holder.listView.setAdapter(adapter);
		return holder.view;
	}

}
