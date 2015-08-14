package com.csgo.spray.view;

import com.csgo.spray.adapter.ViewPagerAdapter;
import com.csgo.spray.model.DisableSwipeViewPager;
import com.csgospray.R;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;

public class MainActivity extends AppCompatActivity {
	private DisableSwipeViewPager viewPager;
	private TabLayout tabLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_view);
		viewPager = (DisableSwipeViewPager) findViewById(R.id.pager);
		tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
		viewPager.setPagingEnabled(true);
		FragmentManager fm = getSupportFragmentManager();
		ViewPagerAdapter adapter = new ViewPagerAdapter(fm);
		viewPager.setAdapter(adapter);
		tabLayout.setupWithViewPager(viewPager);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setHomeAsUpIndicator(R.drawable.ic_launcher);
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
		switch (item.getItemId()) {
		case R.id.about_icon:
			FragmentManager fm = this.getSupportFragmentManager();
			AboutView aboutDialog = AboutView.newInstance();
			aboutDialog.show(fm, "com.mainActivity.spray");
			return true;
		default:
			return true;
		}
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
