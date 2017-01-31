package com.example.linsawako.zhihu.zhihudaily.news;

import android.util.Log;

import com.example.linsawako.zhihu.bean.LatestNews;

import java.util.List;

/**
 * Created by linsawako on 2017/1/29.
 */

public class NewsPresenter implements NewsContract.Presenter {

    private static final String TAG = "NewsPresenter";
    private NewsContract.View view;
    private NewsContract.model model;

    public NewsPresenter(NewsContract.View view) {
        this.view = view;
        model = new NewsModel();
    }


    @Override
    public void getBeforeNews(String date) {
        model.getBeforeNews(new CallBackLatestNews() {
            @Override
            public void result(List<LatestNews.StoriesBean> list) {
                view.refreshRecyclerVew(list);
            }
        }, date);
    }

    @Override
    public void getLatestNews() {
        Log.d(TAG, "getLatestNews: ");
        model.getLatestNews(new CallBackLatestNews() {
            @Override
            public void result(List<LatestNews.StoriesBean> list) {
                view.refreshRecyclerVew(list);
            }
        });
    }
}
