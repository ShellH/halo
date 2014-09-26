package com.shell.halo.app.control.state;

import com.shell.halo.app.control.AbstractController;
import com.shell.halo.app.control.event.AppEvent;
import com.shell.halo.app.control.event.CommonEvent;
import com.shell.halo.app.control.event.UIEvent;

public class StateStartup extends State {

    public StateStartup(AbstractController.Type type) {
        super(type);
    }

    @Override
    public boolean handleUIEvent(AppEvent event) {
        switch (UIEvent.class.cast(event.what)) {
            case UI_EVENT_startup:
                event.what = CommonEvent.COMMON_EVENT_startup;
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
