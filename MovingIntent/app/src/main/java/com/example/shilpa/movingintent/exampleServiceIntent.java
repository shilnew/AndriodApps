package com.example.shilpa.movingintent;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class exampleServiceIntent extends IntentService{

    public static final String TAG = "shilpa.movingintent";

    public exampleServiceIntent() {
        super("exampleServiceIntent");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG, "Service has now begin");
    }
}
