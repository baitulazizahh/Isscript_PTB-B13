package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class semhas_menunggu_acc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semhas_menunggu_acc);
    }

    public void Refresh(View view) {
        Intent intent = new Intent( semhas_menunggu_acc.this, hs_logbook_proses2.class);
        startActivity(intent);
    }
}