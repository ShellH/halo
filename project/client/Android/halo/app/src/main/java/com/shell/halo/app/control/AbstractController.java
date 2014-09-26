package com.shell.halo.app.control;

import com.shell.halo.app.control.event.AppEvent;

public abstract class AbstractController {

    public static enum Type {
        C_MAIN,
        C_STARTUP_M,
        C_LOGIN_M,
        C_MODULE_M,
        C_VIEW_M,
    }

    private AbstractController mParent;
    private static EventDispatcher mEventDispatcher = new EventDispatcher();
    private Type mType;

    AbstractController(Type type) {
        mType = type;
    }

    public Type getType() {
        return mType;
    }

    protected boolean postEvent(AppEvent event) {
        return false;
    }

    public boolean handleUIEvent(AppEvent event) {
        return false;
    }

    public boolean handleEvent(AppEvent event) {
        return false;
    }

}
