package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class tambah_peserta1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_peserta1);
    }

    public void siapdaftarsemhas(View view) {
        Intent intent = new Intent( tambah_peserta1.this, tambah_peserta.class);
        startActivity(intent);
    }

    public void tambahpeserta(View view) {
        Intent intent = new Intent( tambah_peserta1.this, tambah_peserta.class);
        startActivity(intent);
    }
}