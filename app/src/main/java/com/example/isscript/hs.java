package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;

import com.example.isscript.adapters.JadwalAdapter;
import com.example.isscript.models.Jadwal;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class hs extends AppCompatActivity {

    private RecyclerView rvJadwal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hs);

        rvJadwal = findViewById(R.id.rv_jadwal);

        JadwalAdapter adapter = new JadwalAdapter(getJadwal());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvJadwal.setLayoutManager(layoutManager);
        rvJadwal.setAdapter(adapter);
    }

    public ArrayList<Jadwal> getJadwal() {
        ArrayList<Jadwal> listJadwal = new ArrayList<>();

        listJadwal.add(new Jadwal(
                "Salma",
                "2011522002",
                null,
                1,
                "Rabu, 1 Januari 2023",
                "10.00 - 12.00 WIB",
                "Ruang sidang SI"
        ));
        listJadwal.add(new Jadwal(
                "Tuti Astuti",
                "2011522003",
                null,
                1,
                "Kamis, 2 Januari 2023",
                "10.00 - 12.00 WIB",
                "Ruang sidang SI"
        ));
        listJadwal.add(new Jadwal(
                "Cici Melia",
                "2011522004",
                null,
                1,
                "Jumat, 3 Januari 2023",
                "10.00 - 12.00 WIB",
                "Ruang sidang SI"
        ));
        listJadwal.add(new Jadwal(
                "Salma",
                "2011522002",
                null,
                1,
                "Rabu, 1 Januari 2023",
                "10.00 - 12.00 WIB",
                "Ruang sidang SI"
        ));
        listJadwal.add(new Jadwal(
                "Tuti Astuti",
                "2011522003",
                null,
                1,
                "Kamis, 2 Januari 2023",
                "10.00 - 12.00 WIB",
                "Ruang sidang SI"
        ));
        listJadwal.add(new Jadwal(
                "Cici Melia",
                "2011522004",
                null,
                1,
                "Jumat, 3 Januari 2023",
                "10.00 - 12.00 WIB",
                "Ruang sidang SI"
        ));

        return listJadwal;
    }

    public void daftarta(View view) {
        Intent intent = new Intent(hs.this, pendaftaran_ta.class);
        startActivity(intent);
    }
    public void beranda(View view) {
        Intent intent = new Intent(hs.this, hs.class);
        startActivity(intent);
    }
    public void semhas(View view) {
        Intent intent = new Intent(hs.this, semhas1.class);
        startActivity(intent);
    }
    public void sidang(View view) {
        Intent intent = new Intent(hs.this, sidang1.class);
        startActivity(intent);
    }
    public void profil(View view) {
        Intent intent = new Intent(hs.this, profil.class);
        startActivity(intent);
    }
}