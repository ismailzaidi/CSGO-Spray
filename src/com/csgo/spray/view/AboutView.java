package com.csgo.spray.view;

import com.csgo.spray.model.Utility;
import com.csgospray.R;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AboutView extends DialogFragment {
	private String credit1 = "<a href=\"http://twowordbird.com/\">twowordbird</a>";
	private String credit2 = "<a href=\"http://ismailzd.co.uk/\">developer</a>";
	private String credit3 = "<a href=\"http://steamcommunity.com/sharedfiles/filedetails/?id=419404847\">Recoil Master (CSGO Map)</a>";
	private Utility utility;
	private TextView creditOne, creditTwo, creditThree;

	public static AboutView newInstance() {
		AboutView fragment = new AboutView();
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setStyle(DialogFragment.STYLE_NO_TITLE, R.style.Theme_AppCompat_Light_Dialog);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View aboutView = inflater.inflate(R.layout.about_view, container, false);
		setCancelable(true);
		creditOne = (TextView) aboutView.findViewById(R.id.url);
		creditTwo = (TextView) aboutView.findViewById(R.id.url1);
		creditThree = (TextView) aboutView.findViewById(R.id.url3);
		setUpLinkForCredit();
		LinearLayout linearLayout = (LinearLayout) aboutView.findViewById(R.id.aboutlayout);
		LinearLayout returnButton = (LinearLayout) aboutView.findViewById(R.id.returnButton);
		returnButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getDialog().dismiss();
			}
		});
		utility = new Utility(this.getActivity().getApplicationContext());
		utility.setFontForView((ViewGroup) linearLayout);
		return aboutView;
	}

	private void setUpLinkForCredit() {
		creditOne.setText(Html.fromHtml(credit1));
		creditOne.setMovementMethod(LinkMovementMethod.getInstance());
		creditTwo.setText(Html.fromHtml(credit2));
		creditTwo.setMovementMethod(LinkMovementMethod.getInstance());
		creditThree.setText(Html.fromHtml(credit3));
		creditThree.setMovementMethod(LinkMovementMethod.getInstance());
	}
}
