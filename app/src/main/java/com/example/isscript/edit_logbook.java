package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class edit_logbook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_logbook);
    }
    public void editya(View view) {
        Intent intent = new Intent( edit_logbook.this, hs_ajukan_judul2.class);
        startActivity(intent);
    }
}