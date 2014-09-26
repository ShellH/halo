package com.shell.halo.app.foundation.thread;

import android.os.*;
import android.os.Process;

public class ThreadUtil {

    public enum ThreadEnum {
        MAIN,
        WORKING,
        DB,
        NETWORK,
    }

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
        private static HandlerThread sHandlerThread =
                new HandlerThread(WorkingThread.class.getName(), Process.THREAD_PRIORITY_BACKGROUND);
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
        private static HandlerThread sHandlerThread =
                new HandlerThread(DBThread.class.getName(), Process.THREAD_PRIORITY_BACKGROUND);
        private static Handler sHandler;
        static {
            sHandlerThread.start();
            sHandler = new Handler(sHandlerThread.getLooper());
        }
    }

    public static void runInDBThread(Runnable runnable, long delay) {
        DBThread.sHandler.postDelayed(runnable, delay);
    }

    // network thread
    private static class NetworkThread {
        private static HandlerThread sHandlerThread =
                new HandlerThread(NetworkThread.class.getName(), Process.THREAD_PRIORITY_BACKGROUND);
        private static Handler sHandler;
        static {
            sHandlerThread.start();
            sHandler = new Handler(sHandlerThread.getLooper());
        }
    }

    public static void runInNetworkThread(Runnable runnable, long delay) {
        NetworkThread.sHandler.postDelayed(runnable, delay);
    }

    public static void runAsyncInThread(ThreadEnum thread, Runnable runnable, long delay) {
        switch (thread) {
            case MAIN:
                runAsync(runnable, delay);
                break;
            case WORKING:
                runInWorkingThread(runnable, delay);
                break;
            case DB:
                runInDBThread(runnable, delay);
                break;
            case NETWORK:
                runInNetworkThread(runnable, delay);
                break;
            default:
                break;
        }
    }
}
