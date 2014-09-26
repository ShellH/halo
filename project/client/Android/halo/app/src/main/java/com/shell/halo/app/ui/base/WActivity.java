package com.shell.halo.app.ui.base;

import android.app.Activity;
import android.os.Bundle;

import com.shell.halo.app.control.event.AppEvent;
import com.shell.halo.app.control.EventDispatcher;
import com.shell.halo.app.utilities.ActivityUtil;
import com.shell.halo.app.foundation.thread.ThreadUtil;

public abstract class WActivity extends Activity {

    private static EventDispatcher mEventDispatcher = new EventDispatcher();

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
        onInitialize();
        ThreadUtil.runAsync(new Runnable() {
            @Override
            public void run() {
                asyncInit();
            }
        });
    }

    protected void onInitialize() {}

    protected void asyncInit() {}

    protected int getLayoutResId() {
        return 0;
    }

    protected void postEvent(AppEvent event) {
        event.from = this;
        mEventDispatcher.postUIEvent(event);
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
