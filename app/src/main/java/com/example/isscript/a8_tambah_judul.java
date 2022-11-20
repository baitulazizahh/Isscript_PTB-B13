package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class a8_tambah_judul extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a8_tambah_judul);
    }
    public void a8kehomescreen(View view) {
        Intent intent = new Intent(a8_tambah_judul.this, a2_homescreen.class);
        startActivity(intent);
    }
    public void a8tambahjudul(View view) {
        Intent intent = new Intent(a8_tambah_judul.this, a2_homescreen.class);
        startActivity(intent);
    }
}