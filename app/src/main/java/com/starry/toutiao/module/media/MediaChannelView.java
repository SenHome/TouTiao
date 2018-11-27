package com.starry.toutiao.module.media;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.starry.toutiao.R;


/**
 * Created by Meiji on 2016/12/24.
 */

public class MediaChannelView extends Fragment{

    private static final String TAG = "MediaChannelView";
    private static MediaChannelView instance = null;

    public static MediaChannelView getInstance() {
        if (instance == null) {
            instance = new MediaChannelView();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_media, container, false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (instance != null) {
            instance = null;
        }
    }
}
