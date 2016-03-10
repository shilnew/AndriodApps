package com.example.shilpa.movingintent;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    final static String TAG = "exa.shilpa.movingintent";

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, " Service is Started");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i <5; i++){
                    long futuretime = System.currentTimeMillis()+5000;

                    while (System.currentTimeMillis() < futuretime){
                        try {
                            synchronized (this) {
                                wait(futuretime - System.currentTimeMillis());
                                Log.i (TAG, " In the Loop " + i);
                            }
                        }catch (Exception e){}
                    }
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        Log.i(TAG, " Service is destroyed");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
