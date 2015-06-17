package com.csgo.spray.view;

import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.csgospray.R;

public class WhyPatternView extends SherlockFragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.why_pattern_view);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		ScrollView view = (ScrollView) findViewById(R.id.scrollView1);
		setFontForView(view);
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

	public void setFontForView(ViewGroup viewChildren) {
		Typeface font = Typeface.createFromAsset(this.getAssets(),
				"Roboto-Black.ttf");
		View child;
		for (int i = 0; i < viewChildren.getChildCount(); i++) {
			child = viewChildren.getChildAt(i);
			if (child instanceof ViewGroup) {
				setFontForView((ViewGroup) child);

			} else if (child instanceof TextView) {
				((TextView) child).setTypeface(font);
				;
			} else if (child instanceof Button) {
				((Button) child).setTypeface(font);
				;
			}

		}
	}
}
