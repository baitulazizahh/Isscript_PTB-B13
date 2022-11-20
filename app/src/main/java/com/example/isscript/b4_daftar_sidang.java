package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class b4_daftar_sidang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b4_daftar_sidang);
    }
    public void b4kesidang(View view) {
        Intent intent = new Intent(b4_daftar_sidang.this, b3_sidang.class);
        startActivity(intent);
    }
    public void b4daftarsidang(View view) {
        Intent intent = new Intent(b4_daftar_sidang.this, b3_sidang.class);
        startActivity(intent);
    }
}