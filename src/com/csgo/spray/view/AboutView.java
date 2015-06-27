package com.csgo.spray.view;

import java.util.ArrayList;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.csgo.spray.model.Utility;
import com.csgospray.R;

public class AboutView extends SherlockFragmentActivity {
	private String credit1 = "<a href=\"http://twowordbird.com/\">twowordbird</a>";
	private ArrayList<String> list;
	private ArrayAdapter<String> adapter;
	private Utility utility;
	private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_view);
		populateData();
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		TextView textView = (TextView) findViewById(R.id.url);
		textView.setText(Html.fromHtml(credit1));
		textView.setMovementMethod(LinkMovementMethod.getInstance());
		adapter = new ArrayAdapter<String>(getBaseContext(),
				R.layout.custom_list_credit, list);
		
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
