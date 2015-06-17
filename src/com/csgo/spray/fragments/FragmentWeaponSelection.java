package com.csgo.spray.fragments;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.csgo.spray.adapter.ViewPagerAdapter;
import com.csgospray.R;

public class FragmentWeaponSelection extends SherlockFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_rifle, container, false);
		ViewPager pager = (ViewPager) rootView.findViewById(R.id.viewPager);
		pager.setAdapter(new ViewPagerAdapter(getFragmentManager()));
		return rootView;
	}

}
