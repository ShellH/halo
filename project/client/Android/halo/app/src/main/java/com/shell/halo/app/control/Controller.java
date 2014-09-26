package com.shell.halo.app.control;

import com.shell.halo.app.control.event.AppEvent;
import com.shell.halo.app.control.event.CommonEvent;
import com.shell.halo.app.control.state.State;
import com.shell.halo.app.control.state.StateFactory;

public final class Controller extends AbstractController {

    private State mCurrentState;

    public Controller() {
        super(Type.C_MAIN);
        setCurrentState(StateFactory.create(StateFactory.Type.E_STARTUP, Type.C_STARTUP_M));
    }

    private void setCurrentState(State state) {
        if (mCurrentState == state) {
            return;
        }
        if (null != mCurrentState) {
            mCurrentState.onExitState();
        }
        mCurrentState = state;
        mCurrentState.onEnterState();
    }

    @Override
    public boolean handleEvent(AppEvent event) {
        CommonEvent ev = CommonEvent.class.cast(event.what);
        if (ev.compareTo(CommonEvent.COMMON_EVENT_view_manage_start) > 0
                && ev.compareTo(CommonEvent.COMMON_EVENT_view_manage_end) < 0) {
            return handleViewManageEvent(event);
        }
        switch (ev) {
            case COMMON_EVENT_startup_done:
                onStartupDone(event);
                return true;
        }
        return mCurrentState.handleEvent(event);
    }

    @Override
    public boolean handleUIEvent(AppEvent event) {
        return mCurrentState.handleUIEvent(event);
    }

    private boolean handleViewManageEvent(AppEvent event) {
        return ControllerHolder.getController(Type.C_VIEW_M).handleEvent(event);
    }

    private void onStartupDone(AppEvent event) {
        setCurrentState(StateFactory.create(StateFactory.Type.E_LOGIN, Type.C_LOGIN_M));
        event.what = CommonEvent.COMMON_EVENT_switch_activity_login;
        handleViewManageEvent(event);
    }

    private void login(AppEvent event) {

    }
}
