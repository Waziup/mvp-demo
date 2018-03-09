package com.apps.waziup.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by KidusMT on 3/09/2017.
 */

public class MaterialDesignIconsEditText extends android.support.v7.widget.AppCompatEditText {

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
					"fonts/MaterialDesignIcons.ttf");
		}
		setTypeface(sMaterialDesignIcons);
	}
}
