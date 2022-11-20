package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class b1_daftar_semhas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b1_daftar_semhas);
    }
    public void b1kesemhas(View view) {
        Intent intent = new Intent(b1_daftar_semhas.this, a9_semhas.class);
        startActivity(intent);
    }
    public void b1daftarsemhas(View view) {
        Intent intent = new Intent(b1_daftar_semhas.this, a9_semhas.class);
        startActivity(intent);
    }
}