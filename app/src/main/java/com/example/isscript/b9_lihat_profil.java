package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class b9_lihat_profil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b9_lihat_profil);
    }
    public void keprofillagi(View view) {
        Intent intent = new Intent(b9_lihat_profil.this, b6_profil.class);
        startActivity(intent);
    }
}