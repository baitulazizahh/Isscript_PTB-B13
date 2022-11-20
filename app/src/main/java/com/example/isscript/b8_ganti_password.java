package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class b8_ganti_password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b8_ganti_password);
    }
    public void b8keprofil(View view) {
        Intent intent = new Intent(b8_ganti_password.this, b6_profil.class);
        startActivity(intent);
    }
    public void b8gantipassword(View view) {
        Intent intent = new Intent(b8_ganti_password.this, b6_profil.class);
        startActivity(intent);
    }
}