package com.batchmates.android.binderproject.view.secondactivity;

/**
 * Created by Android on 8/18/2017.
 */

public class SecondActivityPresenter implements SecondActivityContract.Presenter{

    SecondActivityContract.View view;


    @Override
    public void addView(SecondActivityContract.View view) {
        this.view=view;
    }

    @Override
    public void removeView() {
        this.view=null;
    }
}
