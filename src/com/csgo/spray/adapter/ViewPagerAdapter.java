package com.csgo.spray.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.csgo.spray.tabfragments.WeaponFragmentTab;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
	private int number_tabs = 4;
	private WeaponFragmentTab fragment;

	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		int counter = position + 1;
		Log.v("Item Clicked", "Postition: " + counter);
		switch (position) {
		case 0:
			fragment = WeaponFragmentTab.InstanceOf("pistols");
			return fragment;
		case 1:
			fragment = WeaponFragmentTab.InstanceOf("rifles");
			return fragment;
		case 2:
			fragment = WeaponFragmentTab.InstanceOf("smgs");
			return fragment;
		case 3:
			fragment = WeaponFragmentTab.InstanceOf("heavy");
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
