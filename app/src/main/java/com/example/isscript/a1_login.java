package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class a1_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1_login);
    }
    public void a1masuk(View view) {
        Intent intent = new Intent(a1_login.this, a2_homescreen.class);
        startActivity(intent);
    }
}