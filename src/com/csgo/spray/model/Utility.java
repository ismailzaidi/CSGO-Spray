package com.csgo.spray.model;

import android.content.Context;
import android.graphics.Typeface;
import android.transition.Explode;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Utility {
	private Context context;
	
	public Utility(Context context){
		this.context = context;
	}
	public void setFontForView(ViewGroup viewChildren) {
		Typeface font = Typeface.createFromAsset(context.getAssets(),
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
