package com.shell.halo.app;

import android.app.Application;

import com.shell.halo.ui.base.WActivity;

public class HaloApp extends Application {

    private WActivity mCurrentActivity;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
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
