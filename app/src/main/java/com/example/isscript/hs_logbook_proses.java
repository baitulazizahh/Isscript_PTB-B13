package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class hs_logbook_proses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hs_logbook_proses);
    }
    public void Refresh(View view) {
        Intent intent = new Intent( hs_logbook_proses.this, hs_logbook_proses2.class);
        startActivity(intent);
    }
    public void Detail(View view) {
        Intent intent = new Intent( hs_logbook_proses.this, detail_pendaftaran_ta.class);
        startActivity(intent);
    }
}