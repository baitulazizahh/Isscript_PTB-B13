package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class detail_sidang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sidang);
    }
    public void Detail(View view) {
        Intent intent = new Intent(detail_sidang.this, sidang_acc.class);
        startActivity(intent);
    }
}