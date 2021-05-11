package com.example.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
//출처 : https://appdpmtstore.tistory.com/4
public class NotificationHelper extends ContextWrapper {
    public static final String channel1ID = "channel1ID";
    public static final String channel1Name = "channel 1 ";
    public static final String channel2ID = "channel2ID";
    public static final String channel2Name = "channel 2 ";

    private NotificationManager mManager;
    private NotificationManager lManager;

    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannels();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createChannels(){
        NotificationChannel channel1 = new NotificationChannel(channel1ID,channel1Name, NotificationManager.IMPORTANCE_DEFAULT);
        channel1.enableLights(true);
        channel1.enableVibration(true);
        channel1.setLightColor(R.color.black);
        channel1.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(channel1);

        NotificationChannel channel2 = new NotificationChannel(channel2ID,channel2Name, NotificationManager.IMPORTANCE_DEFAULT);
        channel2.enableLights(true);
        channel2.enableVibration(true);
        channel2.setLightColor(R.color.black);
        channel2.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getlManager().createNotificationChannel(channel2);

    }

    public NotificationManager getManager() {
        if (mManager == null){
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }

        return mManager;
    }
    public NotificationManager getlManager() {
        if (lManager == null){
            lManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }

        return lManager;
    }
    public NotificationCompat.Builder getChannel1Notification(String title, String message){
        return new NotificationCompat.Builder(getApplicationContext(), channel1ID)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_launcher_background);
    }

    public NotificationCompat.Builder getChannel2Notification(String title, String message){
        return new NotificationCompat.Builder(getApplicationContext(), channel2ID)
                .setContentTitle("채널 2 노티")
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_launcher_background);
    }

    public NotificationCompat.Builder getChannelNotification(int id){

        String string ="아침 약을 드세요";
        if(id==1){}//채널을 어떻게 나눠서 불러올까???
        if(id==2){string ="점심 약을 드세요";}else{string = "저녁 약을 드세요. id:"+id;}
        return new NotificationCompat.Builder(getApplicationContext(), channel1ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(string);
    }

}
