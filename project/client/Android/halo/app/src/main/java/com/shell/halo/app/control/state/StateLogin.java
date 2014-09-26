package com.shell.halo.app.control.state;

import com.shell.halo.app.control.AbstractController;
import com.shell.halo.app.control.event.AppEvent;

public class StateLogin extends State {

    public StateLogin(AbstractController.Type type) {
        super(type);
    }

    @Override
    public boolean handleUIEvent(AppEvent event) {
        return false;
    }

    @Override
    public boolean handleEvent(AppEvent event) {
        return false;
    }

    @Override
    public void onEnterState() {

    }

    @Override
    public void onExitState() {

    }
}
