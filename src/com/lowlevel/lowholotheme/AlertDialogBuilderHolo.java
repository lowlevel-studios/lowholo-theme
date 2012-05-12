/*
 * Copyright (C) 2012 Lowlevel Studios
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lowlevel.lowholotheme;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AlertDialogBuilderHolo extends AlertDialogHolo.Builder {
	/*
	 * Constants
	 */
	private static final int MIN_VERSION = VERSION_CODES.HONEYCOMB;

	/*
	 * Private variables
	 */
	private TextView mTitle;
	private ImageView mIcon;
	private TextView mMessage;
	
	
	public AlertDialogBuilderHolo(Context context) {
		super(context);

		if (VERSION.SDK_INT < MIN_VERSION) {
			final View title = View.inflate(context, R.layout.alert_dialog_title, null);
			
			mTitle = (TextView)title.findViewById(R.id.alertTitle);
			mIcon = (ImageView)title.findViewById(R.id.icon);
			setCustomTitle(title);
			
			final View message = View.inflate(context, R.layout.alert_dialog_message, null);
			
			mMessage = (TextView)message.findViewById(R.id.message);
			setView(message);
		}
	}
	
	@Override
    public AlertDialog show() {
    	final AlertDialog dialog = super.show();
    	
		if (VERSION.SDK_INT < MIN_VERSION) {
			final Button positive = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
			final Button negative = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
			final Button neutral = dialog.getButton(AlertDialog.BUTTON_NEUTRAL);
	
			if (positive != null)
				positive.setBackgroundResource(R.drawable.button_holo);
			if (negative != null)
				negative.setBackgroundResource(R.drawable.button_holo);
			if (neutral != null)
				neutral.setBackgroundResource(R.drawable.button_holo);
			
			Log.w("uMusic", "Positive: " + positive.getHeight());
			Log.w("uMusic", "Negative: " + negative.getHeight());
			Log.w("uMusic", "Neutral: " + neutral.getHeight());
		}
		
		return dialog;
    }

	@Override
	public Builder setTitle(int textResId) {
		if (VERSION.SDK_INT < MIN_VERSION) {
			mTitle.setText(textResId);
			return this;
		}
		
		return super.setTitle(textResId);
	}

	@Override
	public Builder setTitle(CharSequence text) {
		if (VERSION.SDK_INT < MIN_VERSION) {
			mTitle.setText(text);
			return this;
		}
		
		return super.setTitle(text);
	}

	public Builder setMessage(int textResId) {
		if (VERSION.SDK_INT < MIN_VERSION) {
			mMessage.setText(textResId);
			
			if (mMessage.getText().length() > 0)
				mMessage.setVisibility(View.VISIBLE);
			else 
				mMessage.setVisibility(View.GONE);
			
			return this;
		}
		
		return super.setMessage(textResId);
	}

	@Override
	public Builder setMessage(CharSequence text) {
		if (VERSION.SDK_INT < MIN_VERSION) {
			mMessage.setText(text);
			
			if (mMessage.getText().length() > 0)
				mMessage.setVisibility(View.VISIBLE);
			else 
				mMessage.setVisibility(View.GONE);
			
			return this;
		}
		
		return super.setMessage(text);
	}

	@Override
	public Builder setIcon(int drawableResId) {
		if (VERSION.SDK_INT < MIN_VERSION) {
			mIcon.setImageResource(drawableResId);
			return this;
		}
		
		return super.setIcon(drawableResId);
	}

	@Override
	public Builder setIcon(Drawable icon) {
		if (VERSION.SDK_INT < MIN_VERSION) {
			mIcon.setImageDrawable(icon);
			return this;
		}
		
		return super.setIcon(icon);
	}
}
