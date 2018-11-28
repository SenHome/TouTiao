package com.starry.toutiao.module.search.result;

import com.starry.toutiao.bean.news.MultiNewsArticleDataBean;
import com.starry.toutiao.module.base.IBaseListView;
import com.starry.toutiao.module.base.IBasePresenter;

import java.util.List;

/**
 * Created by wangsen on 2018/11/28.
 */
interface ISearchResult {

    interface View extends IBaseListView<Presenter>{

        void onLoadData();
    }


    interface Presenter extends IBasePresenter{

        void doLoadData(String... parameter);

        void doLoadMoreData();

        void doSetAdapter(List<MultiNewsArticleDataBean> dataBean);

        void doShowNoMore();
    }
}
