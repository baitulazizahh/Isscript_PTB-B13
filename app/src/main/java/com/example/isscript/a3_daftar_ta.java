package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class a3_daftar_ta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3_daftar_ta);
    }
    public void a3kehomescreen(View view) {
        Intent intent = new Intent(a3_daftar_ta.this, a2_homescreen.class);
        startActivity(intent);
    }
    public void a31kehomescreen(View view) {
        Intent intent = new Intent(a3_daftar_ta.this, a2_homescreen.class);
        startActivity(intent);
    }
}