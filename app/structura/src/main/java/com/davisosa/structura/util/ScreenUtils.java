package com.davisosa.structura.util;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * A utility class containing helper methods for working with different screen sizes.
 */
public class ScreenUtils {
    private ScreenUtils() {
        // Private constructor for utility class
    }

    public static float convertDpToPx(Context context, float dp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, metrics);
    }

    public static float convertPxToDp(Context context, float px) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return px / (metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public static int getDisplayWidthPx(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getDisplayHeightPx(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getDisplayWidthDp(Context context) {
        return context.getResources().getConfiguration().screenWidthDp;
    }

    public static int getDisplayHeightDp(Context context) {
        return context.getResources().getConfiguration().screenHeightDp;
    }

    public static boolean isLandscape(Context context) {
        Configuration config = context.getResources().getConfiguration();
        return config.orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    /**
     * @return The size of the screen as a
     * {@link android.content.res.Configuration#SCREENLAYOUT_SIZE_MASK}.
     */
    public static int getScreenSize(Context context) {
        Configuration config = context.getResources().getConfiguration();
        return config.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
    }

    public static boolean hasSmallScreen(Context context) {
        return getScreenSize(context) == Configuration.SCREENLAYOUT_SIZE_SMALL;
    }

    public static boolean hasNormalScreen(Context context) {
        return getScreenSize(context) == Configuration.SCREENLAYOUT_SIZE_NORMAL;
    }

    public static boolean hasLargeScreen(Context context) {
        return getScreenSize(context) == Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    public static boolean hasXLargeScreen(Context context) {
        return getScreenSize(context) == Configuration.SCREENLAYOUT_SIZE_XLARGE;
    }
}