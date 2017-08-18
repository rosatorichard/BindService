package com.batchmates.android.binderproject.injection;

import com.batchmates.android.binderproject.view.MainActivity;

import dagger.Component;

/**
 * Created by Android on 8/18/2017.
 */
@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
