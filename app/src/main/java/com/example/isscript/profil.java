package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class profil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
    }
    public void beranda(View view) {
        Intent intent = new Intent(profil.this, hs.class);
        startActivity(intent);
    }
    public void semhas(View view) {
        Intent intent = new Intent(profil.this, semhas1.class);
        startActivity(intent);
    }
    public void sidang(View view) {
        Intent intent = new Intent(profil.this, sidang1.class);
        startActivity(intent);
    }
    public void profil(View view) {
        Intent intent = new Intent(profil.this, profil.class);
        startActivity(intent);
    }
    public void ubahprofil(View view) {
        Intent intent = new Intent(profil.this, ubah_profil.class);
        startActivity(intent);
    }
    public void gantipassword(View view) {
        Intent intent = new Intent(profil.this, ganti_password.class);
        startActivity(intent);
    }
    public void Keluar(View view) {
        Intent intent = new Intent(profil.this, start.class);
        startActivity(intent);
    }
}