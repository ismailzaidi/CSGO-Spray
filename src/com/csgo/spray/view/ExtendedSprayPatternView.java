package com.csgo.spray.view;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.csgo.spray.model.DisableSwipeViewPager;
import com.csgo.spray.tabfragments.SprayPatternFragmentTab;
import com.csgospray.R;

public class ExtendedSprayPatternView extends SherlockFragmentActivity {
	private ActionBar actionBar;
	private DisableSwipeViewPager viewPager;
	private Tab tab;
	private String key = "com.csgo.spray.SprayPatternView";
	private String weapon;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spray_view);
		weapon = this.getIntent().getStringExtra(key);
		actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		viewPager = (DisableSwipeViewPager) findViewById(R.id.spraypager);

		viewPager.setPagingEnabled(true);
		FragmentManager fm = getSupportFragmentManager();
		SprayPagerAdapter adapter = new SprayPagerAdapter(fm);
		viewPager.setAdapter(adapter);

		ViewPager.SimpleOnPageChangeListener listener = new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				super.onPageSelected(position);
				actionBar.setSelectedNavigationItem(position);
			}

		};

		viewPager.setOnPageChangeListener(listener);
		ActionBar.TabListener tabListener = new ActionBar.TabListener() {

			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				viewPager.setCurrentItem(tab.getPosition());
			}

			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				viewPager.setCurrentItem(tab.getPosition());

			}

			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				viewPager.setCurrentItem(tab.getPosition());

			}
		};

		tab = actionBar.newTab().setText("Spray Pattern")
				.setTabListener(tabListener);
		actionBar.addTab(tab);
		tab = actionBar.newTab().setText("Anti Pattern")
				.setTabListener(tabListener);
		actionBar.addTab(tab);
		tab = actionBar.newTab().setText("Inverted Pattern")
				.setTabListener(tabListener);
		actionBar.addTab(tab);
		tab = actionBar.newTab().setText("Spray (Scoped)")
				.setTabListener(tabListener);
		actionBar.addTab(tab);
		tab = actionBar.newTab().setText("Anti (Scoped)")
				.setTabListener(tabListener);
		actionBar.addTab(tab);
		tab = actionBar.newTab().setText("Inverted (Scoped)")
				.setTabListener(tabListener);
		actionBar.addTab(tab);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = this.getSupportMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent;
		switch (item.getItemId()) {
		case R.id.why_icon:
			intent = new Intent(this, WhyPatternView.class);
			startActivity(intent);
			return true;
		case R.id.about_icon:
			intent = new Intent(this, AboutView.class);
			startActivity(intent);
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

	private class SprayPagerAdapter extends FragmentPagerAdapter {
		private int number_tabs = 6;

		public SprayPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int postion) {
			switch (postion) {
			case 0:
				SprayPatternFragmentTab fragmentOne = SprayPatternFragmentTab
						.InstanceOf(weapon + "_p");
				return fragmentOne;
			case 1:
				SprayPatternFragmentTab fragmentTwo = SprayPatternFragmentTab
						.InstanceOf(weapon + "_c");
				return fragmentTwo;
			case 2:
				SprayPatternFragmentTab fragmentThree = SprayPatternFragmentTab
						.InstanceOf(weapon + "_i");
				return fragmentThree;
			case 3:
				SprayPatternFragmentTab fragmentFour = SprayPatternFragmentTab
						.InstanceOf(weapon + "_scoped_p");
				return fragmentFour;
			case 4:
				SprayPatternFragmentTab fragmentFive = SprayPatternFragmentTab
						.InstanceOf(weapon + "_scoped_c");
				return fragmentFive;
			case 5:
				SprayPatternFragmentTab fragmentSix = SprayPatternFragmentTab
						.InstanceOf(weapon + "_scoped_i");
				return fragmentSix;
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
}
