package com.example.linsawako.zhihu.base.mvpbase;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by linsawako on 2017/2/13.
 */

public class BasePresenter<V>  {

    protected Reference<V> mViewRefer;

    public V getView() {
        return mViewRefer.get();
    }

    public void attachView(V view) {
        mViewRefer = new WeakReference<V>(view);
    }

    public void detechView() {
        if (mViewRefer != null) {
            mViewRefer.clear();
            mViewRefer = null;
        }
    }

}
