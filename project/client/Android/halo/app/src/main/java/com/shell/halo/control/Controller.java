package com.shell.halo.control;

import com.shell.halo.app.debug.Trace;
import com.shell.halo.app.utilities.ActivityUtil;
import com.shell.halo.control.state.State;
import com.shell.halo.ui.MainActivity;
import com.shell.halo.ui.base.WActivity;

public final class Controller {
    public static boolean gInitialized = false;
    private State mCurrentState;

    private WActivity mActivity;

    public Controller() {

    }

    public void setup(WActivity activity) {
        Trace.Log(this, "xiehao setup");
        gInitialized = true;
        mActivity = activity;
        ActivityUtil.jump(mActivity, MainActivity.class);
    }
}
