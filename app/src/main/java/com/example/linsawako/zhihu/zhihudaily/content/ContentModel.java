package com.example.linsawako.zhihu.zhihudaily.content;

import com.example.linsawako.zhihu.api.ZhiHuApi;
import com.example.linsawako.zhihu.bean.News;
import com.example.linsawako.zhihu.bean.StoryExtra;

import rx.Subscriber;

/**
 * Created by linsawako on 2017/1/30.
 */

public class ContentModel implements ContentContract.Model {

    @Override
    public void getNews(final CallBackNewsContent callback, int id) {
        Subscriber subscriber = new Subscriber<News>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(News news) {
                callback.result(news);
            }
        };
        ZhiHuApi.getInstance().getNews(subscriber, id);
    }

    @Override
    public void getCommentNum(final CallBackComment callBackComment, int id) {
        Subscriber subscriber = new Subscriber<StoryExtra>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(StoryExtra storyExtra) {
                callBackComment.getNewsExtra(storyExtra);
            }
        };
        ZhiHuApi.getInstance().getStoryExtra(subscriber, id);
    }
}
