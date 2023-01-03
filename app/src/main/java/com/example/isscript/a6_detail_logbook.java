package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.isscript.datamodels.DetailLogbookResponse;
import com.example.isscript.datamodels.ProfilResponse;
import com.example.isscript.retrofit.StoryClient;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class a6_detail_logbook extends AppCompatActivity {
    TextView tvtgl, tvprogress, tvproblem;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a6_detail_logbook);

        SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);
        token = sharedPref.getString("TOKEN", "");

        tampildetaillb();
    }

    private void tampildetaillb() {
        tvtgl = findViewById(R.id.textView3);
        tvprogress = findViewById(R.id.textView5);
        tvproblem = findViewById(R.id.textView7);

        SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);

        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();

        StoryClient client = retrofit.create(StoryClient.class);

        Call<DetailLogbookResponse> call = client.detaillb("Bearer "+token);
        call.enqueue(new Callback<DetailLogbookResponse>() {
            @Override
            public void onResponse(Call<DetailLogbookResponse> call, Response<DetailLogbookResponse> response) {
                if (response.isSuccessful()){
                    if (!response.isSuccessful()) {
                        tvtgl.setText("Nama mahasiswa");
                        tvprogress.setText("NIM mahasiswa");
                        tvproblem.setText("Email mahasiswa");
                        return;
                    }else {
                        DetailLogbookResponse  detailLogbookResponse =response.body();

                        String date = detailLogbookResponse.getDate();
                        String progress= detailLogbookResponse.getProgress();
                        String problem= detailLogbookResponse.getProblem();

                        tvtgl.setText(date);
                        tvprogress.setText(progress);
                        tvproblem.setText(problem);
                    }
                }
            }
            @Override
            public void onFailure(Call<DetailLogbookResponse> call, Throwable t) {
                Toast.makeText(a6_detail_logbook.this, "Terjadi error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void a6listlogbook(View view) {
        Intent intent = new Intent(a6_detail_logbook.this, a5_list_logbook.class);
        startActivity(intent);
    }
    public void a6editlogbook(View view) {
        Intent intent = new Intent(a6_detail_logbook.this, a7_edit_logbook.class);
        startActivity(intent);
    }
}