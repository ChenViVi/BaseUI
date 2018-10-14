package com.iwritebug.baseui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.iwritebug.baseui.BaseApplication;
import com.umeng.analytics.MobclickAgent;

public abstract class BaseActivity extends AppCompatActivity {

    protected BaseActivity mActivity = this;
    protected BaseApplication mApplication;

    protected int onBindView(){
        return 0;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApplication = (BaseApplication) getApplication();
        mApplication.addActivity(mActivity);
        if (onBindView() != 0)
            setContentView(onBindView());
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mApplication.isUMEnable())
            MobclickAgent.onResume(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mApplication.isUMEnable())
            MobclickAgent.onResume(this);
    }

    public void onBack(View view){
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mApplication.removeActivity(mActivity);
    }

    protected void toast(String message) {
        Toast.makeText(mActivity, message, Toast.LENGTH_SHORT).show();
    }

    protected void toast(int id) {
        Toast.makeText(mActivity, getResources().getString(id), Toast.LENGTH_SHORT).show();
    }

    protected void debug() {
        Toast.makeText(mActivity, "debug", Toast.LENGTH_SHORT).show();
    }

    protected void startActivity(Class<?> cls) {
        startActivity(new Intent(mActivity, cls));
    }
}
