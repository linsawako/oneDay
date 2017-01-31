package com.example.linsawako.zhihu.api;

import com.example.linsawako.zhihu.bean.Comment;
import com.example.linsawako.zhihu.bean.LatestNews;
import com.example.linsawako.zhihu.bean.News;
import com.example.linsawako.zhihu.bean.StoryExtra;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

import static android.R.attr.id;

/**
 * Created by linsawako on 2017/1/21.
 */

public interface ZhiHuService {
    @GET("api/4/news/latest")
    Observable<LatestNews> getLatestNews();

    @GET("api/4/news/before/{date}")
    Observable<LatestNews> getBeforeNews(@Path("date") String dateString);

    @GET("api/4/news/{id}")
    Observable<News> getNews(@Path("id") int id);

    @GET("api/4/story/{id}/long-comments")
    Observable<Comment> getComments(@Path("id") int id);

    @GET("api/4/story-extra/{id}")
    Observable<StoryExtra> getStroyExtra(@Path("id") int id);
}
