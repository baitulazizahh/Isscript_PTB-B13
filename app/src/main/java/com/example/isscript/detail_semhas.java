package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class detail_semhas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_semhas);
    }
    public void kembali(View view) {
        Intent intent = new Intent(detail_semhas.this, daftar_peserta.class);
        startActivity(intent);
    }
}