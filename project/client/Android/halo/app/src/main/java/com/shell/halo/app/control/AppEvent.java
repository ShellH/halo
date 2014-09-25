package com.shell.halo.app.control;

public class AppEvent {
    public static final int EVENT_LOGIN = 1;

    public AppEvent(Builder builder) {
        this.what = builder.what;
        this.arg1 = builder.arg1;
        this.arg2 = builder.arg2;
        this.str = builder.str;
        this.obj = builder.obj;
    }

    public int what;
    public int arg1;
    public int arg2;
    public String str;
    public Object obj;

    public static class Builder {
        private int what;
        private int arg1;
        private int arg2;
        private String str;
        private Object obj;

        public Builder(int what) {
            this.what = what;
        }

        public Builder setArg1(int arg) {
            this.arg1 = arg;
            return this;
        }

        public Builder setArg2(int arg) {
            this.arg1 = arg;
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
