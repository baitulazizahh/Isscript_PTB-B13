package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class b7_ganti_foto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b7_ganti_profil);
    }
    public void b7keprofil(View view) {
        Intent intent = new Intent(b7_ganti_foto.this, b9_lihat_profil.class);
        startActivity(intent);
    }
    public void b7gantiprofil(View view) {
        Intent intent = new Intent(b7_ganti_foto.this, b6_profil.class);
        startActivity(intent);
    }
}