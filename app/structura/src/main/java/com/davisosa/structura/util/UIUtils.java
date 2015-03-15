package com.davisosa.structura.util;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
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
        ViewCompat.setImportantForAccessibility(view, ViewCompat.IMPORTANT_FOR_ACCESSIBILITY_NO);
    }

    /**
     * Starts the given activity with the specified transition.
     *
     * @param act            activity whose window contains the shared elements
     * @param intent         intent
     * @param sharedElem     view to transition to the started activity
     * @param transitionName shared element name as used in the target activity
     */
    public static void startActivityWithTransition(
            Activity act, Intent intent, @NonNull View sharedElem, @NonNull String transitionName) {
        ActivityOptionsCompat options = null;
        if (!TextUtils.isEmpty(transitionName)) {
            options = ActivityOptionsCompat
                    .makeSceneTransitionAnimation(act, sharedElem, transitionName);
        }

        ActivityCompat.startActivity(act, intent, (options != null) ? options.toBundle() : null);
    }

    public static Drawable getTintedDrawable(
            Resources res, @DrawableRes int drawResId, @ColorRes int colResId) {
        Drawable drawable = res.getDrawable(drawResId, null);
        drawable.setColorFilter(res.getColor(colResId), PorterDuff.Mode.SRC_IN);
        return drawable;
    }
}