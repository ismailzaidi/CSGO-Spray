package com.csgo.spray.view;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.csgo.spray.adapter.ViewPagerAdapter;
import com.csgo.spray.model.DisableSwipeViewPager;
import com.csgospray.R;

public class MainActivity extends SherlockFragmentActivity {
	private ActionBar actionBar;
	private DisableSwipeViewPager viewPager;
	private Tab tab;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_view);

		actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		viewPager = (DisableSwipeViewPager) findViewById(R.id.pager);

		viewPager.setPagingEnabled(false);
		FragmentManager fm = getSupportFragmentManager();
		ViewPagerAdapter adapter = new ViewPagerAdapter(fm);
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
		
		tab = actionBar.newTab().setText("Pistols").setTabListener(tabListener);
		actionBar.addTab(tab);
		tab = actionBar.newTab().setText("Rifles").setTabListener(tabListener);
		actionBar.addTab(tab);
		tab = actionBar.newTab().setText("Smg's").setTabListener(tabListener);
		actionBar.addTab(tab);
		tab = actionBar.newTab().setText("Heavy").setTabListener(tabListener);
		actionBar.addTab(tab);
		getSupportActionBar().setHomeButtonEnabled(false);
		getSupportActionBar().setDisplayHomeAsUpEnabled(false);

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
}
