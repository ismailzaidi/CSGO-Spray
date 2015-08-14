package com.csgo.spray.fragments;

import com.csgo.spray.adapter.ViewPagerAdapter;
import com.csgospray.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentWeaponSelection extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_rifle, container, false);
		ViewPager pager = (ViewPager) rootView.findViewById(R.id.viewPager);
		pager.setAdapter(new ViewPagerAdapter(getFragmentManager()));
		return rootView;
	}

}
