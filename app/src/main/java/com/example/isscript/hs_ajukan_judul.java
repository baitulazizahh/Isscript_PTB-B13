package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class hs_ajukan_judul extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hs_ajukan_judul);
    }



    public void selesailogbook(View view) {
        Intent intent = new Intent( hs_ajukan_judul.this, hs_selesai_logbook.class);
        startActivity(intent);
    }
}