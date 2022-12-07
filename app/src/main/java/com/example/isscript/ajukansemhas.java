package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ajukansemhas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajukansemhas);
    }
    public void Kesemhas(View view) {
        Intent intent = new Intent( ajukansemhas.this, pengajuan_semhas.class);
        startActivity(intent);
    }

    public void Ajukansemhas(View view) {
        Intent intent = new Intent( ajukansemhas.this, pengajuan_semhas.class);
        startActivity(intent);
    }

    public void semhas(View view) {
    }

    public void sidang(View view) {
    }

    public void profil(View view) {
    }

    public void beranda(View view) {
    }
}