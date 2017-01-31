package com.example.linsawako.zhihu.zhihudaily.comment;

import com.example.linsawako.zhihu.bean.Comment;

import java.util.List;

/**
 * Created by linsawako on 2017/1/30.
 */

public interface CommentContract {

    interface View{
        void refreshRecyclerView(List<Comment.CommentsBean> list);
    }

    interface Presenter{
        void getComment(int id);
    }

    interface Model{
        void getComment(CallBackComment callBackComment, int id);
    }

}
