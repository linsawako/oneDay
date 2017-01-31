package com.example.linsawako.zhihu.zhihudaily.content;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.linsawako.zhihu.R;
import com.example.linsawako.zhihu.zhihudaily.comment.CommentActivity;
import com.example.linsawako.zhihu.adapter.NewsSummaryAdapter;
import com.example.linsawako.zhihu.util.HtmlFormat;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ContentActivity extends AppCompatActivity implements ContentContract.View {

    @Bind(R.id.toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @Bind(R.id.news_image)
    ImageView newsImage;
    @Bind(R.id.news_content)
    WebView newsContent;
    private int id;

    private FloatingActionButton fab;
    private ContentContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new ContentPresenter(this);

        final Intent intent = getIntent();
        id = intent.getIntExtra(NewsSummaryAdapter.NEWS_ID, 0);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ContentActivity.this, CommentActivity.class);
                intent1.putExtra("newsId", id);
                startActivity(intent1);
            }
        });
        fab.setVisibility(View.INVISIBLE);
        presenter.getCommentNum(id);
        presenter.getNews(id);

    }

    @Override
    public void setTitleImage(String url) {
        Glide.with(this).load(url).into(newsImage);
    }

    @Override
    public void setContent(String text) {
        newsContent.loadDataWithBaseURL(null, HtmlFormat.getNewContent(text), "text/html", "utf-8", null);
        newsContent.getSettings().setJavaScriptEnabled(true);
        WebSettings settings = newsContent.getSettings();

        newsContent.setWebChromeClient(new WebChromeClient());
    }

    @Override
    public void setTitle(String title) {
        collapsingToolbarLayout.setTitle(title);
    }

    @Override
    public void setFabVisible() {
        fab.setVisibility(View.VISIBLE);
    }
}
