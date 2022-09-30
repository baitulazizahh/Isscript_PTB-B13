package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class sidang_menunggu_acc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidang_menunggu_acc);
    }
    public void selesaiajukansidang(View view) {
        Intent intent = new Intent( sidang_menunggu_acc.this, sidang_acc.class);
        startActivity(intent);
    }
}