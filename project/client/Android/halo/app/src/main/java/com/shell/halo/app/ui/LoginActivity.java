package com.shell.halo.app.ui;

import android.view.View;
import android.widget.EditText;

import com.shell.halo.R;
import com.shell.halo.app.ui.base.WActivity;

public class LoginActivity extends WActivity {

    private EditText mInputName;
    private EditText mInputPassword;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    protected void asyncInit() {

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.act_login_login:
                break;
            case R.id.act_login_register:
                break;
            case R.id.act_login_forget_pwd:
                break;
        }
    }
}
