package com.example.isscript;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ajukan_semhas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajukan_semhas);
    }

    public void Ajukansemhas(View view) {
        Intent intent = new Intent( ajukan_semhas.this, pengajuan_semhas.class);
        startActivity(intent);
    }
}
