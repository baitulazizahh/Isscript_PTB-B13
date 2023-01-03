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

public class a5_list_logbook extends AppCompatActivity implements listlogbook_adapter.logbookClickListener{
    private RecyclerView rvLogbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a5_list_logbook);


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
                null,
                "1 Maret 2022",
                null
        ));
        listlogbook.add(new logbook(
                null,
                "2 Maret 2022",
                null
        ));
        listlogbook.add(new logbook(
                null,
                "3 Maret 2022",
                null
        ));
        return listlogbook;
    }

    public void a5kehomescreen(View view) {
        Intent intent = new Intent(a5_list_logbook.this, a2_homescreen.class);
        startActivity(intent);
    }
    public void a5tambahlogbook(View view) {
        Intent intent = new Intent(a5_list_logbook.this,c1_tambah_logbook .class);
        startActivity(intent);
    }

    @Override
    public void onlogbookClick(logbook logbook) {
        Intent detaillogbook = new Intent(this, a6_detail_logbook.class);
        detaillogbook.putExtra("panah",logbook.getPanah());
        startActivity(detaillogbook);
    }
}