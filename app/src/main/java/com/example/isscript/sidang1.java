package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class sidang1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sidang1);
    }
    public void beranda(View view) {
        Intent intent = new Intent(sidang1.this, hs.class);
        startActivity(intent);
    }
    public void semhas(View view) {
        Intent intent = new Intent(sidang1.this, semhas1.class);
        startActivity(intent);
    }
    public void sidang(View view) {
        Intent intent = new Intent(sidang1.this, sidang1.class);
        startActivity(intent);
    }
    public void profil(View view) {
        Intent intent = new Intent(sidang1.this, profil.class);
        startActivity(intent);
    }
}