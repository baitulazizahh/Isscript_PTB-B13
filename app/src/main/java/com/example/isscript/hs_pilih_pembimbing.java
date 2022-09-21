package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class hs_pilih_pembimbing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hs_pilih_pembimbing);
    }
    public void PilihPembimbing(View view) {
        Intent intent = new Intent( hs_pilih_pembimbing.this,pilih_pembimbing.class);
        startActivity(intent);
    }
}