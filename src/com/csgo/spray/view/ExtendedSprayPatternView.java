package com.csgo.spray.view;

import com.csgo.spray.model.DisableSwipeViewPager;
import com.csgo.spray.tabfragments.SprayPatternFragmentTab;
import com.csgospray.R;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ExtendedSprayPatternView extends AppCompatActivity {
	private DisableSwipeViewPager viewPager;
	private String key = "com.csgo.spray.SprayPatternView";
	private String weapon;
	private TabLayout tablayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.extended_spray_view);
		weapon = this.getIntent().getStringExtra(key);
		viewPager = (DisableSwipeViewPager) findViewById(R.id.spraypager);
		tablayout = (TabLayout) findViewById(R.id.sliding_tabs);
		viewPager.setPagingEnabled(true);
		FragmentManager fm = getSupportFragmentManager();
		SprayPagerAdapter adapter = new SprayPagerAdapter(fm);
		viewPager.setAdapter(adapter);
		tablayout.setupWithViewPager(viewPager);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setHomeAsUpIndicator(R.drawable.ic_launcher_back);
		actionBar.setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = this.getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent;
		switch (item.getItemId()) {
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
		private String[] fragment_titles = { "Spray Pattern", "Anti Pattern", "Inverted Pattern", "Spray (Scoped)",
				"Anti (Scoped)", "Inverted (Scoped)" };

		public SprayPagerAdapter(FragmentManager fm) {
			super(fm);
		}

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
			case 3:
				SprayPatternFragmentTab fragmentFour = SprayPatternFragmentTab.InstanceOf(weapon + "_scoped_p");
				return fragmentFour;
			case 4:
				SprayPatternFragmentTab fragmentFive = SprayPatternFragmentTab.InstanceOf(weapon + "_scoped_c");
				return fragmentFive;
			case 5:
				SprayPatternFragmentTab fragmentSix = SprayPatternFragmentTab.InstanceOf(weapon + "_scoped_i");
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

		@Override
		public CharSequence getPageTitle(int position) {
			// TODO Auto-generated method stub
			return fragment_titles[position];
		}
	}
}
