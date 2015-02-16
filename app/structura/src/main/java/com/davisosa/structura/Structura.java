package com.davisosa.structura;

import android.app.Application;
import android.os.StrictMode;

import timber.log.Timber;

/**
 * An {@link android.app.Application} class that declares custom configurations.
 */
public class Structura extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            StrictMode.enableDefaults();
        }

        Timber.plant(BuildConfig.DEBUG ? new Timber.DebugTree() : new Timber.HollowTree());
    }
}