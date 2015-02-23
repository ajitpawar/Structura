package com.davisosa.structura.util;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.view.View;

/**
 * A utility class containing helper UI methods.
 */
public final class UIUtils {
    private UIUtils() {
        // Private constructor for utility class
    }

    public static void setAccessibilityIgnore(View view) {
        view.setClickable(false);
        view.setFocusable(false);
        view.setContentDescription("");
        if (Utils.hasJB()) {
            view.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_NO);
        }
    }

    public static Drawable getTintedDrawable(Resources res, @DrawableRes int drawResId,
                                             @ColorRes int colResId) {
        Drawable drawable = res.getDrawable(drawResId);
        drawable.setColorFilter(res.getColor(colResId), PorterDuff.Mode.SRC_IN);
        return drawable;
    }
}