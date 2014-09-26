package com.shell.halo.app.control.state;

import com.shell.halo.app.control.AbstractController;
import com.shell.halo.app.control.AppEvent;
import com.shell.halo.app.control.ControllerHolder;

public abstract class State {

    protected AbstractController.Type mCType;

    public State(AbstractController.Type type) {
        mCType = type;
    }

    protected AbstractController getController() {
        return ControllerHolder.getController(mCType);
    }

    public abstract boolean handleUIEvent(AppEvent event);
    public abstract boolean handleEvent(AppEvent event);
    public abstract void onEnterState();
    public abstract void onExitState();
}
