package com.example.shilpa.boundservices;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;

public class MyService extends Service {

    private final IBinder myBinder = new myLocalBinder();


    public MyService() {
    }

    public String getTime(){
        SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss", Locale.US);
        return (sf.format(new Date()));
    }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    public class myLocalBinder extends Binder{

        MyService getService(){
            return MyService.this;
        }

    }

}
