package com.batchmates.android.binderproject;

/**
 * Created by Android on 8/18/2017.
 */

public interface BasePresenter <V extends BaseView>{

    void addView(V view);

    void removeView();
}
