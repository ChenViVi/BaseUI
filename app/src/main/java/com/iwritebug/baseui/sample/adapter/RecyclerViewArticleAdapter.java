package com.iwritebug.baseui.sample.adapter;

import android.app.Activity;


import com.iwritebug.baseui.adapter.BaseAdapter;
import com.iwritebug.baseui.adapter.BaseViewHolder;
import com.iwritebug.baseui.sample.R;
import com.iwritebug.baseui.sample.modle.Article;

import java.util.List;

/**
 * Created by vivi on 2016/8/10.
 */
public class RecyclerViewArticleAdapter extends BaseAdapter<Article> {

    public RecyclerViewArticleAdapter(Activity activity, List<Article> data) {
        super(activity, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, Article item, int position) {
        holder.setText(R.id.tvTitle, item.getTitle());
    }

    @Override
    protected int getItemViewLayoutId(int viewType) {
        return R.layout.item_article;
    }
}