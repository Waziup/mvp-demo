package com.apps.waziup.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
* Created by Ceddy Muhoza
**/

public class MaterialDesignIconsEditText extends AppCompatEditText {

	private static Typeface sMaterialDesignIcons;

	public MaterialDesignIconsEditText(Context context) {
		this(context, null);
	}

	public MaterialDesignIconsEditText(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public MaterialDesignIconsEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		if (isInEditMode()) return;//Won't work in Eclipse graphical layout
		setTypeface();
	}
	
	private void setTypeface() {
		if (sMaterialDesignIcons == null) {
			sMaterialDesignIcons = Typeface.createFromAsset(getContext().getAssets(),
					"app/src/app-asset/MaterialDesignIcons.ttf");
		}
		setTypeface(sMaterialDesignIcons);
	}
}
