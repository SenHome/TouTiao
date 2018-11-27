package com.starry.toutiao.module.wenda.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.starry.toutiao.InitApp;
import com.starry.toutiao.R;
import com.starry.toutiao.bean.wenda.WendaContentBean;
import com.starry.toutiao.module.base.BaseActivity;

/**
 * Created by Meiji on 2017/5/23.
 */

public class WendaDetailActivity extends BaseActivity{

    private static final String TAG = "WendaDetailActivity";

    public static void launch(WendaContentBean.AnsListBean bean) {
        InitApp.AppContext.startActivity(new Intent(InitApp.AppContext, WendaDetailActivity.class)
                .putExtra(TAG, bean)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, WendaDetailFragment.newInstance(getIntent().getParcelableExtra(TAG)))
                .commit();
    }
}
