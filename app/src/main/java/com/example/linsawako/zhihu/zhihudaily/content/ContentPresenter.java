package com.example.linsawako.zhihu.zhihudaily.content;

import com.example.linsawako.zhihu.bean.News;
import com.example.linsawako.zhihu.bean.StoryExtra;

/**
 * Created by linsawako on 2017/1/30.
 */

public class ContentPresenter implements ContentContract.Presenter {

    private ContentContract.View view;
    private ContentContract.Model model;

    public ContentPresenter(ContentContract.View view) {
        this.view = view;
        model = new ContentModel();
    }

    @Override
    public void getNews(int id) {
        model.getNews(new CallBackNewsContent() {
            @Override
            public void result(News news) {
                view.setContent(news.getBody());
                view.setTitleImage(news.getImage());
                view.setTitle(news.getTitle());
            }
        }, id);
    }

    @Override
    public void getCommentNum(int id) {
        model.getCommentNum(new CallBackComment() {
            @Override
            public void getNewsExtra(StoryExtra storyExtra) {
                if (storyExtra.getLong_comments() != 0){
                    view.setFabVisible();
                }
            }
        }, id);
    }
}
