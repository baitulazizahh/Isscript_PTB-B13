package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
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

public class NotifAzizah extends AppCompatActivity {

    private static final String CHANNEL_ID = "Test_kanal";
    private Button buttonShow;
    private NotificationManagerCompat notificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif_azizah);

        //1.Ambil notificationManager
        notificationManager = NotificationManagerCompat.from(this);

        //2b buat channel notifikasi
        createNotificationChannel();

        buttonShow = findViewById(R.id.buttonShow);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent resultIntent = new Intent(NotifAzizah.this,b3_sidang.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(NotifAzizah.this);
                stackBuilder.addNextIntentWithParentStack(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(0,
                                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
                //3.Buat builder untuk membuat notifikasi
                NotificationCompat.Builder builder = new NotificationCompat.Builder(NotifAzizah.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_warning)
                        .setContentTitle("Info Sidang")
                        .setContentText("Selamat kamu bisa mengajukan sidang sekarang")
                        //.setContentIntent(resultPendingIntent)
                        .addAction(R.drawable.ic_warning, "Lihat",resultPendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);


                //4.Buat objek notifikasi
                Notification notification = builder.build();

                //5.Tampilkan notifikasi
                notificationManager.notify(101, notification);
            }
        });
    }

    //2.Buat channel
    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Contoh Notifikasi";
            String description = "Ini adalah kanal contoh notifikasi";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            notificationManager.createNotificationChannel(channel);


        }
    }

}