package com.shell.halo.app.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.shell.halo.R;
import com.shell.halo.app.ui.base.WActivity;

public class MainActivity extends WActivity {

    private TextView mResult;
    private EditText mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mResult = (TextView) findViewById(R.id.show_info);
        mEditor = (EditText) findViewById(R.id.editor);
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
