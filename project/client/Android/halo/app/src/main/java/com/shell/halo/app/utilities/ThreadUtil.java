package com.shell.halo.app.utilities;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by xiehao on 14-9-22.
 */
public class ThreadUtil {
    private static final Handler sHandler = new Handler(Looper.getMainLooper());

    public static boolean isInMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void runAsync(Runnable runnable) {
        runAsync(runnable, 0l);
    }

    public static void runAsync(Runnable runnable, long milliseconds) {
        sHandler.postDelayed(runnable, milliseconds);
    }

    public static void runInMainThread(Runnable runnable) {
        if (isInMainThread()) {
            runnable.run();
            return;
        }
        runAsync(runnable);
    }
}
