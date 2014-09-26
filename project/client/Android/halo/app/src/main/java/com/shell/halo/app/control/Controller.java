package com.shell.halo.app.control;

import com.shell.halo.app.control.state.State;
import com.shell.halo.app.control.state.StateFactory;
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
    private State mCurrentState;

    public Controller(Type type) {
        super(type);
        setCurrentState(StateFactory.create(StateFactory.Type.E_STARTUP, Type.C_STARTUP_M));
    }

    @Override
    public boolean handleEvent(AppEvent event) {
        switch (event.what) {
            case AppEvent.STARTUP_DONE:
                onStartupDone();
                return true;
        }
        return mCurrentState.handleEvent(event);
    }

    @Override
    public boolean handleUIEvent(AppEvent event) {
        return mCurrentState.handleUIEvent(event);
    }

    private void setCurrentState(State state) {
        if (null != mCurrentState) {
            mCurrentState.onExitState();
        }
        mCurrentState = state;
        mCurrentState.onEnterState();
    }

    private void onStartupDone() {
        setCurrentState(StateFactory.create(StateFactory.Type.E_LOGIN, Type.C_LOGIN_M));
    }

    private void login(AppEvent event) {

    }
}
