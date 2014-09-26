package com.shell.halo.app.control;

import com.shell.halo.app.ui.LoginActivity;
import com.shell.halo.app.ui.base.WActivity;
import com.shell.halo.app.utilities.ActivityUtil;
import com.shell.halo.app.utilities.ThreadUtil;

public class StartupManager extends AbstractController {

    StartupManager(Type type) {
        super(type);
    }

    @Override
    public boolean handleUIEvent(AppEvent event) {
        return super.handleUIEvent(event);
    }

    @Override
    public boolean handleEvent(AppEvent event) {
        switch (event.what) {
            case AppEvent.STARTUP:
                startup(WActivity.class.cast(event.from));
                return true;
        }
        return false;
    }

    private void startup(final WActivity activity) {
        ThreadUtil.runAsync(new Runnable() {
            @Override
            public void run() {
                doStartup(activity);
            }
        });
    }

    private void doStartup(final WActivity activity) {
        ActivityUtil.jump(activity, LoginActivity.class);
        activity.finish();
        postEvent(new AppEvent.Builder(AppEvent.STARTUP_DONE).build());
    }
}
