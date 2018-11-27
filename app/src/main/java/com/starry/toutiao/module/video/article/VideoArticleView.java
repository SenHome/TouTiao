package com.starry.toutiao.module.video.article;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.starry.toutiao.DiffCallback;
import com.starry.toutiao.Register;
import com.starry.toutiao.bean.LoadingBean;
import com.starry.toutiao.module.base.BaseListFragment;
import com.starry.toutiao.module.news.article.INewsArticle;
import com.starry.toutiao.module.news.article.NewsArticlePresenter;
import com.starry.toutiao.utils.OnLoadMoreListener;

import java.util.List;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by wangsen on 2018/11/27.
 */

public class VideoArticleView extends BaseListFragment<INewsArticle.Presenter> implements INewsArticle.View,SwipeRefreshLayout.OnRefreshListener{

    private static final String TAG = "VideoArticleView";
    private String categoryId;

    public static VideoArticleView newInstance(String categoryId) {

        Bundle bundle = new Bundle();
        bundle.putString(TAG,categoryId);
        VideoArticleView videoArticleView = new VideoArticleView();
        videoArticleView.setArguments(bundle);
        return videoArticleView;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        adapter = new MultiTypeAdapter(oldItems);
        Register.registerVideoArticleItem(adapter);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                if(canLoadMore){
                    canLoadMore = false;
                    presenter.doLoadMoreData();
                }
            }
        });
    }

    @Override
    public void setPresenter(INewsArticle.Presenter presenter) {
        if (null == presenter) {
            this.presenter = new NewsArticlePresenter(this);
        }
    }

    @Override
    public void onSetAdapter(List<?> list) {
        Items newItems = new Items(list);
        newItems.add(new LoadingBean());
        DiffCallback.create(oldItems, newItems, adapter);
        oldItems.clear();
        oldItems.addAll(newItems);
        canLoadMore = true;
        recyclerView.stopScroll();
    }

    @Override
    protected void initData() throws NullPointerException {
        categoryId = getArguments().getString(TAG);
    }


    @Override
    public void fetchData() {
        super.fetchData();
        onLoadData();
    }

    @Override
    public void onLoadData() {
        onShowLoading();
        presenter.doLoadData(categoryId);
    }
}
