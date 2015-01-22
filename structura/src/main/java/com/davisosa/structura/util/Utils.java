package com.davisosa.structura.util;

import android.os.Build;

/**
 * A utility class containing static methods.
 */
public final class Utils {
    private Utils() {
        // Private constructor for utility class
    }

    /**
     * Determines if the SDK version is Jelly Bean or higher.
     *
     * @return {@code true} if the SDK version is Jelly Bean or higher;
     * otherwise, returns {@code false}.
     */
    public static boolean hasJB() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }

    /**
     * Determines if the SDK version is Lollipop or higher.
     *
     * @return {@code true} if the SDK version is Lollipop or higher;
     * otherwise, returns {@code false}.
     */
    public static boolean hasLP() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }
}