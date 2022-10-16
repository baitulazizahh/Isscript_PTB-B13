package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class sidang2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidang2);
    }
    public void daftarsidang(View view) {
        Intent intent = new Intent(sidang2.this, pengajuan_sidang.class);
        startActivity(intent);
    }
}