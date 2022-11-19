package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ajukan_judul extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajukan_judul);
    }

    public void Simpanya(View view) {
        Intent intent = new Intent( ajukan_judul.this, hs_logbook_proses.class);
        startActivity(intent);
    }
}