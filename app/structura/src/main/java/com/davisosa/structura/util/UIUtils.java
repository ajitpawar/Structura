package com.davisosa.structura.util;

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
}