package com.shell.halo.app.control.state;

import com.shell.halo.app.control.AbstractController;

public class StateFactory {

    public enum Type {
        E_STARTUP,
        E_LOGIN,
        E_RUNNING,
        E_CLEAN,
        E_SHUTDOWN,
    }

    public static State create(Type type, AbstractController.Type ctype) {
        switch (type) {
            case E_STARTUP:
                return new StateStartup(ctype);
            case E_LOGIN:
                return new StateLogin(ctype);
            default:
                return null;
        }
    }
}
