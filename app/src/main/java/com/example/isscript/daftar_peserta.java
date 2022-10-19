package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;



public class daftar_peserta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_peserta);
    }



    public void detailsemhas(View view) {
        Intent intent = new Intent(daftar_peserta.this, detail_semhas.class);
        startActivity(intent);
    }
    public void sidangg(View view) {
        Intent intent = new Intent(daftar_peserta.this, sidang2.class);
        startActivity(intent);
    }
}