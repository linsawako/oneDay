package com.example.linsawako.zhihu.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.transition.Scene;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.linsawako.zhihu.R;
import com.example.linsawako.zhihu.activity.AddScheduleActivity;
import com.example.linsawako.zhihu.activity.MainActivity;
import com.example.linsawako.zhihu.adapter.ScheduleAdapter;
import com.example.linsawako.zhihu.bean.Schedule;
import com.example.linsawako.zhihu.myInterface.PopClickEvent;
import com.example.linsawako.zhihu.tool.PopOptionUtil;
import com.example.linsawako.zhihu.tool.RecyclerItemClickListener;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;
import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {

    private static final String TAG = "ScheduleFragment";
    public final static int NAME = 0;
    private RecyclerView recyclerView;
    private List<Schedule> scheduleList;
    private ScheduleAdapter mAdapter;
    PopOptionUtil mPop;

    public ScheduleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        scheduleList.clear(); //去掉之前的数据
        List<Schedule> newList = DataSupport.order("date desc").find(Schedule.class);
        scheduleList.addAll(newList);//注意要将数据复制过来，而不是直接使用，不然无法更新数据
        mAdapter.notifyDataSetChanged();
        Log.d(TAG, "onResume: ");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView: ");
        
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.schedule_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: intent");
                Intent intent = new Intent(getContext(), AddScheduleActivity.class);
                intent.putExtra("ActivityName", NAME);
                startActivity(intent);
            }
        });

        mPop = new PopOptionUtil(getContext());

        scheduleList = DataSupport.order("date desc").find(Schedule.class);
        mAdapter = new ScheduleAdapter(scheduleList);

        recyclerView = (RecyclerView) view.findViewById(R.id.schedule_recyclerview);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // ...
            }

            @Override
            public void onItemLongClick(View view, final int position) {
                Log.d(TAG, "onItemLongClick: ");
                mPop.setOnPopClickEvent(new PopClickEvent() {

                    @Override
                    public void onNextClick() {
                        Log.d(TAG, "onNextClick: delete");

                        int id = scheduleList.get(position).getId();
                        Log.d(TAG, "onNextClick: position:" + position + " id: " + id);
                        deleteData(id);

                        scheduleList.remove(position);

                        mAdapter.notifyItemRemoved(position);
                        mAdapter.notifyItemRangeChanged(0,scheduleList.size());
                        mPop.dismiss();
                    }
                });
                mPop.show(view);
            }
        }));


        return view;
    }

    public void deleteData(int id){
        DataSupport.deleteAll(Schedule.class, "id = ?", String.valueOf(id));
        Log.d(TAG, "deleteData: " + id);
    }

}
