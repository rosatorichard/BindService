package com.batchmates.android.binderproject.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyBoundService extends Service{


    private final IBinder mBinder= new LocalBinder();

    private final Random mGenerator = new Random();

    public MyBoundService() {
    }

    public class LocalBinder extends Binder
    {
        public MyBoundService getService() {
            return MyBoundService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }


    public int getRandomNumber() {
        return mGenerator.nextInt(100);
    }

    public List<String> createList(int number)
    {
        List<String> myListOfStrings= new ArrayList<>();

        for (int i = 0; i < number; i++) {
            myListOfStrings.add(RandomStringMaker());

        }

        return myListOfStrings;
    }


    public String RandomStringMaker()
    {
        Random generator= new Random();
        StringBuilder stringBuilder= new StringBuilder();
        int randomLength= generator.nextInt(15);
        char tempchar;

        for (int i = 0; i <randomLength ; i++) {

            tempchar= (char)(generator.nextInt(96)+32);
            stringBuilder.append(tempchar);
        }
        return stringBuilder.toString();
    }

}
