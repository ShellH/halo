package com.shell.halo.app.control.event;

public enum CommonEvent implements IEvent {
    COMMON_EVENT_startup,
    COMMON_EVENT_startup_done,
    COMMON_EVENT_login_done,

    COMMON_EVENT_view_manage_start,
    COMMON_EVENT_switch_activity_splash,
    COMMON_EVENT_switch_activity_main,
    COMMON_EVENT_switch_activity_login,
    COMMON_EVENT_view_manage_end,
}
