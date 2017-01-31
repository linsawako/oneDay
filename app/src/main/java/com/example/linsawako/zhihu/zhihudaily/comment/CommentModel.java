package com.example.linsawako.zhihu.zhihudaily.comment;

import com.example.linsawako.zhihu.api.ZhiHuApi;
import com.example.linsawako.zhihu.bean.Comment;

import rx.Subscriber;

/**
 * Created by linsawako on 2017/1/30.
 */

public class CommentModel implements CommentContract.Model {
    @Override
    public void getComment(final CallBackComment callBackComment, int id) {
        Subscriber subscriber = new Subscriber<Comment>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Comment comment) {
                callBackComment.getComment(comment);
            }
        };
        ZhiHuApi.getInstance().getComment(subscriber, id);
    }
}
