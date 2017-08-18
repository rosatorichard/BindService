package com.batchmates.android.binderproject.view.secondactivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.batchmates.android.binderproject.R;
import com.batchmates.android.binderproject.injection.secondactivity.DaggerSecondActivityComponent;
import com.batchmates.android.binderproject.service.MyBoundService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class SecondActivity extends AppCompatActivity implements SecondActivityContract.View{

    @Inject SecondActivityPresenter presenter;
    private int theNumber;

    private MyBoundService service;
    private boolean bound=false;
    private List<String> myStrings= new ArrayList<>();


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private DefaultItemAnimator defaultItemAnimator=new DefaultItemAnimator();
    private RecyclerAdapterHelper recyclerAdapterHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setUpDagger();
        presenter.addView(this);
        theNumber=getIntent().getIntExtra("NUMBER",0);
        recyclerView=(RecyclerView)findViewById(R.id.rvMyRecyclerView);
        layoutManager= new LinearLayoutManager(this);
//        myStrings=service.createList(theNumber);
//        recyclerAdapterHelper= new RecyclerAdapterHelper(myStrings);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setItemAnimator(defaultItemAnimator);
//        recyclerView.setAdapter(recyclerAdapterHelper);



    }

    private void setUpDagger() {
        DaggerSecondActivityComponent.create().inject(this);
    }

    @Override
    public void showError() {

    }


    @Override
    protected void onStart() {
        super.onStart();
        Intent intent= new Intent(this,MyBoundService.class);
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
    }


    @Override
    protected void onStop() {
        super.onStop();
        if (bound) {
            unbindService(serviceConnection);
            bound = false;
        }
    }

    private ServiceConnection serviceConnection= new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyBoundService.LocalBinder localBinder= (MyBoundService.LocalBinder) iBinder;
            service=localBinder.getService();
            bound=true;
            myStrings=service.createList(theNumber);
            recyclerAdapterHelper= new RecyclerAdapterHelper(myStrings);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(defaultItemAnimator);
            recyclerView.setAdapter(recyclerAdapterHelper);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            bound=false;
        }
    };
}
