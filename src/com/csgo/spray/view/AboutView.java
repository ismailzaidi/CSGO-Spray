package com.csgo.spray.view;

import java.util.ArrayList;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.csgo.spray.model.Utility;
import com.csgospray.R;

public class AboutView extends SherlockFragmentActivity {
	private String credit1 = "http://twowordbird.com/";
	private String credit2 = "https://github.com/koush/ion";
	private ArrayList<String> list;
	private ArrayAdapter<String> adapter;
	private Utility utility;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_view);
		populateData();
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		ListView listView = (ListView) findViewById(R.id.creditList);
		adapter = new ArrayAdapter<String>(getBaseContext(),
				R.layout.custom_list_credit, list);
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				Intent intent;
				Log.v("String", "Position: " + position);
				switch (position) {
				case 0:
					intent = new Intent(Intent.ACTION_VIEW, Uri.parse(credit1));
					startActivity(intent);
					break;
				case 1:
					intent = new Intent(Intent.ACTION_VIEW, Uri.parse(credit2));
					startActivity(intent);
					break;
				}
			}
		});
		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.aboutlayout);
		utility = new Utility(this.getApplicationContext());
		utility.setFontForView((ViewGroup) linearLayout);
	}

	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
		}

		return super.onOptionsItemSelected(item);
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
	
	private void populateData() {
		list = new ArrayList<String>();
		list.add("twowordbird (Spray Patterns and Research)");
		list.add("Android Asynchronous Networking and Image Loading");
	}
}
