package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class b2_detail_semhas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b2_detail_semhas);
    }
    public void b2kesemhas(View view) {
        Intent intent = new Intent(b2_detail_semhas.this, a9_semhas.class);
        startActivity(intent);
    }
}