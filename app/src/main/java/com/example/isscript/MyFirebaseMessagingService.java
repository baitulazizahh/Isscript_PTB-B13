package com.example.isscript;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String CHANNEL_ID = "Test_kanal";
    private static final String TAG = "Service-Debug";
    private NotificationManagerCompat notificationManager;

    @Override
    public void onNewToken(@NonNull String token) {
        Log.d(TAG, "Refreshed token: " + token);

    }
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String tipe = remoteMessage.getData().get("tipe");
        if (tipe.equals("1"))
            displayNotification(remoteMessage.getNotification());
        else
            displayNotification2(remoteMessage.getNotification());


    }

    private void displayNotification(RemoteMessage.Notification notification) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Contoh notifikasi";
            String description = "cuman notif aja";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManagerCompat.from(this).createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = null;

        //Tipe notif 1
        Intent resultIntent = new Intent(this, b7_ganti_foto.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0,
                        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_isscript)
                .setContentTitle(notification.getTitle())
                .setContentText(notification.getBody())
                .setContentIntent(resultPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // 4. Membuat objek notifikasi dan menampilkan notifikasi
        NotificationManagerCompat.from(this).notify(1304, builder.build());

        //Toast.makeText(notif_salma.this, "Test", Toast.LENGTH_SHORT).show();
    }
    private void displayNotification2(RemoteMessage.Notification notification) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Contoh notifikasi";
            String description = "cuman notif aja";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManagerCompat.from(this).createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = null;

        //Tipe notif 2
        builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_isscript)
                .setContentTitle(notification.getTitle())
                .setContentText(notification.getBody())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // 4. Membuat objek notifikasi dan menampilkan notifikasi
        NotificationManagerCompat.from(this).notify(1304, builder.build());

        //Toast.makeText(notif_salma.this, "Test", Toast.LENGTH_SHORT).show();
    }

}