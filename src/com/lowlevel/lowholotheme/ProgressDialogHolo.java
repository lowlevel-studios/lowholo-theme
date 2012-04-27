package com.lowlevel.lowholotheme;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProgressDialogHolo extends ProgressDialog {
	/*
	 * Private variables
	 */
	private Context mContext;
	private TextView mTitle;
	private ImageView mIcon;
	
	public ProgressDialogHolo(Context context) {
		super(context);
		
		mContext = context;

		final View title = View.inflate(context, R.layout.alert_dialog_title, null);
		
		mTitle = (TextView)title.findViewById(R.id.alertTitle);
		mIcon = (ImageView)title.findViewById(R.id.icon);
		
		setCustomTitle(title);
	}
		
	@Override
	public void show() {
		super.show();
		
		final Button positive = getButton(ProgressDialog.BUTTON_POSITIVE);
		final Button negative = getButton(ProgressDialog.BUTTON_NEGATIVE);
		final Button neutral = getButton(ProgressDialog.BUTTON_NEUTRAL);
		
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

	@Override
	public void setIcon(int drawableResId) {
		mIcon.setImageResource(drawableResId);
	}

	@Override
	public void setIcon(Drawable icon) {
		mIcon.setImageDrawable(icon);
	}

	@Override
	public void setProgressStyle(int style) {
		super.setProgressStyle(style);
		
		switch (style) {
		case ProgressDialog.STYLE_HORIZONTAL:
			final Resources res = mContext.getResources();
			
			setProgressDrawable(res.getDrawable(R.drawable.progress_horizontal_holo_dark));
			break;
		}
	}
}
