package com.shell.halo.app.control;

import com.shell.halo.app.control.event.AppEvent;
import com.shell.halo.app.control.event.CommonEvent;
import com.shell.halo.app.foundation.thread.BackgroundTask;
import com.shell.halo.app.ui.LoginActivity;
import com.shell.halo.app.ui.base.WActivity;
import com.shell.halo.app.utilities.ActivityUtil;
import com.shell.halo.app.foundation.thread.ThreadUtil;

public class StartupManager extends AbstractController {

    StartupManager() {
        super(Type.C_STARTUP_M);
    }

    @Override
    public boolean handleUIEvent(AppEvent event) {
        return false;
    }

    @Override
    public boolean handleEvent(AppEvent event) {
        switch (CommonEvent.class.cast(event.what)) {
            case COMMON_EVENT_startup_done:
                startup(WActivity.class.cast(event.from));
                return true;
        }
        return false;
    }

    private void startup(final WActivity activity) {
        new BackgroundTask<Void, Void>() {
            @Override
            public void onPreExecute() {

            }

            @Override
            public Void doInBackground(Void... param) {
                return null;
            }

            @Override
            public void onPostExecute(Void aVoid) {
                doStartup(activity);
            }
        }.execute(ThreadUtil.ThreadEnum.WORKING, 0l, null);
    }

    private void doStartup(final WActivity activity) {
        ActivityUtil.jump(activity, LoginActivity.class);
        activity.finish();
        postEvent(new AppEvent.Builder(CommonEvent.COMMON_EVENT_startup_done).build());
    }

}
