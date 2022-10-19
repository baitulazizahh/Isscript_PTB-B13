package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.isscript.adapters.PesertaAdapter;
import com.example.isscript.models.Peserta;

import java.util.ArrayList;


public class tambah_peserta extends AppCompatActivity {
    private RecyclerView rvPeserta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_peserta);

        rvPeserta = findViewById(R.id.rv_listpeserta);

        PesertaAdapter adapter = new PesertaAdapter(getPeserta());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvPeserta.setLayoutManager(layoutManager);
        rvPeserta.setAdapter(adapter);

//        public void selesaitambahpeserta(View view) {
//        };
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


    public void selesaitambahpeserta(View view) {
    }
}