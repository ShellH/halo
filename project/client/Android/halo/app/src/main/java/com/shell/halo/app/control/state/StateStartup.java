package com.shell.halo.app.control.state;

import com.shell.halo.app.control.AbstractController;
import com.shell.halo.app.control.AppEvent;

public class StateStartup extends State {

    public StateStartup(AbstractController.Type type) {
        super(type);
    }

    @Override
    public boolean handleUIEvent(AppEvent event) {
        switch (event.what) {
            case AppEvent.STARTUP:
                return getController().handleEvent(event);
        }
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
