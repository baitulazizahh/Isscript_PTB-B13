package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class pengajuan_sidang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengajuan_sidang);
    }
    public void Ajukan(View view) {
        Intent intent = new Intent( pengajuan_sidang.this, sidang_menunggu_acc.class);
        startActivity(intent);
    }
}