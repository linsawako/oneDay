package com.example.linsawako.zhihu.zhihudaily.news;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.linsawako.zhihu.R;
import com.example.linsawako.zhihu.activity.MainActivity;
import com.example.linsawako.zhihu.adapter.NewsSummaryAdapter;
import com.example.linsawako.zhihu.bean.LatestNews;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;
import java.util.List;

import static android.R.attr.fragment;

public class NewsFragment extends Fragment implements NewsContract.View, DatePickerDialog.OnDateSetListener {

    private static final String TAG = "NewsFragment";
    RecyclerView recyclerView;
    private NewsContract.Presenter presenter;

    public NewsFragment() {
        presenter = new NewsPresenter(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_zhihu_daily, container, false);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setImageResource(R.drawable.add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*final CalendarFragment calendarFragment = new CalendarFragment();

                calendarFragment.setCaldroidListener(new CaldroidListener() {
                    @Override
                    public void onSelectDate(Date date, View view) {
                        calendarFragment.dismiss();
                        SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
                        //Toast.makeText(getBaseContext(), df.format(date), Toast.LENGTH_SHORT).show();
                        fragment.setDate(df.format(date));
                    }
                });
                calendarFragment.show(getSupportFragmentManager(), "calendar");*/
                //显示日历选项
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        NewsFragment.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getActivity().getFragmentManager(), "Datepickerdialog");
            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.latest_news_recyclerview);
        //StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
       presenter.getLatestNews();

        return view;
    }

    @Override
    public void refreshRecyclerVew(List<LatestNews.StoriesBean> storiesList) {
        Log.d(TAG, "refreshRecyclerVew: ");
        NewsSummaryAdapter adapter = new NewsSummaryAdapter(storiesList);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        //String date = "You picked the following date: "+dayOfMonth+"/"+(monthOfYear+1)+"/"+year;
        String date = String.format("%d%02d%02d", year, monthOfYear + 1, dayOfMonth);
        presenter.getBeforeNews(date);
    }
}
