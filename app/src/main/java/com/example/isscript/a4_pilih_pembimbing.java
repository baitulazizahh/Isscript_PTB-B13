package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.isscript.datamodels.GantipwResponse;
import com.example.isscript.datamodels.PembimbingResponse;
import com.example.isscript.retrofit.StoryClient;

import java.util.Objects;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class a4_pilih_pembimbing extends AppCompatActivity {

    TextView judul, abstrak, pembimbing, posisi;
    Button tambah_btn;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a4_pilih_pembimbing);
        tambah_btn = findViewById(R.id.button);

        SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);
        token = sharedPref.getString("TOKEN", "");

        tambah_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tambahjudul();
            }
        });
    }
    public void tambahjudul() {
        judul = findViewById(R.id.textInputEditText3);
        abstrak = findViewById(R.id.textInputEditText31);
        pembimbing = findViewById(R.id.textInputEditText32);
        posisi = findViewById(R.id.textInputEditText33);

        tambah_btn = findViewById(R.id.button);

        String title = judul.getText().toString();
        String abstracts = abstrak.getText().toString();
        String lecturer_id = pembimbing.getText().toString();
        String position = posisi.getText().toString();

        tambah_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(new OkHttpClient.Builder().build())
                        .build();

                StoryClient client = retrofit.create(StoryClient.class);

                Call<PembimbingResponse> call = client.pilihpembimbing(title,abstracts, lecturer_id, position,"Bearer "+token);

                call.enqueue(new Callback<PembimbingResponse>() {
                    @Override
                    public void onResponse(Call<PembimbingResponse> call, Response<PembimbingResponse> response) {

                        if (response.isSuccessful()) {
                            PembimbingResponse tambahJudulResponse = response.body();
                            if (tambahJudulResponse != null) {
                                Toast.makeText(a4_pilih_pembimbing.this, "Berhasil pilih pembimbing", Toast.LENGTH_SHORT).show();

                                SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);
                                SharedPreferences.Editor editor= sharedPref.edit();
                                editor.apply();

                                Intent Intent = new Intent(a4_pilih_pembimbing.this, a2_homescreen.class);
                                startActivity(Intent);
                            }
                        } else {
                            Toast.makeText(a4_pilih_pembimbing.this, "Gagal pilih pembimbing", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<PembimbingResponse> call, Throwable t) {
                        Toast.makeText(a4_pilih_pembimbing.this, "Gagal pilih pembimbing", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public void a8kehomescreen(View view) {
        Intent intent = new Intent(a4_pilih_pembimbing.this, a2_homescreen.class);
        startActivity(intent);
    }
}