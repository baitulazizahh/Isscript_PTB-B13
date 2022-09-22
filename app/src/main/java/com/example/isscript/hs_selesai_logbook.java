package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class hs_selesai_logbook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hs_selesai_logbook);
    }
    public void tambahlagilogbook(View view) {
        Intent intent = new Intent( hs_selesai_logbook.this, tambahlogbook2.class);
        startActivity(intent);
    }
}