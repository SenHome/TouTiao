package com.starry.toutiao.module.news.comment;

import com.starry.toutiao.bean.news.NewsCommentBean;
import com.starry.toutiao.module.base.IBaseListView;
import com.starry.toutiao.module.base.IBasePresenter;

import java.util.List;

/**
 * Created by Meiji on 2016/12/20.
 */

public interface INewsComment {

    interface View extends IBaseListView<Presenter> {

        /**
         * 请求数据
         */
        void onLoadData();
    }

    interface Presenter extends IBasePresenter {

        /**
         * 请求数据
         */
        void doLoadData(String... groupId_ItemId);

        /**
         * 再起请求数据
         */
        void doLoadMoreData();

        /**
         * 设置适配器
         */
        void doSetAdapter(List<NewsCommentBean.DataBean.CommentBean> list);

        /**
         * 加载完毕
         */
        void doShowNoMore();
    }
}
