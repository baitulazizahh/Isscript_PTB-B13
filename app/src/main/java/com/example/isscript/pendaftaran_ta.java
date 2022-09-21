package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class pendaftaran_ta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran_ta);
    }

    public void Simpan(View view) {
        Intent intent = new Intent( pendaftaran_ta.this, hs_berhasil_daftar_ta.class);
        startActivity(intent);


    }
}