package com.iwritebug.baseui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.iwritebug.baseui.R;
import com.iwritebug.baseui.adapter.BaseTabAdapter;
import com.iwritebug.baseui.widget.TabLayout;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTabActivity<T> extends BaseActivity {

    protected final List<Fragment> mFragmentList = new ArrayList<>();
    protected BaseTabAdapter<T> mAdapter;
    private TabLayout tabLayout;
    private int selectedPosition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = getAdapter();
        tabLayout = getTabLayout();
        onCreateFragments();
        onStartTranslation();
    }

    public abstract TabLayout getTabLayout();

    public abstract BaseTabAdapter<T> getAdapter();

    public void onCreateFragments(){

    }

    public void onStartTranslation(){
        tabLayout.setAdapter(mAdapter);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.loFragmentContent,mFragmentList.get(0));
        for (int i = 1; i < mFragmentList.size(); i++){
            transaction.add(R.id.loFragmentContent,mFragmentList.get(i));
            transaction.hide(mFragmentList.get(i));
        }
        transaction.commit();
        tabLayout.addTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onSelectChanged(int position) {
                showFragment(position);
            }
        });
    }

    public void addFragment(Fragment fragment, T tab){
        mFragmentList.add(fragment);
        mAdapter.addItem(tab);
    }

    private void showFragment(int position) {
        if (position < mFragmentList.size()) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.hide(mFragmentList.get(selectedPosition));
            transaction.show(mFragmentList.get(position));
            selectedPosition = position;
            transaction.commit();
        }
    }

    public int getSelectedPosition() {
        return selectedPosition;
    }

    public void setSelectedPosition(int position){
        if (position < mFragmentList.size()) {
            selectedPosition = position;
            showFragment(position);
        }
    }

    public Fragment getSelectedFragment(){
        return mFragmentList.get(selectedPosition);
    }
}