package com.lowlevel.lowholotheme;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextViewHolo extends TextView {
	public TextViewHolo(Context context, AttributeSet attrs) {
		super(context, attrs);
		
        setTypeface(Typeface.createFromAsset(context.getAssets(), "Roboto-Regular.ttf"));
	}
}