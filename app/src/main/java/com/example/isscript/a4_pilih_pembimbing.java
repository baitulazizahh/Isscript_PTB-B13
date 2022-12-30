package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class a4_pilih_pembimbing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a4_pilih_pembimbing);
    }
    public void a4kehomescreen(View view) {
        Intent intent = new Intent(a4_pilih_pembimbing.this, a2_homescreen.class);
        startActivity(intent);
    }
    public void a41kehomescreen(View view) {
        Intent intent = new Intent(a4_pilih_pembimbing.this, a2_homescreen.class);
        startActivity(intent);
    }
}