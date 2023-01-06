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
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.isscript.datamodels.LoginResponse;
import com.example.isscript.datamodels.User;
import com.example.isscript.retrofit.StoryClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Objects;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class a1_login extends AppCompatActivity {
    private static final String CHANNEL_ID = "Test_kanal";
    private NotificationManagerCompat notificationManager;
    private static final String TAG = "Service-Debug";

    EditText edittextusername, editpassword;
    Button login_btn;

/*    @Override
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


    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1_login);

        login_btn = findViewById(R.id.login_btn);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekLogin();
            }
        });
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
                        Toast.makeText(a1_login.this, token, Toast.LENGTH_SHORT).show();
                    }
                });

        // 1. Ambil notification manager
        notificationManager = NotificationManagerCompat.from(this);

        // 2. Membuat channel notifikasi
        createNotificationChannel();
    }

    public void cekLogin() {
        edittextusername = findViewById(R.id.idusername);
        editpassword = findViewById(R.id.idpassword);
        login_btn = findViewById(R.id.login_btn);

        String username = edittextusername.getText().toString();
        String password = editpassword.getText().toString();

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(new OkHttpClient.Builder().build())
                        .build();

                StoryClient client = retrofit.create(StoryClient.class);

                Call<LoginResponse> call = client.login(username, password);

                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                        if (response.isSuccessful()) {
                            LoginResponse loginResponse = response.body();
                            if (loginResponse != null && Objects.equals(loginResponse.getStatus(), "success")) {
                                Toast.makeText(a1_login.this, "Berhasil Login", Toast.LENGTH_SHORT).show();

                                String token = loginResponse.getAuthorisation().getToken();

                                SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);
                                SharedPreferences.Editor editor= sharedPref.edit();
                                editor.putString("TOKEN", token);

                                editor.apply();


                                Intent Intent = new Intent(a1_login.this, a2_homescreen.class);
                                startActivity(Intent);
                            }
                        } else {
                            /*Log.e("LoginActivity", response.message());*/
                            Toast.makeText(a1_login.this, "Username/password anda salah", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Toast.makeText(a1_login.this, "Gagal login", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
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
        Intent resultIntent = new Intent(this, b9_lihat_profil.class);
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
        NotificationManagerCompat.from(this).notify(1305, builder.build());

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
        NotificationManagerCompat.from(this).notify(1305, builder.build());

        //Toast.makeText(notif_salma.this, "Test", Toast.LENGTH_SHORT).show();
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