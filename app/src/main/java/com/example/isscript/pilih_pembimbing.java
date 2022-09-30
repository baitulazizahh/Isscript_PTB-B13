package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class pilih_pembimbing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_pembimbing);
    }
    public void Simpan(View view) {
        Intent intent = new Intent( pilih_pembimbing.this, tambahlogbook1.class);
        startActivity(intent);
    }
}