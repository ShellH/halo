package com.shell.halo.app.control;

import com.shell.halo.app.control.event.AppEvent;
import com.shell.halo.app.control.event.CommonEvent;
import com.shell.halo.app.control.state.State;
import com.shell.halo.app.control.state.StateFactory;
import com.shell.halo.app.ui.base.WActivity;

public final class Controller extends AbstractController {

    private WActivity mActivity;
    private State mCurrentState;

    public Controller() {
        super(Type.C_MAIN);
        setCurrentState(StateFactory.create(StateFactory.Type.E_STARTUP, Type.C_STARTUP_M));
    }

    @Override
    public boolean handleEvent(AppEvent event) {
        switch (CommonEvent.class.cast(event.what)) {
            case COMMON_EVENT_startup_done:
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
