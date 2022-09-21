package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class pengajuan_semhas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengajuan_semhas);
    }

    public void Ajukan (View view) {
        Intent intent = new Intent(pengajuan_semhas.this, hs.class);
        startActivity(intent);
    }
}