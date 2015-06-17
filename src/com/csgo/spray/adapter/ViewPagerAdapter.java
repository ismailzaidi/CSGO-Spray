package com.csgo.spray.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.csgo.spray.tabfragments.WeaponFragmentTab;

public class ViewPagerAdapter extends FragmentPagerAdapter {
	private int number_tabs = 4;
	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int postion) {
		Log.v("Item Clicked", "Postition: " + postion);
		switch (postion) {
		case 0:
			WeaponFragmentTab fragmentOne = WeaponFragmentTab
					.InstanceOf("pistols");
			return fragmentOne;
		case 1:
			WeaponFragmentTab fragmentTwo = WeaponFragmentTab
					.InstanceOf("rifles");
			return fragmentTwo;
		case 2:
			WeaponFragmentTab fragmentThree = WeaponFragmentTab
					.InstanceOf("smgs");
			return fragmentThree;
		case 3:
			WeaponFragmentTab fragmentFour = WeaponFragmentTab
					.InstanceOf("heavy");
			return fragmentFour;
		}
		return null;
	}
	@Override
	public int getItemPosition(Object object) {
		// TODO Auto-generated method stub
		return super.getItemPosition(object);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return number_tabs;
	}

}
