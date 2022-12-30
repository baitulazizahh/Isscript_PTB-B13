package com.example.isscript;

import androidx.annotation.NonNull;
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
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class notif_salma extends AppCompatActivity {
    private static final String TAG = "notif_salma-Debug";
    private static final String CHANNEL_ID = "Test_kanal";
    private Button buttonShow;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notif_salma);

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast
                        Log.d(TAG, token);
                        Toast.makeText(notif_salma.this, token, Toast.LENGTH_SHORT).show();
                    }
                });

        // 1. Ambil notification manager
        notificationManager = NotificationManagerCompat.from(this);

        // 2. Membuat channel notifikasi
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

                // 3. Membuat builder untuk membuat notifikasi
                NotificationCompat.Builder builder = new NotificationCompat.Builder(notif_salma.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_isscript)
                        .setContentTitle("Lakukan segera!")
                        .setContentText("Wah, foto profil kamu udah expired, yuk ganti dengan yang baru")
                        //.setContentIntent(resultPendingIntent)
                        .addAction(R.drawable.ic_photo, "Ganti foto", resultPendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                // 4. Membuat objek notifikasi dan menampilkan notifikasi
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