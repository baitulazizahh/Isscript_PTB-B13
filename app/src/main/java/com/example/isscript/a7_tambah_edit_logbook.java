package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class a7_tambah_edit_logbook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a7_tambah_edit_logbook);
    }
    public void a7detaillogbook(View view) {
        Intent intent = new Intent(a7_tambah_edit_logbook.this, a6_detail_logbook.class);
        startActivity(intent);
    }
    public void a7tambaheditlogbook(View view) {
        Intent intent = new Intent(a7_tambah_edit_logbook.this, a5_list_logbook.class);
        startActivity(intent);
    }
}