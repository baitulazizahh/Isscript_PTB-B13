package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import com.example.isscript.adapters.PesertaAdapter;
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
    public void selesaitambahpeserta(View view) {
        Intent intent = new Intent(tambah_peserta.this, daftar_peserta.class);
        startActivity(intent);
    }

    public void siapdaftarsemhas(View view) {
    }
}
    ublic ArrayList<Peserta> getPeserta() {
        ArrayList<Peserta>listPeserta = new ArrayList<>();

        listPeserta.add(new Peserta(
                "Baitul Azizah",
                "2011521002"

        ));
        listPeserta.add(new Peserta(
                "Salma",
                "2011522002"
        ));

        return listPeserta;
    };