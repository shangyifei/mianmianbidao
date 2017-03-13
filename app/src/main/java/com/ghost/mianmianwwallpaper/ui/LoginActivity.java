package com.ghost.mianmianwwallpaper.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ghost.mianmianwwallpaper.BaseActivity;
import com.ghost.mianmianwwallpaper.R;
import com.ghost.mianmianwwallpaper.entity.UserInfo;
import com.ghost.mianmianwwallpaper.interfaces.LoginCallback;
import com.ghost.mianmianwwallpaper.model.Login;

public class LoginActivity extends BaseActivity {
    private TextView mRegisterTv;
    private Button mLoginBtn;
    private TextInputLayout mUserNameContainer;
    private ContentLoadingProgressBar mLoginPb;
    private TextInputEditText mUserNameEt;
    private TextInputEditText mPassWdEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mRegisterTv = findView(R.id.tv_register);
        mLoginBtn = findView(R.id.btn_login);
        mUserNameContainer = findView(R.id.user_name_container);
        mLoginPb = findView(R.id.pb_login);
        mUserNameEt = findView(R.id.et_user_name);
        mPassWdEt = findView(R.id.et_passwd);
        setupWidget();
    }
    private void setupWidget(){
        mRegisterTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Login login = new Login();
                login.setLoginCallback(new LoginCallback() {
                    @Override
                    public void onFail(String msg) {
                        mLoginPb.hide();
                        mUserNameContainer.setError(msg);
                    }

                    @Override
                    public void onSuccess(UserInfo userInfo) {
                        mLoginPb.hide();
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        finish();
                    }
                });
                mLoginPb.show();
                login.login(mUserNameEt.getText().toString(),mPassWdEt.getText().toString());
            }
        });

    }
}
