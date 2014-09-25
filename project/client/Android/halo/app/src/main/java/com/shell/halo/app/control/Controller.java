package com.shell.halo.app.control;

import com.shell.halo.app.ui.LoginActivity;
import com.shell.halo.app.ui.base.WActivity;
import com.shell.halo.app.utilities.ActivityUtil;

public final class Controller extends AbstractController {

    public static final int STATE_STARTUP = 1;
    public static final int STATE_LOGIN = 2;
    public static final int STATE_RUNNING = 3;
    public static final int STATE_CLEAN = 4;
    public static final int STATE_SHUTDOWN = 5;

    private WActivity mActivity;
    private int mCurrentState;

    public Controller(Type type) {
        super(type);
    }

    public void setup(WActivity activity) {
        mActivity = activity;
        // TODO
        ActivityUtil.jump(mActivity, LoginActivity.class);
    }

    @Override
    public boolean handleUIEvent(AppEvent event) {
        // TODO
        boolean ret = false;
        switch (event.what) {
            case AppEvent.EVENT_LOGIN:
                login(event);
                ret = true;
                break;
            default:
                break;
        }
        return ret || super.handleUIEvent(event);
    }

    private void login(AppEvent event) {

    }
}
