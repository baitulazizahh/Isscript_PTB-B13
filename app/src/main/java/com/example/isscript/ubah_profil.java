package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ubah_profil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_profil);
    }
    public void ubahgambarprofil(View view) {
        Intent intent = new Intent( ubah_profil.this, profil.class);
        startActivity(intent);
    }

}