package com.shell.halo.app.ui.base;

import android.app.Activity;
import android.os.Bundle;

import com.shell.halo.app.utilities.ActivityUtil;
import com.shell.halo.app.utilities.ThreadUtil;

public class WActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    protected void init() {
        int resId = getLayoutResId();
        if (resId > 0) {
            setContentView(resId);
        }
        ThreadUtil.runAsync(new Runnable() {
            @Override
            public void run() {
                asyncInit();
            }
        });
    }

    protected void asyncInit() {}

    protected int getLayoutResId() {
        return 0;
    }

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
