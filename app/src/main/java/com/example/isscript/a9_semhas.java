package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.isscript.adapters.PesertaAdapter;
import com.example.isscript.datamodels.AudiencesItem;
import com.example.isscript.datamodels.GantipwResponse;
import com.example.isscript.datamodels.InputPesertaResponse;
import com.example.isscript.datamodels.ListResponse;
import com.example.isscript.datamodels.LogoutResponse;
import com.example.isscript.models.Peserta;
import com.example.isscript.retrofit.StoryClient;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class a9_semhas extends AppCompatActivity {
    private RecyclerView rvPesertash;
    private PesertaAdapter adapter;
    Button tambahpeserta_btn;
    TextView stu_id;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a9_semhas);

        SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);
        token = sharedPref.getString("TOKEN", "");

        RecyclerView rvPesertash = findViewById(R.id.rv_listpeserta);

        rvPesertash.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PesertaAdapter();
        rvPesertash.setAdapter(adapter);

        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();
        StoryClient client = retrofit.create(StoryClient.class);

        Call<ListResponse> call = client.listaud("Bearer "+token);
        call.enqueue(new Callback<ListResponse>() {
            @Override
            public void onResponse(Call<ListResponse> call, Response<ListResponse> response) {
                ListResponse listResponse= response.body();
                if (listResponse != null){
                    List<AudiencesItem> audiences = listResponse.getAudiences();
                    adapter.setItemList(audiences);
                }
            }

            @Override
            public void onFailure(Call<ListResponse> call, Throwable t) {

            }
        });

        tambahpeserta_btn = findViewById(R.id.button2);
        tambahpeserta_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tambahpeserta();
            }
        });



    }

    private void tambahpeserta(){
        stu_id = findViewById(R.id.textInputEditText);
        tambahpeserta_btn = findViewById(R.id.button2);

        String student_id = stu_id.getText().toString();

        tambahpeserta_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(new OkHttpClient.Builder().build())
                        .build();
                StoryClient client = retrofit.create(StoryClient.class);

                Call<InputPesertaResponse> call = client.inputt(student_id,"Bearer "+token);
                call.enqueue(new Callback<InputPesertaResponse>() {
                    @Override
                    public void onResponse(Call<InputPesertaResponse> call, Response<InputPesertaResponse> response) {
                        if (response.isSuccessful()) {
                            InputPesertaResponse inputPesertaResponse = response.body();
                            if (inputPesertaResponse != null) {
                                Toast.makeText(a9_semhas.this, "Berhasil input peserta", Toast.LENGTH_SHORT).show();

                                SharedPreferences sharedPref = getSharedPreferences("Pref", MODE_PRIVATE);
                                SharedPreferences.Editor editor= sharedPref.edit();
                                editor.apply();
                            }
                        } else {
                            Toast.makeText(a9_semhas.this, "Inputkan student id", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<InputPesertaResponse> call, Throwable t) {
                        Toast.makeText(a9_semhas.this, "Gagal koneksi ke server", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    /*public ArrayList<Peserta> getPeserta() {
        ArrayList<Peserta> listPeserta = new ArrayList<>();

        listPeserta.add(new Peserta(
                "Baitul Azizah",
                "2011521002"

        ));
        listPeserta.add(new Peserta(
                "Salma",
                "2011522002"
        ));
        listPeserta.add(new Peserta(
                "Baitul Azizah",
                "2011521002"

        ));
        listPeserta.add(new Peserta(
                "Salma",
                "2011522002"
        ));

        return listPeserta;
    }*/

    public void a9detailsemhas(View view) {
        Intent intent = new Intent(a9_semhas.this, b2_detail_semhas.class);
        startActivity(intent);
    }
    public void a9kedaftarsemhas(View view) {
        Intent intent = new Intent(a9_semhas.this, b1_daftar_semhas.class);
        startActivity(intent);
    }

    public void beranda(View view) {
        Intent intent = new Intent(a9_semhas.this, a2_homescreen.class);
        startActivity(intent);
    }
    public void semhas(View view) {
        Intent intent = new Intent(a9_semhas.this, a9_semhas.class);
        startActivity(intent);
    }
    public void sidang(View view) {
        Intent intent = new Intent(a9_semhas.this, b3_sidang.class);
        startActivity(intent);
    }
    public void profil(View view) {
        Intent intent = new Intent(a9_semhas.this, b6_profil.class);
        startActivity(intent);
    }
}