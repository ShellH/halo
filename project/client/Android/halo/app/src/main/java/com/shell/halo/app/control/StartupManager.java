package com.shell.halo.app.control;

import com.shell.halo.app.control.event.AppEvent;
import com.shell.halo.app.control.event.CommonEvent;
import com.shell.halo.app.foundation.thread.BackgroundTask;
import com.shell.halo.app.ui.base.WActivity;
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
            case COMMON_EVENT_startup:
                startup(WActivity.class.cast(event.from));
                return true;
        }
        return false;
    }

    private void startup(final WActivity activity) {
        new BackgroundTask<Void, Void>() {
            @Override
            public void onPreExecute() {
                postEvent(new AppEvent.Builder(CommonEvent.COMMON_EVENT_switch_activity_splash).setObj(activity).build());
            }

            @Override
            public Void doInBackground(Void... param) {
                doStartup();
                // FIXME
                try {
                    Thread.sleep(2000l);
                } catch (Exception e) {

                }
                return null;
            }

            @Override
            public void onPostExecute(Void aVoid) {
                postEvent(new AppEvent.Builder(CommonEvent.COMMON_EVENT_startup_done).build());
            }
        }.execute(ThreadUtil.ThreadEnum.WORKING, 0l, null);
    }

    private void doStartup() {
        // TODO
    }
}
