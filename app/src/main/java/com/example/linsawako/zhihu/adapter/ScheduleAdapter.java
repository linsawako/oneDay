package com.example.linsawako.zhihu.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.linsawako.zhihu.R;
import com.example.linsawako.zhihu.activity.AddScheduleActivity;
import com.example.linsawako.zhihu.bean.LatestNews;
import com.example.linsawako.zhihu.bean.Schedule;
import com.example.linsawako.zhihu.zhihudaily.content.ContentActivity;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.vision.text.Text;
import com.hanks.library.AnimateCheckBox;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.example.linsawako.zhihu.adapter.NewsSummaryAdapter.NEWS_ID;

/**
 * Created by linsawako on 2017/2/4.
 */

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    public final static int NAME = 1;
    private List<Schedule> list;
    private Context mContext;
    private int scheduleId;

    public ScheduleAdapter(List<Schedule> list) {
        this.list = list;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        AnimateCheckBox animateCheckBox;
        TextView scheduleText;
        TextView date;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.schedule_cardview);
            animateCheckBox = (AnimateCheckBox) itemView.findViewById(R.id.schedule_checkbox);
            scheduleText = (TextView) itemView.findViewById(R.id.schedule_text);
            date = (TextView) itemView.findViewById(R.id.schedule_date);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.schedule_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);

        //点击后跳转，数据可更改
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                Schedule schedule = list.get(position);
                Intent intent = new Intent(mContext, AddScheduleActivity.class);
                intent.putExtra("ActivityName", NAME);
                intent.putExtra("Content", schedule);
                mContext.startActivity(intent);
            }
        });

        //设置checkBox点击后的数据存储
        viewHolder.animateCheckBox.setOnCheckedChangeListener(new AnimateCheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(View buttonView, boolean isChecked) {
                int position = viewHolder.getAdapterPosition();
                Schedule schedule = list.get(position);
                schedule.setFinish(viewHolder.animateCheckBox.isChecked());
                schedule.update(schedule.getId());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Schedule schedule = list.get(position);
        holder.date.setText(new SimpleDateFormat("yyyy/MM/dd").format(schedule.getDate()));
        holder.scheduleText.setText(schedule.getContent());
        holder.animateCheckBox.setChecked(schedule.getFinish());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
