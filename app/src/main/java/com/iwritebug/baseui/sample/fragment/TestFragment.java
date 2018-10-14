package com.iwritebug.baseui.sample.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.iwritebug.baseui.fragment.BaseFragment;
import com.iwritebug.baseui.sample.R;

public class TestFragment extends BaseFragment{

    protected int onBindView(){
        return R.layout.fragment_test;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView tvTip = findViewById(R.id.tvTip);
        tvTip.setText(String.valueOf(Math.random() * 100));
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
