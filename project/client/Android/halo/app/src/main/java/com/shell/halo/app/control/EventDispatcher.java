package com.shell.halo.app.control;

/**
 * Created by xiehao on 14-9-25.
 */
public class EventDispatcher {

    private AbstractController.Type mType;

    public EventDispatcher(AbstractController.Type type) {
        mType = type;
    }

    public boolean postUIEvent(AppEvent event) {
        return ControllerHolder.getController(mType).handleUIEvent(event);
    }
}
