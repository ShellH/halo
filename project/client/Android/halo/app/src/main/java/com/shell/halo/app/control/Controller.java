package com.shell.halo.app.control;

import com.shell.halo.app.debug.Trace;
import com.shell.halo.app.ui.MainActivity;
import com.shell.halo.app.ui.base.WActivity;
import com.shell.halo.app.utilities.ActivityUtil;

public final class Controller extends AbstractController{

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
        Trace.Log(this, "xiehao setup");
        mActivity = activity;
        ActivityUtil.jump(mActivity, MainActivity.class);
    }
}