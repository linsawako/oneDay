package com.example.linsawako.zhihu.tool;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.example.linsawako.zhihu.R;
import com.example.linsawako.zhihu.myInterface.PopClickEvent;

/**
 * Created by linsawako on 2017/2/7.
 */

public class PopOptionUtil {

    private Context mContext;
    private int popupWidth;
    private int popupHeight;
    private PopupWindow popupWindow;
    private PopClickEvent mEvent;
    private Button deleteBtn;


    public PopOptionUtil(Context context) {
        mContext = context;
        View popupView = LayoutInflater.from(mContext).inflate(R.layout.layout_pop, null);
        deleteBtn = (Button) popupView.findViewById(R.id.delete_btn);
        popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        popupWidth = popupView.getMeasuredWidth();
        popupHeight = popupView.getMeasuredHeight();
    }

    public void show(View view) {
        initEvent();
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        popupWindow.showAtLocation(view, Gravity.NO_GRAVITY, (location[0] + view.getWidth() / 2) - popupWidth / 2,
                location[1] - popupHeight);
    }

    public void dismiss(){
        popupWindow.dismiss();
    }

    public void setOnPopClickEvent(PopClickEvent mEvent) {
        this.mEvent = mEvent;
    }

    private void initEvent() {
        if (mEvent != null) {
            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mEvent.onNextClick();
                }
            });

        }
    }
}
