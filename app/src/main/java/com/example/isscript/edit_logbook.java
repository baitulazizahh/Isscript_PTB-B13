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

    public void Simpan (View view) {
        Intent intent = new Intent(edit_logbook.this, hs_logbook_proses2.class);
        startActivity(intent);
    }
}