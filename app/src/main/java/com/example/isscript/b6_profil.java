package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class b6_profil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b6_profil);

        SharedPreferences sharedPref = getSharedPreferences("pref", MODE_PRIVATE);
        String token = sharedPref.getString("TOKEN", "");
    }

    public void logout(View view) {
        SharedPreferences sharedPref = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPref.edit();
        editor.clear();
        editor.apply();
        Intent intent5 = new Intent(this, a1_login.class);
        intent5.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent5);
    }

    public void b6kegantifoto(View view) {
        Intent intent = new Intent(b6_profil.this, b7_ganti_foto.class);
        startActivity(intent);
    }
    public void b6kegantipassword(View view) {
        Intent intent = new Intent(b6_profil.this, b8_ganti_password.class);
        startActivity(intent);
    }

    public void beranda(View view) {
        Intent intent = new Intent(b6_profil.this, a2_homescreen.class);
        startActivity(intent);
    }
    public void semhas(View view) {
        Intent intent = new Intent(b6_profil.this, a9_semhas.class);
        startActivity(intent);
    }
    public void sidang(View view) {
        Intent intent = new Intent(b6_profil.this, b3_sidang.class);
        startActivity(intent);
    }
    public void profil(View view) {
        Intent intent = new Intent(b6_profil.this, b6_profil.class);
        startActivity(intent);
    }
}