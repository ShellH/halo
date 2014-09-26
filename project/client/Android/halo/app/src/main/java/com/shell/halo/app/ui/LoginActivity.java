package com.shell.halo.app.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.shell.halo.R;
import com.shell.halo.app.control.AppEvent;
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
        mInputName = (EditText) findViewById(R.id.act_login_input_name);
        mInputPassword = (EditText) findViewById(R.id.act_login_input_password);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.act_login_login:
                login();
                break;
            case R.id.act_login_register:
                break;
            case R.id.act_login_forget_pwd:
                break;
        }
    }

    private void login() {
        String name = mInputName.getText().toString();
        String pwd = mInputPassword.getText().toString();
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "no empty name or pwd", Toast.LENGTH_SHORT).show();
            return;
        }

        doLogin(name, pwd);
    }

    private void doLogin(String name, String password) {
        postEvent((new AppEvent.Builder(AppEvent.EVENT_LOGIN)).setStr(name).setObj(password).build());
    }
}
