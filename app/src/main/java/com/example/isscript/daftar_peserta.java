package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;

import com.example.isscript.adapters.PesertaAdapter;
import com.example.isscript.models.Peserta;

import java.util.ArrayList;


public class daftar_peserta extends AppCompatActivity {
    private RecyclerView rvPeserta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_peserta);
//        PesertaAdapter adapter = new PesertaAdapter(getPeserta());
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//
//        rvPeserta.setLayoutManager(layoutManager);
//        rvPeserta.setAdapter(adapter);

    }
//    public ArrayList<Peserta> getPeserta() {
//        ArrayList<Peserta> listPeserta = new ArrayList<>();
//
//        listPeserta.add(new Peserta(
//                "Baitul Azizah",
//                "2011521002"
//
//        ));
//        listPeserta.add(new Peserta(
//                "Salma",
//                "2011522002"
//        ));
//        listPeserta.add(new Peserta(
//                "Baitul Azizah",
//                "2011521002"
//
//        ));
//        listPeserta.add(new Peserta(
//                "Salma",
//                "2011522002"
//        ));
//
//        return listPeserta;
//    }




    public void detailsemhas(View view) {
        Intent intent = new Intent(daftar_peserta.this, detail_semhas.class);
        startActivity(intent);
    }
    public void sidangg(View view) {
        Intent intent = new Intent(daftar_peserta.this, sidang2.class);
        startActivity(intent);
    }
}