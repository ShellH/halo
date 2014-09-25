package com.shell.halo.app.control;

public abstract class AbstractController {

    private AbstractController mParent;

    public static enum Type {
        C_MAIN,
        C_STARTUP_M,
        C_MODULE_M,
        C_VIEW_M,
    }

    private Type mType;

    AbstractController(Type type) {
        mType = type;
    }

    public Type getType() {
        return mType;
    }

    public boolean handleUIEvent(AppEvent event) {
        return mParent.handleUIEvent(event);
    }

}
