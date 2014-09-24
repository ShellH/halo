package com.shell.halo.app;

import android.app.Application;

import com.shell.halo.app.ui.base.WActivity;

public class HaloApp extends Application {

    private WActivity mCurrentActivity;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        // mController.onLowMemory();
    }

    private void init() {
        // TODO setup foundation works
    }

    public WActivity getCurrentActivity() {
        return mCurrentActivity;
    }

    public void setCurrentActivity(WActivity activity) {
        mCurrentActivity = activity;
    }

}
