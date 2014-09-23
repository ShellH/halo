package com.shell.halo.app.utilities;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import com.shell.halo.app.HaloApp;
import com.shell.halo.ui.base.WActivity;

public class ActivityUtil {

    public static void jump(Activity from, Class<?> to, Bundle bundle) {
        Intent intent = new Intent(from, to);
        intent.replaceExtras(bundle);
        from.startActivity(intent);
    }

    public static void jump(Activity from, Class<?> to) {
        Intent intent = new Intent(from, to);
        from.startActivity(intent);
    }

    public static boolean setCurrentActivity(WActivity activity) {
        if (null != activity) {
            Application app = activity.getApplication();
            if (app instanceof HaloApp) {
                ((HaloApp) app).setCurrentActivity(activity);
                return true;
            }
        }
        return false;
    }

    public static boolean clearCurrentActivity(WActivity activity) {
        if (null != activity) {
            Application app = activity.getApplication();
            if (app instanceof HaloApp) {
                HaloApp haloApp = ((HaloApp) app);
                if (haloApp.getCurrentActivity() == activity) {
                    haloApp.setCurrentActivity(null);
                    return true;
                }
            }
        }
        return false;
    }
}
