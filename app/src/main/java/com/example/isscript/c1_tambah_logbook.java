package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.isscript.datamodels.GantipwResponse;
import com.example.isscript.retrofit.StoryClient;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class c1_tambah_logbook extends AppCompatActivity {

    Button btn_tmbhlogbook;
    TextView tv_tgl, tiet4, tiet5;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c1_tambah_logbook);

        SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);
        token = sharedPref.getString("TOKEN", "");

        btn_tmbhlogbook= findViewById(R.id.button);
        btn_tmbhlogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tmbhLogbook();
            }
        });
    }

    private void tmbhLogbook() {
        tv_tgl = findViewById(R.id.textNim);
        tiet4 = findViewById(R.id.textInputEditText4);
        tiet5 = findViewById(R.id.textInputEditText5);
        btn_tmbhlogbook = findViewById(R.id.button);

        String date = tv_tgl.getText().toString();
        String progress = tiet4.getText().toString();
        String problem = tiet5.getText().toString();

        btn_tmbhlogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(new OkHttpClient.Builder().build())
                        .build();
                StoryClient client = retrofit.create(StoryClient.class);

                Call<GantipwResponse> call = client.gantii(String.valueOf(tv_tgl),progress,problem,"Bearer "+token);
                call.enqueue(new Callback<GantipwResponse>() {
                    @Override
                    public void onResponse(Call<GantipwResponse> call, Response<GantipwResponse> response) {
                        if (response.isSuccessful()) {
                            GantipwResponse gantipwResponse = response.body();
                            if (gantipwResponse != null) {
                                Toast.makeText(c1_tambah_logbook.this, "Berhasil tambah logbook", Toast.LENGTH_SHORT).show();

                                SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);
                                SharedPreferences.Editor editor= sharedPref.edit();
                                editor.apply();

                                Intent Intent = new Intent(c1_tambah_logbook.this,a2_homescreen.class);
                                startActivity(Intent);
                            }
                        } else {
                            Toast.makeText(c1_tambah_logbook.this, "Gagal menambah logbook", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<GantipwResponse> call, Throwable t) {
                        Toast.makeText(c1_tambah_logbook.this, "Gagal koneksi ke server", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public void c1kehomescreen(View view) {
        Intent intent = new Intent(c1_tambah_logbook.this, a2_homescreen.class);
        startActivity(intent);
    }

    public void btnc1kehomescreen2(View view) {
        Intent intent = new Intent(c1_tambah_logbook.this, a2_homescreen.class);
        startActivity(intent);
    }
}