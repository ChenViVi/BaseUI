package com.iwritebug.baseui.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.iwritebug.baseui.R;
import com.iwritebug.baseui.model.BottomTab;

public class BaseBottomTabAdapter extends BaseTabAdapter<BottomTab> {

    public BaseBottomTabAdapter() {
        super();
    }

    @Override
    public View onSelectChanged(View view, int position, BottomTab item, boolean isSelected) {
        TextView name = view.findViewById(R.id.tab_name);
        ImageView icon = view.findViewById(R.id.tab_icon);
        name.setText(item.getTitle());
        if (isSelected){
            name.setTextColor(view.getContext().getResources().getColor(item.getColorIdEnable()));
            icon.setImageResource(item.getImageIdEnable());
        }
        else {
            name.setTextColor(view.getContext().getResources().getColor(item.getColorIdDisable()));
            icon.setImageResource(item.getImageIdInDisable());
        }
        return view;
    }

    @Override
    public int getItemId(int i) {
        return R.layout.base_item_bottom_tab;
    }
}
