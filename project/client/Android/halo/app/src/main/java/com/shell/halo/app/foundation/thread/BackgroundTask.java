package com.shell.halo.app.foundation.thread;

public abstract class BackgroundTask<Param, Result> implements Runnable{

    private Param[] mParams;

    @Override
    public void run() {
        final Result result = doInBackground(mParams);
        ThreadUtil.runInMainThread(new Runnable() {
            @Override
            public void run() {
                onPostExecute(result);
            }
        });
    }

    public void execute(ThreadUtil.ThreadEnum thread, long delay, Param... params) {
        mParams = params;
        onPreExecute();
        ThreadUtil.runAsyncInThread(thread, this, delay);
    }

    public abstract void onPreExecute();
    public abstract Result doInBackground(Param... param);
    public abstract void onPostExecute(Result result);
}
