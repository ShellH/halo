package com.shell.halo.app.debug;

import android.util.Log;

/**
 * Created by xiehao on 14-9-23.
 */
public class Trace {
    private static final boolean DEBUG = true;

    public static void Log(Object obj, String msg) {
        if (DEBUG) {
            Log.d(obj.getClass().getName(), msg);
        }
    }
}
