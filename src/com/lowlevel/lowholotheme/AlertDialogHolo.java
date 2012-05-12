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
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AlertDialogHolo extends AlertDialog {
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
	
	
	protected AlertDialogHolo(Context context) {
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
	
	protected AlertDialogHolo(Context context, int theme) {
        super(context, theme);
    }
		
	@Override
	public void show() {
		super.show();
		
		if (VERSION.SDK_INT < MIN_VERSION) {
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
	}

	@Override
	public void setTitle(int textResId) {
		if (VERSION.SDK_INT < MIN_VERSION) {
			mTitle.setText(textResId);
			return;
		}
		
		super.setTitle(textResId);
	}

	@Override
	public void setTitle(CharSequence text) {
		if (VERSION.SDK_INT < MIN_VERSION) {
			mTitle.setText(text);
			return;
		}
		
		super.setTitle(text);
	}

	@Override
	public void setMessage(CharSequence text) {
		if (VERSION.SDK_INT < MIN_VERSION) {
			mMessage.setText(text);
			
			if (mMessage.getText().length() > 0)
				mMessage.setVisibility(View.VISIBLE);
			else 
				mMessage.setVisibility(View.GONE);
			
			return;
		}
		
		super.setMessage(text);
	}

	@Override
	public void setIcon(int drawableResId) {
		if (VERSION.SDK_INT < MIN_VERSION) {
			mIcon.setImageResource(drawableResId);
			return;
		}
		
		super.setIcon(drawableResId);
	}

	@Override
	public void setIcon(Drawable icon) {
		if (VERSION.SDK_INT < MIN_VERSION) {
			mIcon.setImageDrawable(icon);
			return;
		}
		
		super.setIcon(icon);
	}
}
