package com.example.linsawako.zhihu.zhihudaily.comment;

import com.example.linsawako.zhihu.bean.Comment;

/**
 * Created by linsawako on 2017/1/30.
 */

public class CommentPresenter implements CommentContract.Presenter {

    private CommentContract.View view;
    private CommentContract.Model model;

    public CommentPresenter(CommentContract.View view) {
        this.view = view;
        model = new CommentModel();
    }


    @Override
    public void getComment(int id) {
        model.getComment(new CallBackComment() {
            @Override
            public void getComment(Comment comment) {
                view.refreshRecyclerView(comment.getComments());
            }
        }, id);
    }
}
