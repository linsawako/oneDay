package com.example.linsawako.zhihu.zhihudaily.content;

import static android.R.attr.id;

/**
 * Created by linsawako on 2017/1/30.
 */

public interface ContentContract {

    interface View{
        void setTitleImage(String url);

        void setContent(String text);

        void setTitle(String title);

        void setFabVisible();
    }

    interface Presenter{
        void getNews(int id);
        void getCommentNum(int id);
    }

    interface Model{
        void getNews(CallBackNewsContent callback, int id);
        void getCommentNum(CallBackComment callBackComment, int id);
    }

}
