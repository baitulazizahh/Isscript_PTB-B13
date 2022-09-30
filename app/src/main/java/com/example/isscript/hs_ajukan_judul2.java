package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class hs_ajukan_judul2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hs_ajukan_judul2);
    }
    public void edit(View view) {
        Intent intent = new Intent( hs_ajukan_judul2.this, detail_logbook.class);
        startActivity(intent);
    }
    public void ajukanjudulya(View view) {
        Intent intent = new Intent( hs_ajukan_judul2.this, ajukan_judul.class);
        startActivity(intent);
    }
}