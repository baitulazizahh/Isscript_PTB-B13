package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class hs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hs);
    }
    public void daftarta(View view) {
        Intent intent = new Intent(hs.this, pendaftaran_ta.class);
        startActivity(intent);
    }
    public void beranda(View view) {
        Intent intent = new Intent(hs.this, hs.class);
        startActivity(intent);
    }
    public void semhas(View view) {
        Intent intent = new Intent(hs.this, semhas1.class);
        startActivity(intent);
    }
    public void sidang(View view) {
        Intent intent = new Intent(hs.this, sidang1.class);
        startActivity(intent);
    }
    public void profil(View view) {
        Intent intent = new Intent(hs.this, profil.class);
        startActivity(intent);
    }
}