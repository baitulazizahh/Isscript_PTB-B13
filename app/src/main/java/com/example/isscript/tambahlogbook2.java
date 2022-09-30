package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tambahlogbook2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahlogbook2);
    }
    public void lb2(View view) {
        Intent intent = new Intent( tambahlogbook2.this, hs_ajukan_judul2.class);
        startActivity(intent);
    }
}