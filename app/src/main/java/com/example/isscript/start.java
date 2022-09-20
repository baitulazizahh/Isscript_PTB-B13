package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.os.Handler;

public class start extends AppCompatActivity {
    private int waktu_loading=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        new Handler(). postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home = new Intent(start.this,activity_login.class);
                startActivity(home);
                finish();
            }
        },waktu_loading);

    }
}