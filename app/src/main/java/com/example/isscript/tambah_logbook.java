package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tambah_logbook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_logbook);
    }
    public void Tambah(View view) {
        Intent intent = new Intent( tambah_logbook.this, hs_ajukan_judul.class);
        startActivity(intent);
    }
}