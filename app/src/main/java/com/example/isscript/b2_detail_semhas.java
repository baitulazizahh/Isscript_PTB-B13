package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.isscript.datamodels.DetailSemhas2Response;
import com.example.isscript.datamodels.DetailTAResponse;
import com.example.isscript.datamodels.PesertaItem;
import com.example.isscript.datamodels.ReviewersItem;
import com.example.isscript.retrofit.StoryClient;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class b2_detail_semhas extends AppCompatActivity {

    TextView dsnama, dsnim, dspem, dstgl, dsjdl, dsjam, dslok, dspeng;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b2_detail_semhas);

        SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);
        token = sharedPref.getString("TOKEN", "");

        detailSemhas();
    }

    public void detailSemhas() {
        dsnama = findViewById(R.id.textNim);
        dsnim = findViewById(R.id.textJam);
        dspem = findViewById(R.id.textView7);
        dsjdl = findViewById(R.id.textView9);
        dstgl = findViewById(R.id.textView12);
        dsjam = findViewById(R.id.textView14);
        dslok = findViewById(R.id.textView16);
        dspeng = findViewById(R.id.textView18);

        SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);

        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();
        StoryClient client = retrofit.create(StoryClient.class);

        Call<DetailSemhas2Response> call = client.detailSemhas("Bearer " + token);


        call.enqueue(new Callback<DetailSemhas2Response>() {
            @Override
            public void onResponse(Call<DetailSemhas2Response> call, Response<DetailSemhas2Response> response) {
                if (response.isSuccessful()) {

                    DetailSemhas2Response detailSemhas2Response = response.body();


                    String seminarAt = detailSemhas2Response.getSeminarAt();
                    int roomId = detailSemhas2Response.getRoomId();
 /*                   int Id = detailSemhas2Response.getId();*/


                    dstgl.setText(seminarAt);
                    dslok.setText(roomId);
                }
            }

            @Override


            public void onFailure(Call<DetailSemhas2Response> call, Throwable t) {
                Toast.makeText(b2_detail_semhas.this, "Terjadi error", Toast.LENGTH_SHORT).show();
            }
        });


        Call<DetailTAResponse> call4 = client.detailta("Bearer " + token);
        call4.enqueue(new Callback<DetailTAResponse>() {
            @Override
            public void onResponse(Call<DetailTAResponse> call4, Response<DetailTAResponse> response) {
                if (response.isSuccessful()) {

                    DetailTAResponse detailTAResponse = response.body();

                    String title = detailTAResponse.getTitle();
                    //String name =  detailTAResponse.getStudent().getName();
                    String nim =   detailTAResponse.getStudent().getNim();
                    //String name2 = detailTAResponse.getSupervisors().getName();
                    //dsnama.setText(name);
                    dsnim.setText(nim);
                    dsjdl.setText(title);
                    //dspem.setText(name2);
                }
            }

            @Override
            public void onFailure(Call<DetailTAResponse> call4, Throwable t) {
                Toast.makeText(b2_detail_semhas.this, "Terjadi error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void b2kesemhas (View view) {
        Intent intent = new Intent(b2_detail_semhas.this, a9_semhas.class);
        startActivity(intent);
    }

}