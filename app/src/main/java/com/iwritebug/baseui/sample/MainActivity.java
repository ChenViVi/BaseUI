package com.iwritebug.baseui.sample;

import android.view.View;

import com.iwritebug.baseui.activity.BaseActivity;
import com.iwritebug.baseui.sample.activity.BottomTabActivity;
import com.iwritebug.baseui.sample.activity.RecyclerViewActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected int onBindView() {
        return R.layout.activity_main;
    }

    public void onRecyclerViewActivity(View view) {
        startActivity(RecyclerViewActivity.class);
    }

    public void onTestFragment(View view) {
        startActivity(BottomTabActivity.class);
    }
}
