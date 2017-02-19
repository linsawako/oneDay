package com.example.linsawako.zhihu.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.linsawako.zhihu.R;
import com.example.linsawako.zhihu.adapter.ScheduleAdapter;
import com.example.linsawako.zhihu.bean.Schedule;
import com.example.linsawako.zhihu.fragment.ScheduleFragment;

import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.example.linsawako.zhihu.R.drawable.save;
import static com.example.linsawako.zhihu.R.drawable.set;

public class AddScheduleActivity extends AppCompatActivity {

    private static final String TAG = "AddScheduleActivity";
    private int activityName;
    private int scheduleID;

    @Bind(R.id.addSchedule_editText)
    EditText contentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_schedule);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.edit_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);//让导航按钮显示出来，设置为返回键
        }

        Intent intent = getIntent();
        activityName = intent.getIntExtra("ActivityName", 0);//判断是哪个intent跳转的

        //修改便签的事件
        if (activityName == ScheduleAdapter.NAME){
            Schedule schedule = (Schedule) intent.getSerializableExtra("Content");
            contentText.setText(schedule.getContent());//填入已有的数据
            scheduleID = schedule.getId();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home://返回
                finish();
                break;
            case R.id.save://存储键
                Log.d(TAG, "onOptionsItemSelected: savedata");
                if (activityName == ScheduleAdapter.NAME) {//如果是已有的数据就更新，否则存储
                    updateDate();
                } else if (activityName == ScheduleFragment.NAME) {
                    saveDate();
                }
                finish();
                break;
        }
        return true;
    }

    //使用litepal更新数据
    public void updateDate() {
        Schedule schedule = new Schedule();
        schedule.setContent(contentText.getText().toString());
        schedule.setDate(new Date());
        schedule.update(scheduleID);
    }

    //使用litepal存储数据
    public void saveDate(){
        Schedule schedule = new Schedule();
        schedule.setDate(new Date());//存入的时间
        schedule.setContent(contentText.getText().toString());
        schedule.setFinish(false);
        schedule.save();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_schedule, menu);
        return true;
    }
}
