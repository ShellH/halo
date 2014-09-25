package com.shell.halo.app.ui;

import android.widget.EditText;

import com.shell.halo.R;
import com.shell.halo.app.ui.base.WActivity;

public class LoginActivity extends WActivity {

    private EditText mInputName;
    private EditText mInputPassword;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void asyncInit() {

    }
}
