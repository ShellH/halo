package com.shell.halo.app.control;

import android.app.Activity;
import android.os.Bundle;

import com.shell.halo.app.HaloApp;
import com.shell.halo.app.control.event.AppEvent;
import com.shell.halo.app.control.event.CommonEvent;
import com.shell.halo.app.ui.LoginActivity;
import com.shell.halo.app.ui.SplashActivity;
import com.shell.halo.app.ui.base.WActivity;
import com.shell.halo.app.utilities.ActivityUtil;

public class ViewManager extends AbstractController {

    private WActivity mActivity;

    ViewManager() {
        super(Type.C_VIEW_M);
    }

    @Override
    public boolean handleEvent(AppEvent event) {
        switch (CommonEvent.class.cast(event.what)) {
            case COMMON_EVENT_switch_activity_splash:
                mActivity = WActivity.class.cast(event.obj);
                switchActivity(mActivity, SplashActivity.class, null, true);
                break;
            case COMMON_EVENT_switch_activity_login:
                switchActivity(getCurrentActivity(), LoginActivity.class, null, true);
                break;
            case COMMON_EVENT_switch_activity_main:
                break;
        }
        return false;
    }

    private WActivity getCurrentActivity() {
        HaloApp app = HaloApp.class.cast(mActivity.getApplication());
        mActivity = app.getCurrentActivity();
        return mActivity;
    }

    private void switchActivity(Activity from, Class<?> to, Bundle bundle, boolean finish) {
        ActivityUtil.jump(from, to, bundle);
        if (finish) {
            from.finish();
        }
    }
}
