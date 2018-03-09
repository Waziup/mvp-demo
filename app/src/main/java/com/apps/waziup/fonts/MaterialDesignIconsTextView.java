package com.apps.waziup.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
* Created by Ceddy Muhoza
**/

public class MaterialDesignIconsTextView extends AppCompatTextView {
	
	private static Typeface sMaterialDesignIcons;

	public MaterialDesignIconsTextView(Context context) {
		this(context, null);
	}

	public MaterialDesignIconsTextView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public MaterialDesignIconsTextView(Context context, AttributeSet attrs, int defStyle) {
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
