package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.isscript.datamodels.LoginResponse;
import com.example.isscript.datamodels.ProfilResponse;
import com.example.isscript.datamodels.User;
import com.example.isscript.retrofit.StoryClient;

import java.util.Objects;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class b6_profil extends AppCompatActivity {

    TextView tvnama, tvnim;
    String token;
    Button btnlogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b6_profil);

        SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);
        token = sharedPref.getString("TOKEN", "");

        tampilProfil();

        btnlogout = findViewById(R.id.button1);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    }

    public void logout() {
        btnlogout = findViewById(R.id.button1);

        SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPref.edit();
        editor.clear();
        editor.apply();
        Intent intent5 = new Intent(this, a1_login.class);
        intent5.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent5);
    }
    public void tampilProfil(){
        tvnama = findViewById(R.id.idtextView19);
        tvnim = findViewById(R.id.idtextView20);
/*        String name = tvnama.getText().toString();
        String username = tvnim.getText().toString();*/

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
                        tvnim.setText("NIM mahasiswa");
                        return;
                    }else {
                        ProfilResponse profilResponse =response.body();

                        String name = profilResponse.getName();
                        String username = profilResponse.getUsername();

                        tvnama.setText(name);
                        tvnim.setText(username);
                    }
                }
            }
            @Override
            public void onFailure(Call<ProfilResponse> call, Throwable t) {
                Toast.makeText(b6_profil.this, "Terjadi error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void b6kelihatprofil(View view) {
        Intent intent = new Intent(b6_profil.this, b9_lihat_profil.class);
        startActivity(intent);
    }
    public void b6kegantipassword(View view) {
        Intent intent = new Intent(b6_profil.this, b8_ganti_password.class);
        startActivity(intent);
    }

    public void beranda(View view) {
        Intent intent = new Intent(b6_profil.this, a2_homescreen.class);
        startActivity(intent);
    }
    public void semhas(View view) {
        Intent intent = new Intent(b6_profil.this, a9_semhas.class);
        startActivity(intent);
    }
    public void sidang(View view) {
        Intent intent = new Intent(b6_profil.this, b3_sidang.class);
        startActivity(intent);
    }
}