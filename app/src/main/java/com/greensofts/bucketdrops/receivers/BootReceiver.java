package com.greensofts.bucketdrops.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.greensofts.bucketdrops.extras.Util;

public class BootReceiver extends BroadcastReceiver {
    public static final String TAG = "STEV";
    public BootReceiver() {
        Log.d(TAG, "BootReceiver: ");
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: ");
        Util.scheduleAlarm(context);
    }
}
