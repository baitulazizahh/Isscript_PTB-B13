package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class semhas_menunggu_acc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semhas_menunggu_acc);
    }
    public void tambahpeserta(View view) {
        Intent intent = new Intent(semhas_menunggu_acc.this, tambah_peserta1.class);
        startActivity(intent);
    }
}