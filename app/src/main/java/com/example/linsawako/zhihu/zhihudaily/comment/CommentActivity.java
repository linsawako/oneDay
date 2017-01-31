package com.example.linsawako.zhihu.zhihudaily.comment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.linsawako.zhihu.R;
import com.example.linsawako.zhihu.adapter.CommentAdapter;
import com.example.linsawako.zhihu.api.ZhiHuApi;
import com.example.linsawako.zhihu.bean.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentActivity extends AppCompatActivity implements CommentContract.View{

    private int id;
    private RecyclerView recyclerView;
    private static final String TAG = "CommentActivity";
    private CommentContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        Intent intent = getIntent();
        id = intent.getIntExtra("newsId", 0);

        recyclerView = (RecyclerView) findViewById(R.id.comment_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        presenter = new CommentPresenter(this);
        presenter.getComment(id);
    }

    @Override
    public void refreshRecyclerView(List<Comment.CommentsBean> list) {
        CommentAdapter adapter = new CommentAdapter(list);
        recyclerView.setAdapter(adapter);
    }

}
