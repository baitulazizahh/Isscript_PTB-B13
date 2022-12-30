package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class b5_detail_sidang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b5_detail_sidang);
    }
    public void b5kesidang(View view) {
        Intent intent = new Intent(b5_detail_sidang.this, b3_sidang.class);
        startActivity(intent);
    }
}