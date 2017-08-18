package com.batchmates.android.binderproject.injection.secondactivity;

import com.batchmates.android.binderproject.view.secondactivity.SecondActivity;

import dagger.Component;

/**
 * Created by Android on 8/18/2017.
 */
@Component(modules = SecondActivityModule.class)
public interface SecondActivityComponent {
    void inject(SecondActivity secondActivity);
}
