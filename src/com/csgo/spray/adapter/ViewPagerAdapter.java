package com.csgo.spray.adapter;

import com.csgo.spray.tabfragments.HeavyFragmentTab;
import com.csgo.spray.tabfragments.PistolFragmentTab;
import com.csgo.spray.tabfragments.RiflesFragmentTab;
import com.csgo.spray.tabfragments.SMGFragmentTab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

public class ViewPagerAdapter extends FragmentPagerAdapter {
	private int number_tabs = 4;
	private Fragment fragment;
	private String[] fragment_titles = {"Pistols","Rifles","SMG's","Heavy"};

	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}
	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return fragment_titles[position];
	}
	@Override
	public Fragment getItem(int position) {
		int counter = position + 1;
		Log.v("Item Clicked", "Postition: " + counter);
		switch (position) {
		case 0:
			fragment = PistolFragmentTab.InstanceOf();
			return fragment;
		case 1:
			fragment = RiflesFragmentTab.InstanceOf();
			return fragment;
		case 2:
			fragment = SMGFragmentTab.InstanceOf();
			return fragment;
		case 3:
			fragment = HeavyFragmentTab.InstanceOf();
			return fragment;
		}
		return fragment;
	}


	@Override
	public int getItemPosition(Object object) {
		// TODO Auto-generated method stub
		return POSITION_NONE;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return number_tabs;
	}

}
