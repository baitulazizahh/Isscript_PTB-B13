package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.Toast;

public class notif2_gita extends AppCompatActivity {
    private static final String CHANNEL_ID = "test_kanal";
    private Button buttonShow;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif2_gita);

        //ambil notification
        notificationManager = NotificationManagerCompat.from(this);

        //buat channel notifikasi
        createNotificationChannel();


        buttonShow = findViewById(R.id.buttonshow);
        buttonShow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                // Create an Intent for the activity you want to start
                Intent resultIntent = new Intent(notif2_gita.this,a9_semhas.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(notif2_gita.this);
                stackBuilder.addNextIntentWithParentStack(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(0,
                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

                //buat builder utk buat notif
                NotificationCompat.Builder builder = new NotificationCompat.Builder(notif2_gita.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_baseline_notification_important_24)
                        .setContentTitle("Notifikasiku")
                        .setContentText("Jangan Lupa Makan")
                        .setContentIntent(resultPendingIntent)
                        .addAction(R.drawable.ic_baseline_notification_important_24,"Lihat", resultPendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);


                notificationManager.notify(01,builder.build());

            }
        });
    }
    //chanell
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Notifikasi pengingat";
            String description = "Ini hanya kanal untuk contoh notifikasi";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            notificationManager.createNotificationChannel(channel);
        }

    }
}