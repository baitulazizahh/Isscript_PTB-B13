package com.example.isscript;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.isscript.adapters.JadwalAdapter;
//import com.example.isscript.datamodels.HomescreenResponse;
import com.example.isscript.datamodels.AudiencesItem;
import com.example.isscript.datamodels.Logbook;
import com.example.isscript.datamodels.ProfilResponse;
import com.example.isscript.datamodels.RvhsResponse;
import com.example.isscript.datamodels.TambahLogbookResponse;
import com.example.isscript.models.Jadwal;
import com.example.isscript.retrofit.StoryClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class a2_homescreen extends AppCompatActivity{

    private Boolean isLoggedIn = false;
    String token;
    TextView tvnama;

    private RecyclerView rvJadwal;
    private JadwalAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);
        token = sharedPref.getString("TOKEN", "");

        Intent mainIntent = getIntent();
        String username = mainIntent.getStringExtra("USERX");
        isLoggedIn = mainIntent.getBooleanExtra("LOGX", false);

        if (token.equals("")) {
            //Panggil activity Login
            Intent loginIntent = new Intent(this,a1_login.class);
            startActivity(loginIntent);
            finish();
        }
        setContentView(R.layout.activity_a2_homescreen);
        tampilNama();





        //minta data ke server

 String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();
        StoryClient client = retrofit.create(StoryClient.class);

        Call<RvhsResponse> call = client.rvhs("Bearer"+ token);
        call.enqueue(new Callback<RvhsResponse>() {
            @Override
            public void onResponse(Call<RvhsResponse> call, Response<RvhsResponse> response) {
                Log.d("HS-debug", response.toString());
                RvhsResponse rvhsResponse = response.body();
                if (rvhsResponse != null) {
                    List<AudiencesItem> audiences = rvhsResponse.getAudiences();
                    Log.d("HS-debug", String.valueOf(audiences.size()));
                    adapter.setListJadwal(audiences);
                   // Toast.makeText(a2_homescreen.this, nRvhsResponse.getMessage(), Toast.LENGTH_SHORT).show();

                   // SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);
                  //  SharedPreferences.Editor editor= sharedPref.edit();
                  //  editor.apply();

                   // Intent Intent = new Intent(c1_tambah_logbook.this,a2_homescreen.class);
                    //tartActivity(Intent);
                }
            }

//            @Override
//            public void onFailure(Call<RvhsResponse> call, Throwable t) {
//
//            } else {
//                Toast.makeText(c1_tambah_logbook.this, "Gagal menambah logbook", Toast.LENGTH_SHORT).show();
//            }

            //}

            @Override
            public void onFailure(Call<RvhsResponse> call, Throwable t) {

            }
        });


        rvJadwal = findViewById(R.id.rv_jadwal);
        //JadwalAdapter adapter = new JadwalAdapter(getJadwal());
        // LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvJadwal.setLayoutManager(new LinearLayoutManager(this));
        rvJadwal.setAdapter(adapter);

        adapter = new JadwalAdapter();
        rvJadwal.setAdapter(adapter);
    }

    public void tampilNama(){
        tvnama = findViewById(R.id.username);

        SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);
        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();
        StoryClient client = retrofit.create(StoryClient.class);

        Call<ProfilResponse> call = client.profill("Bearer "+token);
        call.enqueue(new Callback<ProfilResponse>() {
            @Override
            public void onResponse(Call<ProfilResponse> call, Response<ProfilResponse> response) {

                if (response.isSuccessful()){
                    if (!response.isSuccessful()) {
                        tvnama.setText("Nama mahasiswa");
                        return;
                    }else {
                        ProfilResponse profilResponse =response.body();

                        String name = profilResponse.getName();
                        tvnama.setText(name);
                    }
                }
            }
            @Override
            public void onFailure(Call<ProfilResponse> call, Throwable t) {
                Toast.makeText(a2_homescreen.this, "Terjadi error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public ArrayList<Jadwal> getJadwal() {
        ArrayList<Jadwal> listJadwal = new ArrayList<>();

        listJadwal.add(new Jadwal(
                "Salma",
                "2011522002",
                null,
                "Rabu, 1 Januari 2023",
                "10.00 - 12.00 WIB",
                "Ruang sidang SI"
        ));
        listJadwal.add(new Jadwal(
                "Tuti Astuti",
                "2011522003",
                null,
                "Kamis, 2 Januari 2023",
                "10.00 - 12.00 WIB",
                "Ruang sidang SI"
        ));
        listJadwal.add(new Jadwal(
                "Cici Melia",
                "2011522004",
                null,
                "Jumat, 3 Januari 2023",
                "10.00 - 12.00 WIB",
                "Ruang sidang SI"
        ));
        listJadwal.add(new Jadwal(
                "Salma",
                "2011522002",
                null,
                "Rabu, 1 Januari 2023",
                "10.00 - 12.00 WIB",
                "Ruang sidang SI"
        ));
        listJadwal.add(new Jadwal(
                "Tuti Astuti",
                "2011522003",
                null,
                "Kamis, 2 Januari 2023",
                "10.00 - 12.00 WIB",
                "Ruang sidang SI"
        ));
        listJadwal.add(new Jadwal(
                "Cici Melia",
                "2011522004",
                null,
                "Jumat, 3 Januari 2023",
                "10.00 - 12.00 WIB",
                "Ruang sidang SI"
        ));

        return listJadwal;
    }
    public void a2tambahjudul(View view) {
        Intent intent = new Intent(a2_homescreen.this, a8_tambah_judul.class);
        startActivity(intent);
    }
    public void kelistlb(View view) {
        Intent intent = new Intent(a2_homescreen.this, a5_list_logbook.class);
        startActivity(intent);
    }
    public void ketambahlb(View view) {
        Intent intent = new Intent(a2_homescreen.this, c1_tambah_logbook.class);
        startActivity(intent);
    }
    public void beranda(View view) {
        Intent intent = new Intent(a2_homescreen.this, a2_homescreen.class);
        startActivity(intent);
    }
    public void semhas(View view) {
        Intent intent = new Intent(a2_homescreen.this, a9_semhas.class);
        startActivity(intent);
    }
    public void sidang(View view) {
        Intent intent = new Intent(a2_homescreen.this, b3_sidang.class);
        startActivity(intent);
    }

    public void profil(View view) {
        Intent intent = new Intent(a2_homescreen.this, b6_profil.class);
        startActivity(intent);
    }

}