package com.starry.toutiao;

import android.support.annotation.NonNull;

import com.starry.toutiao.bean.LoadingBean;
import com.starry.toutiao.bean.LoadingEndBean;
import com.starry.toutiao.bean.news.MultiNewsArticleDataBean;
import com.starry.toutiao.bean.news.NewsCommentBean;
import com.starry.toutiao.bean.wenda.WendaArticleDataBean;
import com.starry.toutiao.bean.wenda.WendaContentBean;
import com.starry.toutiao.binder.LoadingEndViewBinder;
import com.starry.toutiao.binder.LoadingViewBinder;
import com.starry.toutiao.binder.news.NewsArticleImgViewBinder;
import com.starry.toutiao.binder.news.NewsArticleTextViewBinder;
import com.starry.toutiao.binder.news.NewsArticleVideoViewBinder;
import com.starry.toutiao.binder.news.NewsCommentViewBinder;
import com.starry.toutiao.binder.wenda.WendaArticleOneImgViewBinder;
import com.starry.toutiao.binder.wenda.WendaArticleTextViewBinder;
import com.starry.toutiao.binder.wenda.WendaArticleThreeImgViewBinder;
import com.starry.toutiao.binder.wenda.WendaContentHeaderViewBinder;
import com.starry.toutiao.binder.wenda.WendaContentViewBinder;

import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by Meiji on 2017/6/9.
 */

public class Register {

    public static void registerNewsArticleItem(@NonNull MultiTypeAdapter adapter) {
        // 一个类型对应多个 ItemViewBinder
        adapter.register(MultiNewsArticleDataBean.class)
                .to(new NewsArticleImgViewBinder(),
                        new NewsArticleVideoViewBinder(),
                        new NewsArticleTextViewBinder())
                .withClassLinker((position, item) -> {
                    if (item.isHas_video()) {
                        return NewsArticleVideoViewBinder.class;
                    }
                    if (null != item.getImage_list() && item.getImage_list().size() > 0) {
                        return NewsArticleImgViewBinder.class;
                    }
                    return NewsArticleTextViewBinder.class;
                });
        adapter.register(LoadingBean.class, new LoadingViewBinder());
        adapter.register(LoadingEndBean.class, new LoadingEndViewBinder());
    }

    public static void registerNewsCommentItem(@NonNull MultiTypeAdapter adapter) {
        adapter.register(NewsCommentBean.DataBean.CommentBean.class, new NewsCommentViewBinder());
        adapter.register(LoadingBean.class, new LoadingViewBinder());
        adapter.register(LoadingEndBean.class, new LoadingEndViewBinder());
    }

    public static void registerWendaArticleItem(@NonNull MultiTypeAdapter adapter) {
        // 一个类型对应多个 ItemViewBinder
        adapter.register(WendaArticleDataBean.class)
                .to(new WendaArticleTextViewBinder(),
                        new WendaArticleOneImgViewBinder(),
                        new WendaArticleThreeImgViewBinder())
                .withClassLinker((position, item) -> {
                    if (null != item.getExtraBean().getWenda_image() &&
                            null != item.getExtraBean().getWenda_image().getThree_image_list() &&
                            item.getExtraBean().getWenda_image().getThree_image_list().size() > 0) {
                        return WendaArticleThreeImgViewBinder.class;
                    }
                    if (null != item.getExtraBean().getWenda_image() &&
                            null != item.getExtraBean().getWenda_image().getLarge_image_list() &&
                            item.getExtraBean().getWenda_image().getLarge_image_list().size() > 0) {
                        return WendaArticleOneImgViewBinder.class;
                    }
                    return WendaArticleTextViewBinder.class;
                });
        adapter.register(LoadingBean.class, new LoadingViewBinder());
        adapter.register(LoadingEndBean.class, new LoadingEndViewBinder());
    }

    public static void registerWendaContentItem(@NonNull MultiTypeAdapter adapter) {
        adapter.register(WendaContentBean.QuestionBean.class, new WendaContentHeaderViewBinder());
        adapter.register(WendaContentBean.AnsListBean.class, new WendaContentViewBinder());
        adapter.register(LoadingBean.class, new LoadingViewBinder());
        adapter.register(LoadingEndBean.class, new LoadingEndViewBinder());
    }

}
