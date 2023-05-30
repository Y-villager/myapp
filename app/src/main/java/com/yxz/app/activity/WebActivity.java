package com.yxz.app.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;

import com.yxz.app.R;
import com.yxz.app.jsbridge.BridgeHandler;
import com.yxz.app.jsbridge.BridgeWebView;
import com.yxz.app.jsbridge.CallBackFunction;

/**
 * @author: wei
 * @date: 2020-08-17
 **/
@SuppressLint("SetJavaScriptEnabled")
public class WebActivity extends BaseActivity {
    private BridgeWebView bridgeWebView;
    private String url;

    @Override
    protected int initLayout() {
        return R.layout.activity_web;
    }

    @Override
    protected void initView() {
        bridgeWebView = findViewById(R.id.bridgeWebView);
    }

    @Override
    protected void initData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            url = bundle.getString("url");
        }
        registJavaHandler();
        initWebView();
    }

    private void initWebView() {
        WebSettings settings = bridgeWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        bridgeWebView.loadUrl(url);
    }

    private void registJavaHandler() {
        bridgeWebView.registerHandler("goback", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                finish();
            }
        });
    }
}
