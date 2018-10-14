package com.iwritebug.baseui.adapter;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTabAdapter<Item>{

    private List<Item> mItems = new ArrayList<>();

    public int getCount() {
        return mItems.size();
    }

    public Item getItem(int i) {
        return mItems.get(i);
    }

    public abstract View onSelectChanged(View view, int position, Item item, boolean isSelected);


    public abstract int getItemId(int position);

    public List<Item> getItems() {
        return mItems;
    }

    public void addItem(Item item){
        mItems.add(item);
    }
}
