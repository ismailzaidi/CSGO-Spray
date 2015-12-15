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

public  class PistolsWeaponFragmentTab extends Fragment {
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
		list = Model.getInstance(getActivity()).getCategory(category);
		adapter = new CustomListViewAdapter(getActivity(), list);
		holder.listView.setAdapter(adapter);
		return holder.view;
	}

}
