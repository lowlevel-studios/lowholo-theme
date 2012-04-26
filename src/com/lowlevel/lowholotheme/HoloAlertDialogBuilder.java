package com.lowlevel.lowholotheme;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HoloAlertDialogBuilder extends AlertDialog.Builder {
	/*
	 * Private variables
	 */
	private TextView mTitle;
	private ImageView mIcon;
	private TextView mMessage;

	
	public HoloAlertDialogBuilder(Context context) {
		super(context);
		
		final Boolean useFullLayout = true;

		if (useFullLayout) {
			final View title = View.inflate(context, R.layout.alert_dialog_title, null);
			
			mTitle = (TextView)title.findViewById(R.id.alertTitle);
			mIcon = (ImageView)title.findViewById(R.id.icon);
			setCustomTitle(title);
			
			final View message = View.inflate(context, R.layout.alert_dialog_message, null);
			
			mMessage = (TextView)message.findViewById(R.id.message);
			setView(message);
		} else {
			final View view = View.inflate(context, R.layout.alert_dialog_holo, null);
			
			mTitle = (TextView)view.findViewById(R.id.alertTitle);
			mIcon = (ImageView)view.findViewById(R.id.icon);
			mMessage = (TextView)view.findViewById(R.id.message);
			
			setView(view);
		}
	}

	@Override
	public HoloAlertDialogBuilder setTitle(int textResId) {
		mTitle.setText(textResId);
		return this;
	}

	@Override
	public HoloAlertDialogBuilder setTitle(CharSequence text) {
		mTitle.setText(text);
		return this;
	}

	@Override
	public HoloAlertDialogBuilder setMessage(int textResId) {
		mMessage.setText(textResId);
		
		if (mMessage.getText().length() > 0)
			mMessage.setVisibility(View.VISIBLE);
		else 
			mMessage.setVisibility(View.GONE);

		return this;
	}

	@Override
	public HoloAlertDialogBuilder setMessage(CharSequence text) {
		mMessage.setText(text);
		
		if (mMessage.getText().length() > 0)
			mMessage.setVisibility(View.VISIBLE);
		else 
			mMessage.setVisibility(View.GONE);
		
		return this;
	}

	@Override
	public HoloAlertDialogBuilder setIcon(int drawableResId) {
		mIcon.setImageResource(drawableResId);
		return this;
	}

	@Override
	public HoloAlertDialogBuilder setIcon(Drawable icon) {
		mIcon.setImageDrawable(icon);
		return this;
	}

	
//	@Override
//	public AlertDialog create() {
//		final AlertDialog dialog = super.create();
//		
//		final Button positive = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
//		final Button negative = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
//		final Button neutral = dialog.getButton(AlertDialog.BUTTON_NEUTRAL);
//		
//		if (positive != null)
//			positive.setBackgroundResource(R.drawable.button_holo);
//		if (negative != null)
//			negative.setBackgroundResource(R.drawable.button_holo);
//		if (neutral != null)
//			neutral.setBackgroundResource(R.drawable.button_holo);
//		
//		return dialog;
//	}	
}