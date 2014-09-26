package com.shell.halo.app.utilities;

import android.os.*;
import android.os.Process;

public class ThreadUtil {

    // main thread
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

    // working thread
    private static class WorkingThread {
        private static final String NAME = "working_thread";
        private static HandlerThread sHandlerThread = new HandlerThread(NAME, Process.THREAD_PRIORITY_BACKGROUND);
        private static Handler sHandler;
        static {
            sHandlerThread.start();
            sHandler = new Handler(sHandlerThread.getLooper());
        }
    }

    public static void runInWorkingThread(Runnable runnable, long delay) {
        WorkingThread.sHandler.postDelayed(runnable, delay);
    }

    // DB thread
    private static class DBThread {
        private static final String NAME = "database_thread";
        private static HandlerThread sHandlerThread = new HandlerThread(NAME, Process.THREAD_PRIORITY_BACKGROUND);
        private static Handler sHandler;
        static {
            sHandlerThread.start();
            sHandler = new Handler(sHandlerThread.getLooper());
        }
    }

    public static void runInDBThread(Runnable runnable, long delay) {
        DBThread.sHandler.postDelayed(runnable, delay);
    }

}
