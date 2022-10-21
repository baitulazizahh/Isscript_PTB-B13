package com.example.isscript;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;


import android.os.Bundle;
import android.view.MenuItem;

import com.example.isscript.adapters.JadwalAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;



public class homescreen extends AppCompatActivity {

    BottomNavigationView bottomNavigation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        bottomNavigation = findViewById(R.id.bottomNavigationView2);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_homescreen()).commit();

        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.nav_home:
                        selectedFragment = new Fragment_homescreen();
                        break;
                    case R.id.nav_semhas:
                        selectedFragment = new Fragment_semhas();
                        break;
                    case R.id.nav_sidang:
                        selectedFragment = new Fragment_sidang();
                        break;
                    case R.id.nav_profil:
                        selectedFragment = new Fragment_profil();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                return true;
            }
        });
    }
}