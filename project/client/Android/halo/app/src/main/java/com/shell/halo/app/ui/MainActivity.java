package com.shell.halo.app.ui;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.shell.halo.R;
import com.shell.halo.app.ui.base.WActivity;

public class MainActivity extends WActivity {

    private TextView mResult;
    private EditText mEditor;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void asyncInit() {
        mResult = (TextView) findViewById(R.id.show_info);
        mEditor = (EditText) findViewById(R.id.editor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.action_qrcode:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onButtonClicked(View v) {
        switch (v.getId()) {
            case R.id.btn_clean:
                break;
            case R.id.btn_reset:
                break;
            case R.id.btn_invoke:
                break;
            default:
                break;
        }
    }
}
