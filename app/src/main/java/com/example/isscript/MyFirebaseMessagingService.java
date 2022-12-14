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

    public MyFirebaseMessagingService() {
    }

    @Override
    public void onNewToken(@NonNull String token) {
        Log.d(TAG, "Refreshed token: " + token);

    }
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        displayNotification(remoteMessage.getNotification());
    }

    private void displayNotification(RemoteMessage.Notification notification) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Contoh notifikasi";
            String description = "cuman notif aja";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            notificationManager.createNotificationChannel(channel);
        }


        Intent resultIntent = new Intent(this, b7_ganti_foto.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(resultIntent);

        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0,
                        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        // 3. Membuat builder untuk membuat notifikasi
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("Lakukan segera!")
                .setContentText("Wah, foto profil kamu udah expired, yuk ganti dengan yang baru")
                //.setContentIntent(resultPendingIntent)
                .addAction(R.drawable.ic_photo, "Ganti foto", resultPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // 4. Membuat objek notifikasi dan menampilkan notifikasi
        notificationManager.notify(1304, builder.build());

        //Toast.makeText(notif_salma.this, "Test", Toast.LENGTH_SHORT).show();
    }

}