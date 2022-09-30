package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tambahlogbook1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahlogbook1);
    }
    public void tambahlogbook(View view) {
        Intent intent = new Intent( tambahlogbook1.this, tambah_logbook.class);
        startActivity(intent);
    }
}