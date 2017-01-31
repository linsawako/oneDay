package com.example.linsawako.zhihu.zhihudaily.content;

import com.example.linsawako.zhihu.bean.LatestNews;
import com.example.linsawako.zhihu.bean.News;
import com.example.linsawako.zhihu.bean.StoryExtra;

import java.util.List;

/**
 * Created by linsawako on 2017/1/29.
 */

public interface CallBackNewsContent {

    public void result(News news);
}

interface CallBackComment{
    public void getNewsExtra(StoryExtra storyExtra);
}
