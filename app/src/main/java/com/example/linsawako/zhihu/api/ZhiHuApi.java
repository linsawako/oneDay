package com.example.linsawako.zhihu.api;

import com.example.linsawako.zhihu.bean.Comment;
import com.example.linsawako.zhihu.bean.LatestNews;
import com.example.linsawako.zhihu.bean.News;
import com.example.linsawako.zhihu.bean.StoryExtra;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.view.View.Z;


/**
 * Created by linsawako on 2017/1/26.
 */

public class ZhiHuApi {

    private static final int DEFAULT_TIMEOUT = 5;
    private ZhiHuService zhiHuService;
    private static ZhiHuApi zhiHuApi;
    private Retrofit retrofit;

    private ZhiHuApi() {
        //设置超时时间
        OkHttpClient.Builder httpcientBuilder = new OkHttpClient.Builder();

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpcientBuilder.build())//
                .baseUrl(Config.ZHIHU_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

       zhiHuService = retrofit.create(ZhiHuService.class);
    }

    /*public static ZhiHuService getZhihuService() {
        if (zhiHuService == null) {
            synchronized (ZhiHuService.class) {
                if (zhiHuService == null) {
                    new ZhiHuApi();
                }
            }
        }
        return zhiHuService;
    }*/

    public static ZhiHuApi getInstance(){
        if (zhiHuApi == null) {
            synchronized (ZhiHuApi.class){
                if (zhiHuApi == null){
                   zhiHuApi = new ZhiHuApi();
                }
            }
        }
        return zhiHuApi;
    }

    public void getLatestNews(Subscriber<LatestNews> subscriber){
        zhiHuService.getLatestNews()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getBeforeNews(Subscriber<LatestNews> subscriber, String date){
        zhiHuService.getBeforeNews(date)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getNews(Subscriber<News> subscriber, int id){
        zhiHuService.getNews(id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
    public void getStoryExtra(Subscriber<StoryExtra> subscriber, int id){
        zhiHuService.getStroyExtra(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getComment(Subscriber<Comment> subscriber, int id) {
        zhiHuService.getComments(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
