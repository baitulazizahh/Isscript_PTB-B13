package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.isscript.datamodels.ProfilResponse;
import com.example.isscript.retrofit.StoryClient;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class b9_lihat_profil extends AppCompatActivity {

    TextView tvnama, tvnim, tvemail;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b9_lihat_profil);

        SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);
        token = sharedPref.getString("TOKEN", "");

        tampilProfil2();
    }
    public void tampilProfil2(){
        tvnama = findViewById(R.id.textView);
        tvnim = findViewById(R.id.username1);
        tvnim = findViewById(R.id.email1);
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
                        tvemail.setText("Email mahasiswa");
                        return;
                    }else {
                        ProfilResponse profilResponse =response.body();

                        String name = profilResponse.getName();
                        String username = profilResponse.getUsername();
                        String email = profilResponse.getEmail();

                        tvnama.setText(name);
                        tvnim.setText(username);
                        tvemail.setText(email);
                    }
                }
            }
            @Override
            public void onFailure(Call<ProfilResponse> call, Throwable t) {
                Toast.makeText(b9_lihat_profil.this, "Terjadi error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void keprofillagi(View view) {
        Intent intent = new Intent(b9_lihat_profil.this, b6_profil.class);
        startActivity(intent);
    }
}