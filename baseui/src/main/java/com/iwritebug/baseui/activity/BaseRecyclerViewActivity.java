package com.iwritebug.baseui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.iwritebug.baseui.R;
import com.iwritebug.baseui.adapter.BaseAdapter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vivi on 2016/9/3.
 */

public abstract class BaseRecyclerViewActivity<Item, Adapter extends BaseAdapter> extends BaseActivity implements OnRefreshListener, OnLoadMoreListener {

    protected ArrayList<Item> mData = new ArrayList<>();
    protected Adapter mAdapter;
    protected RefreshLayout mRefreshLayout;
    protected RecyclerView mRecyclerView;

    @Override
    protected int onBindView() {
        return R.layout.base_activity_recycle_view;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRefreshLayout = getRefreshLayout();
        mRecyclerView = getRecyclerView();
        mAdapter = setAdapter();
        mRecyclerView.setLayoutManager(setLayoutManager());
        mRecyclerView.setAdapter(mAdapter);
        setPullLoadEnable(false);
        setPullRefreshEnable(false);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadMoreListener(this);
        mAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object item, int position) {
                Item i = (Item) item;
                BaseRecyclerViewActivity.this.onItemClick(view,  position,i);
            }
        });
    }

    protected RecyclerView getRecyclerView() {
        if (mRecyclerView != null)
            return mRecyclerView;
        return findViewById(R.id.recyclerView);
    }

    public RefreshLayout getRefreshLayout() {
        if (mRefreshLayout != null)
            return mRefreshLayout;
        return findViewById(R.id.refreshLayout);
    }

    protected abstract RecyclerView.LayoutManager setLayoutManager();

    protected void setPullLoadEnable(boolean enable) {
        mRefreshLayout.setEnableLoadMore(enable);
    }

    protected void setPullRefreshEnable(boolean enable) {
        mRefreshLayout.setEnableRefresh(enable);
    }

    protected void stopRefresh() {
        mRefreshLayout.finishRefresh();
    }

    protected void stopRefresh(int delay) {
        mRefreshLayout.finishRefresh(delay);
    }

    protected void stopRefresh(int delay, boolean isFinish) {
        mRefreshLayout.finishRefresh(delay, isFinish);
    }

    protected void stopRefresh(boolean isFinish) {
        mRefreshLayout.finishRefresh(isFinish);
    }

    protected void stopLoadMore() {
        mRefreshLayout.finishLoadMore();
    }

    protected void stopLoadMore(int delay) {
        mRefreshLayout.finishLoadMore(delay);
    }

    protected void stopLoadMore(int delay, boolean isFinish, boolean noMoreData) {
        mRefreshLayout.finishLoadMore(delay, isFinish, noMoreData);
    }

    protected void stopLoadMore(boolean isFinish) {
        mRefreshLayout.finishLoadMore(isFinish);
    }

    protected void notifyDataSetChanged(){
        mAdapter.notifyDataSetChanged();
    }

    protected void addItems(List<Item> items) {
        mData.addAll(items);
    }

    protected void clearItems() {
        if (mData.size() > 0) {
            mData.clear();
        }
    }

    protected abstract Adapter setAdapter();

    protected void onItemClick(View view, int position, Item item){

    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshlayout) {

    }
}
