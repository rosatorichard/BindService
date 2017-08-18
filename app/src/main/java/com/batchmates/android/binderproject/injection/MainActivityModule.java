package com.batchmates.android.binderproject.injection;

import com.batchmates.android.binderproject.view.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Android on 8/18/2017.
 */
@Module
public class MainActivityModule {

    @Provides
    public MainActivityPresenter mainActivityPresenter()
    {
        return new MainActivityPresenter();
    }
}
