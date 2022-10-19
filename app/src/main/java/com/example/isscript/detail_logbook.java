package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class detail_logbook extends AppCompatActivity {
    String panah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_logbook);

        Intent detailIntent = getIntent();
        if(detailIntent != null){
            panah = detailIntent.getStringExtra("panah");
        }
    }

    public void Edit (View view) {
        Intent intent = new Intent(detail_logbook.this, edit_logbook.class);
        startActivity(intent);
    }
}