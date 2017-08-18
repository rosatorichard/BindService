package com.batchmates.android.binderproject.view;

import com.batchmates.android.binderproject.BasePresenter;
import com.batchmates.android.binderproject.BaseView;

/**
 * Created by Android on 8/18/2017.
 */

public interface MainActivityContract {

    interface View extends BaseView
    {

    }

    interface Presenter extends BasePresenter<View>
    {

    }
}
