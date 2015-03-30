package com.davisosa.structura.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * A utility class containing helper UI methods.
 */
public final class UIUtils {
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

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
     * Starts the intended activity with the specified transition.
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

    /**
     * Starts the intended activity with the default fade transition.
     *
     * @param act    calling activity
     * @param intent intent
     */
    public static void startActivityWithTransition(Activity act, Intent intent) {
        ActivityOptionsCompat options = ActivityOptionsCompat
                .makeCustomAnimation(act, android.R.anim.fade_in, android.R.anim.fade_out);
        ActivityCompat.startActivity(act, intent, options.toBundle());
    }

    public static Drawable getTintedDrawable(
            Context context, @DrawableRes int drawResId, @ColorRes int colResId) {
        Drawable drawable = ContextCompat.getDrawable(context, drawResId);
        drawable.setColorFilter(context.getResources().getColor(colResId), PorterDuff.Mode.SRC_IN);
        return drawable;
    }

    /**
     * Copyright (C) 2006 The Android Open Source Project
     * <p/>
     * Generate a value suitable for use in {@link android.view.View#setId(int)}.
     * This value will not collide with ID values generated at build time by aapt for R.id.
     * <p/>
     * Note: This is a compatibility shim for API <17.
     *
     * @return a generated ID value
     */
    public static int generateViewId() {
        if (Utils.hasJBMR1()) {
            return View.generateViewId();
        } else {
            for (; ; ) {
                final int result = sNextGeneratedId.get();
                // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
                int newValue = result + 1;
                if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
                if (sNextGeneratedId.compareAndSet(result, newValue)) {
                    return result;
                }
            }
        }
    }
}