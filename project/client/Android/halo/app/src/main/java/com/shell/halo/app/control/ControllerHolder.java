package com.shell.halo.app.control;

import android.util.SparseArray;

public class ControllerHolder {

    private static class Holder {
        public static SparseArray<AbstractController> mControllers = new SparseArray<AbstractController>();
    }

    public static AbstractController getController(AbstractController.Type type) {
        AbstractController c = Holder.mControllers.get(type.ordinal());
        if (null == c) {
            c = create(type);
        }
        return c;
    }

    static void releaseController(AbstractController.Type type) {
        Holder.mControllers.remove(type.ordinal());
    }

    private synchronized static AbstractController create(AbstractController.Type type) {
        AbstractController c = Holder.mControllers.get(type.ordinal());
        if (null != c) {
            return c;
        }

        switch (type) {
            case C_MAIN:
                c = new Controller();
                break;
            case C_STARTUP_M:
                c = new StartupManager();
                break;
            case C_VIEW_M:
                c = new ViewManager();
                break;
            default:
                c = null;
                break;
        }

        if (null != c) {
            Holder.mControllers.put(type.ordinal(), c);
        }
        return c;
    }
}
