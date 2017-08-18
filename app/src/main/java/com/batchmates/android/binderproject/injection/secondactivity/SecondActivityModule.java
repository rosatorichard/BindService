package com.batchmates.android.binderproject.injection.secondactivity;

import com.batchmates.android.binderproject.view.secondactivity.SecondActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Android on 8/18/2017.
 */
@Module
public class SecondActivityModule {

    @Provides
    public SecondActivityPresenter secondActivityPresenter()
    {
        return new SecondActivityPresenter();
    }
}
