package com.shell.halo;

import android.os.Bundle;

import com.shell.halo.app.control.AbstractController;
import com.shell.halo.app.control.ControllerHolder;
import com.shell.halo.app.utilities.ThreadUtil;
import com.shell.halo.app.control.Controller;
import com.shell.halo.app.ui.base.WActivity;


public class StartupActivity extends WActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThreadUtil.runAsync(new Runnable() {
            @Override
            public void run() {
                startup();
            }
        });
    }

    private void startup() {
        Controller.class.cast(ControllerHolder.getController(AbstractController.Type.C_MAIN)).setup(this);
        finish();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.startup, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
