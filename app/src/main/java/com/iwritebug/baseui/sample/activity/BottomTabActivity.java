package com.iwritebug.baseui.sample.activity;

import com.iwritebug.baseui.activity.BaseBottomTabActivity;
import com.iwritebug.baseui.model.BottomTab;
import com.iwritebug.baseui.sample.R;
import com.iwritebug.baseui.sample.fragment.TestFragment;

public class BottomTabActivity extends BaseBottomTabActivity {

    @Override
    public void onCreateFragments() {
        super.onCreateFragments();
        addFragment(new TestFragment(),new BottomTab("1", R.drawable.ic_home_normal,R.drawable.ic_home_checked, R.color.grey, R.color.red));
        addFragment(new TestFragment(),new BottomTab("2",R.drawable.ic_category_normal,R.drawable.ic_category_checked,R.color.grey, R.color.red));
        addFragment(new TestFragment(),new BottomTab("3",R.drawable.ic_cailing_normal,R.drawable.ic_cailing_checked,R.color.grey, R.color.red));
    }
}
