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

public class selesai_edit extends AppCompatActivity implements listlogbook_adapter.logbookClickListener{

    private RecyclerView rvLogbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selesai_edit);


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
                "Dalam Proses",
                "1 Maret 2022",
                null
        ));
        listlogbook.add(new logbook(
                "Dalam Proses",
                "2 Maret 2022",
                null
        ));
        listlogbook.add(new logbook(
                "Dalam Proses",
                "3 Maret 2022",
                null
        ));
        return listlogbook;
    }

    @Override
    public void onlogbookClick(logbook logbook) {
        Intent detaillogbook = new Intent(this, detail_logbook_setelah_acc.class);
        detaillogbook.putExtra("panah",logbook.getPanah());
        startActivity(detaillogbook);
    }
    public void selesaieditya(View view) {
        Intent intent = new Intent( selesai_edit.this, ajukan_judul.class);
        startActivity(intent);
    }
}
