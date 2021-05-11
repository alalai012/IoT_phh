package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
//알람 시간이 되었을 때 동작할 기능
public class AlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // = getIntent();
        int id=1;
        intent.getIntExtra("type",id);
        NotificationHelper notificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification(id);//????
        notificationHelper.getManager().notify(id,nb.build());
    }
}