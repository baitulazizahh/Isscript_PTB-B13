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
import com.example.isscript.datamodels.LoginResponse;
import com.example.isscript.retrofit.StoryClient;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class b8_ganti_password extends AppCompatActivity {

    Button btn_gantiPW;
    TextView tiet1, tiet2, tiet3;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b8_ganti_password);

        SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);
        token = sharedPref.getString("TOKEN", "");

        btn_gantiPW = findViewById(R.id.button);
        btn_gantiPW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gantiPW();
            }
        });
    }
    public void b8keprofil(View view) {
        Intent intent = new Intent(b8_ganti_password.this, b6_profil.class);
        startActivity(intent);
    }

    private void gantiPW(){
        tiet1 = findViewById(R.id.textInputEditText1);
        tiet2 = findViewById(R.id.textInputEditText2);
        tiet3 = findViewById(R.id.textInputEditText3);
        btn_gantiPW = findViewById(R.id.button);

        String old_password = tiet1.getText().toString();
        String new_password = tiet2.getText().toString();
        String confirm_password = tiet3.getText().toString();

        btn_gantiPW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(new OkHttpClient.Builder().build())
                        .build();
                StoryClient client = retrofit.create(StoryClient.class);

                Call<GantipwResponse> call = client.gantii(old_password,new_password,confirm_password,"Bearer "+token);
                call.enqueue(new Callback<GantipwResponse>() {
                    @Override
                    public void onResponse(Call<GantipwResponse> call, Response<GantipwResponse> response) {
                        if (response.isSuccessful()) {
                            GantipwResponse gantipwResponse = response.body();
                            if (gantipwResponse != null) {
                                Toast.makeText(b8_ganti_password.this, "Berhasil ganti password", Toast.LENGTH_SHORT).show();

                                SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);
                                SharedPreferences.Editor editor= sharedPref.edit();
                                editor.apply();

                                Intent Intent = new Intent(b8_ganti_password.this, b6_profil.class);
                                startActivity(Intent);
                            }
                        } else {
                            Toast.makeText(b8_ganti_password.this, "Gagal memperbaharui password", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<GantipwResponse> call, Throwable t) {
                        Toast.makeText(b8_ganti_password.this, "Gagal koneksi ke server", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}