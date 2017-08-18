package com.batchmates.android.binderproject.view;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.batchmates.android.binderproject.R;
import com.batchmates.android.binderproject.injection.DaggerMainActivityComponent;
import com.batchmates.android.binderproject.service.MyBoundService;
import com.batchmates.android.binderproject.view.secondactivity.SecondActivity;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{

    private static final String TAG = "MainActivity";
    @Inject MainActivityPresenter presenter;

    MyBoundService mService;
    boolean mBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpDagger();
        presenter.addView(this);

    }

    private void setUpDagger() {
        DaggerMainActivityComponent.create().inject(this);
    }


    @Override
    public void showError() {

    }


    @Override
    protected void onStart() {
        super.onStart();
        Intent intent= new Intent(this, MyBoundService.class);
        bindService(intent,mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mBound) {
            unbindService(mConnection);
            mBound = false;
        }
    }

    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            MyBoundService.LocalBinder binder = (MyBoundService.LocalBinder) service;
            mService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };

    public void getRandomNumber(View view) {

        int mynum=mService.getRandomNumber();
        Log.d(TAG, "getRandomNumber: "+mynum);

        Intent intent= new Intent(this, SecondActivity.class);
        intent.putExtra("NUMBER",mynum);
        startActivity(intent);
    }
}
