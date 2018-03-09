package com.apps.waziup.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

/**
* Created by Ceddy Muhoza
**/

public class MaterialDesignIconsButton extends AppCompatButton {

	private static Typeface sMaterialDesignIcons;

	public MaterialDesignIconsButton(Context context) {
		this(context, null);
	}

	public MaterialDesignIconsButton(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public MaterialDesignIconsButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		if (isInEditMode()) return;//Won't work in Eclipse graphical layout
		setTypeface();
	}
	
	private void setTypeface() {
		if (sMaterialDesignIcons == null) {
			sMaterialDesignIcons = Typeface.createFromAsset(getContext().getAssets(),
					"fonts/MaterialDesignIcons.ttf");
		}
		setTypeface(sMaterialDesignIcons);
	}
}
