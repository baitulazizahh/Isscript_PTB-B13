package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.isscript.adapters.PesertaAdapter;
import com.example.isscript.models.Peserta;

import java.util.ArrayList;

public class a9_semhas extends AppCompatActivity {
    private RecyclerView rvPeserta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a9_semhas);

        rvPeserta = findViewById(R.id.rv_listpeserta);

        PesertaAdapter adapter = new PesertaAdapter(getPeserta());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvPeserta.setLayoutManager(layoutManager);
        rvPeserta.setAdapter(adapter);
    }

    public ArrayList<Peserta> getPeserta() {
        ArrayList<Peserta> listPeserta = new ArrayList<>();

        listPeserta.add(new Peserta(
                "Baitul Azizah",
                "2011521002"

        ));
        listPeserta.add(new Peserta(
                "Salma",
                "2011522002"
        ));
        listPeserta.add(new Peserta(
                "Baitul Azizah",
                "2011521002"

        ));
        listPeserta.add(new Peserta(
                "Salma",
                "2011522002"
        ));

        return listPeserta;
    }

    public void a9detailsemhas(View view) {
        Intent intent = new Intent(a9_semhas.this, b2_detail_semhas.class);
        startActivity(intent);
    }
    public void a9kedaftarsemhas(View view) {
        Intent intent = new Intent(a9_semhas.this, b1_daftar_semhas.class);
        startActivity(intent);
    }

    public void beranda(View view) {
        Intent intent = new Intent(a9_semhas.this, a2_homescreen.class);
        startActivity(intent);
    }
    public void semhas(View view) {
        Intent intent = new Intent(a9_semhas.this, a9_semhas.class);
        startActivity(intent);
    }
    public void sidang(View view) {
        Intent intent = new Intent(a9_semhas.this, b3_sidang.class);
        startActivity(intent);
    }
    public void profil(View view) {
        Intent intent = new Intent(a9_semhas.this, b6_profil.class);
        startActivity(intent);
    }
}