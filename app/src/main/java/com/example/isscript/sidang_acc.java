package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class sidang_acc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidang_acc);
    }
    public void detailsidang(View view) {
        Intent intent = new Intent( sidang_acc.this, detail_sidang.class);
        startActivity(intent);
    }
    public void keprofil(View view) {
        Intent intent = new Intent( sidang_acc.this,  profil.class);
        startActivity(intent);
    }
}