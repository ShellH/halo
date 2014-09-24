package com.shell.halo.app.ui.base;

import android.app.Activity;

import com.shell.halo.app.utilities.ActivityUtil;

public class WActivity extends Activity {

    @Override
    protected void onResume() {
        super.onResume();
        ActivityUtil.setCurrentActivity(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        ActivityUtil.clearCurrentActivity(this);
    }
}
