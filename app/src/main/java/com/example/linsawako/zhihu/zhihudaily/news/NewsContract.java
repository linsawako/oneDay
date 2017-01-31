package com.example.linsawako.zhihu.zhihudaily.news;

import com.example.linsawako.zhihu.bean.LatestNews;

import java.util.List;

/**
 * Created by linsawako on 2017/1/29.
 */

public interface NewsContract {

    interface View{
        void refreshRecyclerVew(List<LatestNews.StoriesBean> storiesList);
    }

    interface Presenter{
        void getBeforeNews(String date);
        void getLatestNews();
    }

    interface model{
        void getBeforeNews(CallBackLatestNews callback, String date);
        void getLatestNews(CallBackLatestNews callback);
    }

}
