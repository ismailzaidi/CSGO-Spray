package com.csgo.spray.view;

import com.csgo.spray.model.DisableSwipeViewPager;
import com.csgo.spray.tabfragments.SprayPatternFragmentTab;
import com.csgospray.R;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class SprayPatternView extends AppCompatActivity {
	private DisableSwipeViewPager viewPager;
	private String key = "com.csgo.spray.SprayPatternView";
	private String weapon;
	private TabLayout tabLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spray_view);
		weapon = this.getIntent().getStringExtra(key);
		weapon = weaponChecker(weapon);
		viewPager = (DisableSwipeViewPager) findViewById(R.id.spraypager);
		tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setHomeAsUpIndicator(R.drawable.ic_launcher_back);
		actionBar.setDisplayHomeAsUpEnabled(true);
		FragmentManager fm = getSupportFragmentManager();
		SprayPagerAdapter adapter = new SprayPagerAdapter(fm);
		viewPager.setAdapter(adapter);
		tabLayout.setupWithViewPager(viewPager);
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = this.getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.about_icon:
			FragmentManager fm = this.getSupportFragmentManager();
			AboutView aboutDialog = AboutView.newInstance();
			aboutDialog.show(fm, "com.mainActivity.spray");
			return true;
		case android.R.id.home:
			finish();
			return true;
		default:
			return true;
		}
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void onBackPressed() {
		FragmentManager manager = getSupportFragmentManager();
		if (manager.getBackStackEntryCount() > 0) {
			manager.popBackStack();
		} else {
			super.onBackPressed();
		}
		super.onBackPressed();
	}

	/**
	 * Weapon Validation
	 * 
	 * @param weapon
	 * @return
	 */
	private String weaponChecker(String weapon) {
		if (weapon.equals("dessert eagle")) {
			weapon = "deagle";
		}
		if (weapon.equals("cz75 auto")) {
			weapon = "cz75a";
		}
		return weapon;
	}

	private class SprayPagerAdapter extends FragmentPagerAdapter {
		private int number_tabs = 3;

		public SprayPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		private String[] fragment_titles = { "Spray Pattern", "Anti Pattern", "Inverted Pattern" };

		@Override
		public Fragment getItem(int postion) {
			switch (postion) {
			case 0:
				SprayPatternFragmentTab fragmentOne = SprayPatternFragmentTab.InstanceOf(weapon + "_p");
				return fragmentOne;
			case 1:
				SprayPatternFragmentTab fragmentTwo = SprayPatternFragmentTab.InstanceOf(weapon + "_c");
				return fragmentTwo;
			case 2:
				SprayPatternFragmentTab fragmentThree = SprayPatternFragmentTab.InstanceOf(weapon + "_i");
				return fragmentThree;
			}
			return null;
		}

		@Override
		public int getItemPosition(Object object) {
			// TODO Auto-generated method stub
			return super.getItemPosition(object);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			// TODO Auto-generated method stub
			return fragment_titles[position];
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return number_tabs;
		}
	}
}
