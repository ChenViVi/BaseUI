package com.iwritebug.baseui.adapter;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTabAdapter<T>{

    private List<T> mItems = new ArrayList<>();

    public int getCount() {
        return mItems.size();
    }

    public T getItem(int i) {
        return mItems.get(i);
    }

    public abstract View onSelectChanged(View view, int position, T item, boolean isSelected);


    public abstract int getItemId(int position);

    public List<T> getItems() {
        return mItems;
    }

    public void addItem(T item){
        mItems.add(item);
    }
}
