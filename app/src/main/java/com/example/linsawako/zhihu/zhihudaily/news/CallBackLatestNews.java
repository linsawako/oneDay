package com.example.linsawako.zhihu.zhihudaily.news;

import com.example.linsawako.zhihu.bean.LatestNews;

import java.util.List;

/**
 * Created by linsawako on 2017/1/29.
 */

public interface CallBackLatestNews {

    public void result(List<LatestNews.StoriesBean> list);
}
