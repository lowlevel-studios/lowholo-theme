package com.lowlevel.lowholotheme;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class DialogHolo extends Dialog {
	/*
	 * Private variables
	 */
	private TextView mTitle;

	
	public DialogHolo(Context context) {
		super(context);

		final View v = View.inflate(context, R.layout.alert_dialog_holo, null);
		
		mTitle = (TextView)v.findViewById(R.id.alertTitle);
		setContentView(v);
	}

	public DialogHolo(Context context, int theme) {
		super(context, theme);

		final View v = View.inflate(context, R.layout.alert_dialog_holo, null);
		
		mTitle = (TextView)v.findViewById(R.id.alertTitle);
		setContentView(v);
	}

	@Override
	public void setTitle(int textResId) {
		mTitle.setText(textResId);
	}

	@Override
	public void setTitle(CharSequence text) {
		mTitle.setText(text);
	}
}