package com.starry.toutiao.module.video.article;

import com.starry.toutiao.bean.news.MultiNewsArticleDataBean;
import com.starry.toutiao.module.base.IBaseListView;
import com.starry.toutiao.module.base.IBasePresenter;

import java.util.List;

/**
 * Created by wangsen on 2018/11/27.
 */

public interface IVideoArticle {

    interface View extends IBaseListView<Presenter>{

        void onLoadData();
    }

    interface Presenter extends IBasePresenter{

        void doLoadData(String... category);

        void doLoadMoreData();

        void doSetAdapter(List<MultiNewsArticleDataBean> dataBean);
    }


}
