package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class pengajuan_semhas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengajuan_semhas);
    }
    public void ajukan_semhas(View view) {
        Intent intent = new Intent(pengajuan_semhas.this, semhas_menunggu_acc.class);
        startActivity(intent);
    }
}