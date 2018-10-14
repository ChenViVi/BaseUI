package com.iwritebug.baseui.widget;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.iwritebug.baseui.R;
import com.iwritebug.baseui.adapter.BaseTabAdapter;

import java.util.ArrayList;

public class TabLayout extends LinearLayout implements View.OnClickListener{

    private BaseTabAdapter mAdapter;
    private ArrayList<OnTabSelectedListener> listeners = new ArrayList<>();

    public TabLayout(Context context) {
        super(context);
        init();
    }

    public TabLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TabLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TabLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER);
    }

    public void setAdapter(@NonNull BaseTabAdapter adapter) {
        this.mAdapter = adapter;
        if (adapter.getCount() > 0) {
            removeAllViews();
            for(int i = 0; i < adapter.getCount(); i++) {
                View tab = LayoutInflater.from(getContext()).inflate(adapter.getItemId(i),this,false);
                LayoutParams params = (LayoutParams) tab.getLayoutParams();
                params.weight = 1;
                tab.setLayoutParams(params);
                tab.setOnClickListener(this);
                tab.setTag(R.string.key_id,i);
                addView(adapter.onSelectChanged(tab, i, adapter.getItem(i),i == 0));
            }
            for (OnTabSelectedListener listener : listeners)
                listener.onSelectChanged(0);
        }
    }

    @Override
    public void onClick(View view) {
        setSelectedTab((int)view.getTag(R.string.key_id));
    }

    public void setSelectedTab(int position) {
        if (position < getChildCount()) {
            for (int i = 0; i < position; i++){
                mAdapter.onSelectChanged(getChildAt(i), i, mAdapter.getItem(i),false);
            }
            mAdapter.onSelectChanged(getChildAt(position), position,  mAdapter.getItem(position), true);
            if (position + 1 <  getChildCount()) {
                for (int i = position + 1; i < getChildCount(); i++){
                    mAdapter.onSelectChanged(getChildAt(i), i,  mAdapter.getItem(i),false);
                }
            }
        }
        for (OnTabSelectedListener listener : listeners)
            listener.onSelectChanged(position);
    }

    public void addTabSelectedListener(OnTabSelectedListener listener){
        listeners.add(listener);
    }

    public interface OnTabSelectedListener{
        void onSelectChanged(int position);
    }
}
