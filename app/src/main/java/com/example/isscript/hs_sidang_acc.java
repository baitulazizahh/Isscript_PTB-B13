package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class hs_sidang_acc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hs_sidang_acc);
    }
    public void Sidang(View view) {
        Intent intent = new Intent( hs_sidang_acc.this,hs_sidang_acc.class);
        startActivity(intent);
    }
}