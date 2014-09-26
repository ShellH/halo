package com.shell.halo.app.control;

import com.shell.halo.app.control.event.AppEvent;

public class EventDispatcher {

    private AbstractController.Type mType;

    public EventDispatcher() {
        mType = AbstractController.Type.C_MAIN;
    }

    public EventDispatcher(AbstractController.Type type) {
        mType = type;
    }

    public boolean postUIEvent(AppEvent event) {
        return ControllerHolder.getController(mType).handleUIEvent(event);
    }

    public boolean postEvent(AppEvent event) {
        return ControllerHolder.getController(mType).handleEvent(event);
    }
}
