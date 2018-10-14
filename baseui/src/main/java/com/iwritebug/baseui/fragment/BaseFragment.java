package com.iwritebug.baseui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by vivi on 2016/7/18.
 */
public abstract class BaseFragment extends Fragment{

    protected FragmentActivity mActivity;

    protected View mRootView;

    protected int onBindView(){
        return 0;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
        if (onBindView() != 0) {
            mRootView = LayoutInflater.from(mActivity).inflate(onBindView(),null);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return mRootView;
    }

    protected  <T extends View> T  findViewById(int id){
        return mRootView.findViewById(id);
    }

    protected void toast(String message){
        Toast.makeText(mActivity, message, Toast.LENGTH_SHORT).show();
    }

    protected void toast(int id){
        Toast.makeText(mActivity, getResources().getString(id), Toast.LENGTH_SHORT).show();
    }

    protected void debug() {
        Toast.makeText(mActivity, "debug", Toast.LENGTH_SHORT).show();
    }

    protected void startActivity(Class<?> cls){
        startActivity(new Intent(mActivity, cls));
    }
}
