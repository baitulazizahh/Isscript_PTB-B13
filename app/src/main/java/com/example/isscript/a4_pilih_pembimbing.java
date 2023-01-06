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
import com.example.isscript.datamodels.PilihPembimbingResponse;
import com.example.isscript.retrofit.StoryClient;

import java.util.Objects;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class a4_pilih_pembimbing extends AppCompatActivity {

    TextView pilihPbb;
    Button simpan_btn;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a4_pilih_pembimbing);
        simpan_btn = findViewById(R.id.button);

        SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);
        token = sharedPref.getString("TOKEN", "");

        simpan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tambahjudul();
            }
        });
    }
    public void tambahjudul() {
        pilihPbb = findViewById(R.id.textInputEditText3);

        simpan_btn = findViewById(R.id.button);


        String lecturer_id = pilihPbb.getText().toString();


        simpan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(new OkHttpClient.Builder().build())
                        .build();

                StoryClient client = retrofit.create(StoryClient.class);

                Call<PilihPembimbingResponse> call = client.PilihPbb(lecturer_id,"Bearer "+token);

                call.enqueue(new Callback<PilihPembimbingResponse>() {
                    @Override
                    public void onResponse(Call<PilihPembimbingResponse> call, Response<PilihPembimbingResponse> response) {

                        if (response.isSuccessful()) {
                            PilihPembimbingResponse tambahJudulResponse = response.body();
                            if (tambahJudulResponse != null) {
                                Toast.makeText(a4_pilih_pembimbing.this, "Berhasil tambah judul", Toast.LENGTH_SHORT).show();

                                SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);
                                SharedPreferences.Editor editor= sharedPref.edit();
                                editor.apply();

                                Intent Intent = new Intent(a4_pilih_pembimbing.this, a2_homescreen.class);
                                startActivity(Intent);
                            }
                        } else {
                            Toast.makeText(a4_pilih_pembimbing.this, "Gagal tambah judul ya", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<PilihPembimbingResponse> call, Throwable t) {
                        Toast.makeText(a4_pilih_pembimbing.this, "Gagal tambah judul", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public void a4kehomescreen(View view) {
        Intent intent = new Intent(a4_pilih_pembimbing.this, a2_homescreen.class);
        startActivity(intent);
    }
    public void a41kehomescreen(View view) {
        Intent intent = new Intent(a4_pilih_pembimbing.this, a2_homescreen.class);
        startActivity(intent);
    }
}