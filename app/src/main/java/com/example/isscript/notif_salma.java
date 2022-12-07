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
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class notif_salma extends AppCompatActivity {

    private static final String CHANNEL_ID = "Test_kanal";
    private Button buttonShow;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif_salma);

        notificationManager = NotificationManagerCompat.from(this);

        createNotificationChannel();

        buttonShow = findViewById(R.id.buttonShow);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent(notif_salma.this, b7_ganti_foto.class);

                TaskStackBuilder stackBuilder = TaskStackBuilder.create(notif_salma.this);
                stackBuilder.addNextIntentWithParentStack(resultIntent);

                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(0,
                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(notif_salma.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_notification)
                        .setContentTitle("Lakukan segera!")
                        .setContentText("Wah, foto profil kamu udah expired, yuk ganti dengan yang baru")
                        //.setContentIntent(resultPendingIntent)
                        .addAction(R.drawable.ic_photo, "Ganti foto", resultPendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                notificationManager.notify(1304, builder.build());

                //Toast.makeText(notif_salma.this, "Test", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Contoh notifikasi";
            String description = "cuman notif aja";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            notificationManager.createNotificationChannel(channel);
        }
    }
}