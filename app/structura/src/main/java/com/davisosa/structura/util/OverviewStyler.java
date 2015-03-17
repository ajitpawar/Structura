package com.davisosa.structura.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;

import com.davisosa.structura.R;

/**
 * Helper class that applies the proper icon, title and background color to the overview list.
 */
public class OverviewStyler {
    private static Bitmap sIcon = null;

    private OverviewStyler() {
        // Private constructor for helper class
    }

    /**
     * Applies the proper icon, title and background color to the overview list
     * for a given activity.
     *
     * @param act activity
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void styleOverviewEntry(Activity act) {
        if (!Utils.hasLP()) {
            return;
        }

        Resources res = act.getResources();
        String label = res.getString(act.getApplicationInfo().labelRes);
        int colorPrimary = res.getColor(R.color.theme_primary);

        if (sIcon == null) {
            // Cache bitmap to avoid decoding it on every activity change.
            sIcon = BitmapFactory.decodeResource(res, R.mipmap.ic_launcher);
        }

        act.setTaskDescription(new ActivityManager.TaskDescription(label, sIcon, colorPrimary));
    }
}