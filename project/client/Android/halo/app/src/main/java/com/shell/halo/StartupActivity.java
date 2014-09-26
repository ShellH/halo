package com.shell.halo;

import com.shell.halo.app.control.event.AppEvent;
import com.shell.halo.app.control.event.UIEvent;
import com.shell.halo.app.ui.base.WActivity;

public class StartupActivity extends WActivity {
    @Override
    protected void onInitialize() {
        postEvent(new AppEvent.Builder(UIEvent.UI_EVENT_startup).build());
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}
