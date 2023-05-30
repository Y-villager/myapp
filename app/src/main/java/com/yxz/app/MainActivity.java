package com.yxz.app;

import android.view.View;
import android.widget.Button;

import com.yxz.app.activity.BaseActivity;
import com.yxz.app.activity.HomeActivity;
import com.yxz.app.activity.LoginActivity;
import com.yxz.app.activity.RegisterActivity;
import com.yxz.app.util.StringUtils;

public class MainActivity extends BaseActivity {

    private Button btnLogin;
    private Button btnRegister;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);
    }

    @Override
    protected void initData() {
        if (!StringUtils.isEmpty(findByKey("token"))) {
            navigateTo(HomeActivity.class);
            finish();
        }
        btnLogin.setOnClickListener(v -> {
//                Intent in = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(in);
            navigateTo(LoginActivity.class);
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent in = new Intent(MainActivity.this, RegisterActivity.class);
//                startActivity(in);
                navigateTo(RegisterActivity.class);
            }
        });
    }
}