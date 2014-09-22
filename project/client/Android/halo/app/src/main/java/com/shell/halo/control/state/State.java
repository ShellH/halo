package com.shell.halo.control.state;

/**
 * Created by xiehao on 14-9-22.
 */
public abstract class State {
    public abstract void onInvoke();
    protected void onEnterState(){}
    protected void onExitState(){}
}
