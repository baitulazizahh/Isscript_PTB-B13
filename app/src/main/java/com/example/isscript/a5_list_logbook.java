package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.isscript.adapters.listlogbook_adapter;
import com.example.isscript.datamodels.ListLogbookResponse;
import com.example.isscript.datamodels.LogbooksItem;
import com.example.isscript.datamodels.LoginResponse;
import com.example.isscript.models.logbook;
import com.example.isscript.retrofit.StoryClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class a5_list_logbook extends AppCompatActivity implements listlogbook_adapter.logbookClickListener{
    private RecyclerView rvLogbook;
    private listlogbook_adapter adapter;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a5_list_logbook);

        SharedPreferences sharedPref = getSharedPreferences("Pref", Context.MODE_PRIVATE);
        token = sharedPref.getString("TOKEN","");


        /*        LinearLayoutManager layoutManager = new LinearLayoutManager(this);*/

/*        rvLogbook.setLayoutManager(layoutManager);
        rvLogbook.setAdapter(adapter);*/



        RecyclerView rvLogbook = findViewById(R.id.rv_logbook);

        rvLogbook.setLayoutManager(new LinearLayoutManager(this));
        adapter = new listlogbook_adapter();
        adapter.setListenerlb(this);
        rvLogbook.setAdapter(adapter);

        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();
        StoryClient client = retrofit.create(StoryClient.class);

        Call<ListLogbookResponse> call = client.getlistLB("Bearer "+token);
        call.enqueue(new Callback<ListLogbookResponse>() {
            @Override
            public void onResponse(Call<ListLogbookResponse> call, Response<ListLogbookResponse> response) {
                ListLogbookResponse listLogbookkResponse = response.body();
                if (listLogbookkResponse != null){
                    List<LogbooksItem> logbooks = listLogbookkResponse.getLogbooks();
                    adapter.setItemList(logbooks);
                }
            }

            @Override
            public void onFailure(Call<ListLogbookResponse> call, Throwable t) {

            }
        });

        /*list_logbook_adapter adapter = new list_logbook_adapter(getlogbook());
        adapter.setListenerlb(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvLogbook.setLayoutManager(layoutManager);
        rvLogbook.setAdapter(adapter);*/

    }

    public void a5kehomescreen(View view) {
        Intent intent = new Intent(a5_list_logbook.this, a2_homescreen.class);
        startActivity(intent);
    }
    public void a5tambahlogbook(View view) {
        Intent intent = new Intent(a5_list_logbook.this, a7_edit_logbook.class);
        startActivity(intent);
    }

    @Override
    public void onlogbookClick(LogbooksItem logbook) {
        Intent detaillogbook = new Intent(this, a6_detail_logbook.class);
        detaillogbook.putExtra("panah",logbook.getDate());
        startActivity(detaillogbook);
    }
}
