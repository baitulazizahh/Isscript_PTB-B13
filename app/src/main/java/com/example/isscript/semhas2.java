package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class semhas2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semhas2);
    }
    public void daftarsemhas(View view) {
        Intent intent = new Intent( semhas2.this, pengajuan_semhas.class);
        startActivity(intent);
    }
}