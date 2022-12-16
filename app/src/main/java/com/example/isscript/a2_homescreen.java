package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.isscript.adapters.JadwalAdapter;
import com.example.isscript.models.Jadwal;

import java.util.ArrayList;

public class a2_homescreen extends AppCompatActivity{

/*    private Boolean isLoggedIn = false;
    private ActivityMainBinding binding;
    //RecyclerView rv_kelas;
    String token;*/



    private RecyclerView rvJadwal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*binding = ActivityMainBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);

        Intent mainIntent = getIntent();
        String username = mainIntent.getStringExtra("USERX");
        isLoggedIn = mainIntent.getBooleanExtra("LOGX", false);

        SharedPreferences sharedPref = getSharedPreferences(
                "com.example.isscript",
                MODE_PRIVATE);
        String token = sharedPref.getString("token", "");

        if (token.equals("")) {
            //Panggil activity Login
            Intent LoginIntent = new Intent(this, a1_login.class);
            startActivity(loginIntent);
            finish();
        }*/

        setContentView(R.layout.activity_a2_homescreen);

        rvJadwal = findViewById(R.id.rv_jadwal);

        JadwalAdapter adapter = new JadwalAdapter(getJadwal());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvJadwal.setLayoutManager(layoutManager);
        rvJadwal.setAdapter(adapter);
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

    /*public void requestData() {
        String BASE_URL = "http://ptb-api.husnilkamil.my.id/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        StoryEndpoint client = retrofit.create(StoryEndpoint.class);

        Call<GetStoryResponse> call = client.getStories(token);
    }*/
}