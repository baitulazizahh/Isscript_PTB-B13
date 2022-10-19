package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.isscript.adapters.listlogbook_adapter;
import com.example.isscript.models.logbook;

import java.util.ArrayList;

public class hs_logbook_proses2 extends AppCompatActivity implements listlogbook_adapter.logbookClickListener{
    private RecyclerView rvLogbook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hs_logbook_proses2);
        rvLogbook = findViewById(R.id.rv_logbook);

        listlogbook_adapter adapter = new listlogbook_adapter(getlogbook());
        adapter.setListenerlb(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvLogbook.setLayoutManager(layoutManager);
        rvLogbook.setAdapter(adapter);
    }
    public ArrayList<logbook> getlogbook(){
        ArrayList<logbook> listlogbook = new ArrayList<>();
        listlogbook.add(new logbook(
                "Selesai",
                "1 Maret 2022",
                null
        ));
        listlogbook.add(new logbook(
                "Selesai",
                "2 Maret 2022",
                null
        ));
        listlogbook.add(new logbook(
                "Selesai",
                "3 Maret 2022",
                null
        ));
        return listlogbook;
    }
    public void TambahLogbook(View view) {
        Intent intent = new Intent( hs_logbook_proses2.this, tambah_logbook.class);
        startActivity(intent);
    }
    public void Detail(View view) {
        Intent intent = new Intent( hs_logbook_proses2.this, detail_pendaftaran_ta.class);
        startActivity(intent);
    }
    public void DetailLogbook(View view) {
        Intent intent = new Intent( hs_logbook_proses2.this, detail_logbook.class);
        startActivity(intent);
    }
    public void ajukansemhas(View view) {
        Intent intent = new Intent( hs_logbook_proses2.this, semhas2.class);
        startActivity(intent);
    }
    @Override
    public void onlogbookClick(logbook logbook) {
        Intent detaillogbook = new Intent(this, detail_logbook_setelah_acc.class);
        detaillogbook.putExtra("panah",logbook.getPanah());
        startActivity(detaillogbook);
    }
}