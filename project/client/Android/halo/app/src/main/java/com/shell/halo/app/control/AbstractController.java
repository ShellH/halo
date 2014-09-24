package com.shell.halo.app.control;

public class AbstractController {
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
}
