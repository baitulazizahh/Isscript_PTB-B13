package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class tambah_peserta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_peserta);
    }
    public void selesaitambahpeserta(View view) {
        Intent intent = new Intent(tambah_peserta.this, daftar_peserta.class);
        startActivity(intent);
    }

    public void siapdaftarsemhas(View view) {
    }
}