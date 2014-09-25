package com.shell.halo.app.ui.base;

import android.app.Activity;
import android.os.Bundle;

import com.shell.halo.app.control.AbstractController;
import com.shell.halo.app.control.AppEvent;
import com.shell.halo.app.control.EventDispatcher;
import com.shell.halo.app.utilities.ActivityUtil;
import com.shell.halo.app.utilities.ThreadUtil;

public abstract class WActivity extends Activity {

    private EventDispatcher mEventDispatcher;

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
                AbstractController.Type type = getControllerType();
                if (null != type) {
                    mEventDispatcher = new EventDispatcher(getControllerType());
                }
                asyncInit();
            }
        });
    }

    protected void asyncInit() {

    }

    protected int getLayoutResId() {
        return 0;
    }

    protected AbstractController.Type getControllerType() {
        return null;
    }

    protected void postEvent(AppEvent event) {
        if (null == mEventDispatcher) {
            throw new RuntimeException("[" + this.getClass().getName() + "] Override getControllerType before postEvent.");
        }
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
