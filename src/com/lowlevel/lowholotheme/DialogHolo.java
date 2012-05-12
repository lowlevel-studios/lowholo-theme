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