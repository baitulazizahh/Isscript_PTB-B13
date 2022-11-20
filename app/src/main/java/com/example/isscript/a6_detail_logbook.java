package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class a6_detail_logbook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a6_detail_logbook);
    }
    public void a6listlogbook(View view) {
        Intent intent = new Intent(a6_detail_logbook.this, a5_list_logbook.class);
        startActivity(intent);
    }
    public void a6editlogbook(View view) {
        Intent intent = new Intent(a6_detail_logbook.this, a7_tambah_edit_logbook.class);
        startActivity(intent);
    }
}