package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class detail_logbook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_logbook);
    }

    public void Edit (View view) {
        Intent intent = new Intent(detail_logbook.this, hs.class);
        startActivity(intent);
    }
}