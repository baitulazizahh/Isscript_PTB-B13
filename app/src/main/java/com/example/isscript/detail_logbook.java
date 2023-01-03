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


public class detail_logbook extends AppCompatActivity {


    String panah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2_homescreen);




        Intent detailIntent = getIntent();
        if(detailIntent != null){
            panah = detailIntent.getStringExtra("panah");
        }
    }

    private void tampildetaillb() {

    }
}