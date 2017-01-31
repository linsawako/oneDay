package com.example.linsawako.zhihu.zhihudaily.news;

import android.util.Log;

import com.example.linsawako.zhihu.api.ZhiHuApi;
import com.example.linsawako.zhihu.bean.LatestNews;

import rx.Subscriber;

/**
 * Created by linsawako on 2017/1/29.
 */

public class NewsModel implements NewsContract.model {

    private static final String TAG = "NewsModel";


    @Override
    public void getBeforeNews(final CallBackLatestNews callback, String date) {
        Subscriber subscriber = new Subscriber<LatestNews>() {

            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(LatestNews latestNews) {
                callback.result(latestNews.getStories());
            }
        };
        ZhiHuApi.getInstance().getBeforeNews(subscriber, date);
    }

    @Override
    public void getLatestNews(final CallBackLatestNews callback) {
        Subscriber subscriber = new Subscriber<LatestNews>() {

            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(LatestNews latestNews) {
                Log.d(TAG, "onNext: ");
               callback.result(latestNews.getStories());
            }
        };
        ZhiHuApi.getInstance().getLatestNews(subscriber);
    }

}
