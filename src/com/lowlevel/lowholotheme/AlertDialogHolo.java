package com.lowlevel.lowholotheme;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AlertDialogHolo extends AlertDialog {
	/*
	 * Private variables
	 */
	private TextView mTitle;
	private ImageView mIcon;
	private TextView mMessage;
	
	
	protected AlertDialogHolo(Context context) {
		super(context);

		final View title = View.inflate(context, R.layout.alert_dialog_title, null);
		
		mTitle = (TextView)title.findViewById(R.id.alertTitle);
		mIcon = (ImageView)title.findViewById(R.id.icon);
		setCustomTitle(title);
		
		final View message = View.inflate(context, R.layout.alert_dialog_message, null);
		
		mMessage = (TextView)message.findViewById(R.id.message);
		setView(message);
	}
	
	protected AlertDialogHolo(Context context, int theme) {
        super(context, theme);
    }
		
	@Override
	public void show() {
		super.show();
		
		final Button positive = getButton(BUTTON_POSITIVE);
		final Button negative = getButton(BUTTON_NEGATIVE);
		final Button neutral = getButton(BUTTON_NEUTRAL);

		if (positive != null)
			positive.setBackgroundResource(R.drawable.button_holo);
		if (negative != null)
			negative.setBackgroundResource(R.drawable.button_holo);
		if (neutral != null)
			neutral.setBackgroundResource(R.drawable.button_holo);
	}

	@Override
	public void setTitle(int textResId) {
		mTitle.setText(textResId);
	}

	@Override
	public void setTitle(CharSequence text) {
		mTitle.setText(text);
	}

	public void setMessage(int textResId) {
		mMessage.setText(textResId);
		
		if (mMessage.getText().length() > 0)
			mMessage.setVisibility(View.VISIBLE);
		else 
			mMessage.setVisibility(View.GONE);
	}

	@Override
	public void setMessage(CharSequence text) {
		mMessage.setText(text);
		
		if (mMessage.getText().length() > 0)
			mMessage.setVisibility(View.VISIBLE);
		else 
			mMessage.setVisibility(View.GONE);
	}

	@Override
	public void setIcon(int drawableResId) {
		mIcon.setImageResource(drawableResId);
	}

	@Override
	public void setIcon(Drawable icon) {
		mIcon.setImageDrawable(icon);
	}
}
