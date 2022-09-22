package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class selesai_edit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selesai_edit);
    }
    public void selesaieditya(View view) {
        Intent intent = new Intent( selesai_edit.this, ajukan_judul.class);
        startActivity(intent);
    }
}