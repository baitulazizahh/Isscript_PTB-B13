package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.isscript.datamodels.User;

public class b6_profil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b6_profil);

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

/*    public void tampilUser(User user) {
        SharedPreferences sharedPref = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPref.edit();
        editor.putInt("id", user.getId());
        editor.putString("nama", user.getName());
        editor.putString("nim", user.getUsername());

        editor.apply();

    }*/

/*    public boolean isLoggedIn(){
        SharedPreferences sharedPref = getSharedPreferences("pref", MODE_PRIVATE);
        return sharedPref.getInt("id",-1)!= -1;
    }

    public User getUser(){
        SharedPreferences sharedPref = getSharedPreferences("pref", MODE_PRIVATE);

        return new User(
                sharedPref.getInt("id", -1),
                sharedPref.getString("nama", null),
                sharedPref.getString("nim", null)
        );

    }*/

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