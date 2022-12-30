package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class b3_sidang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b3_sidang);
    }
    public void b3kedetailsidang(View view) {
        Intent intent = new Intent(b3_sidang.this, b5_detail_sidang.class);
        startActivity(intent);
    }
    public void b3kedaftarsidang(View view) {
        Intent intent = new Intent(b3_sidang.this, b4_daftar_sidang.class);
        startActivity(intent);
    }

    public void beranda(View view) {
        Intent intent = new Intent(b3_sidang.this, a2_homescreen.class);
        startActivity(intent);
    }
    public void semhas(View view) {
        Intent intent = new Intent(b3_sidang.this, a9_semhas.class);
        startActivity(intent);
    }
    public void sidang(View view) {
        Intent intent = new Intent(b3_sidang.this, b3_sidang.class);
        startActivity(intent);
    }
    public void profil(View view) {
        Intent intent = new Intent(b3_sidang.this, b6_profil.class);
        startActivity(intent);
    }
}