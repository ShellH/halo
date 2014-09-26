package com.shell.halo.app.control.event;

public class AppEvent {
    public static final int STARTUP = 1;
    public static final int EVENT_LOGIN = 2;

    public static final int STARTUP_DONE = 2001;
    public static final int LOGIN_DONE = 2002;

    public Object from;
    public IEvent what;
    public int arg1;
    public int arg2;
    public String str;
    public Object obj;

    public AppEvent(Builder builder) {
        this.from = builder.from;
        this.what = builder.what;
        this.arg1 = builder.arg1;
        this.arg2 = builder.arg2;
        this.str = builder.str;
        this.obj = builder.obj;
    }

    public static class Builder {
        private Object from;
        private IEvent what;
        private int arg1;
        private int arg2;
        private String str;
        private Object obj;

        public Builder(IEvent what) {
            this.what = what;
        }

        public Builder setFrom(Object from) {
            this.from = from;
            return this;
        }

        public Builder setArg1(int arg) {
            this.arg1 = arg;
            return this;
        }

        public Builder setArg2(int arg) {
            this.arg2 = arg;
            return this;
        }

        public Builder setStr(String str) {
            this.str = str;
            return this;
        }

        public Builder setObj(Object obj) {
            this.obj = obj;
            return this;
        }

        public AppEvent build() {
            return new AppEvent(this);
        }
    }
}
