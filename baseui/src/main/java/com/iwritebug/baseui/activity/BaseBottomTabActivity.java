package com.iwritebug.baseui.activity;

import com.iwritebug.baseui.R;
import com.iwritebug.baseui.adapter.BaseBottomTabAdapter;
import com.iwritebug.baseui.adapter.BaseTabAdapter;
import com.iwritebug.baseui.model.BottomTab;
import com.iwritebug.baseui.widget.TabLayout;

public class BaseBottomTabActivity extends BaseTabActivity<BottomTab> {

    @Override
    protected int onBindView() {
        return R.layout.base_activity_bottom_tab;
    }

    @Override
    public TabLayout getTabLayout() {
        return findViewById(R.id.tabLayout);
    }

    @Override
    public BaseTabAdapter<BottomTab> getAdapter() {
        return new BaseBottomTabAdapter();
    }
}
