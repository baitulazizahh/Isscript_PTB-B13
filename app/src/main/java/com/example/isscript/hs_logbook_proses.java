package com.example.isscript;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.isscript.adapter_listlogbook.listlogbook_adapter;
import com.example.isscript.models_listlogbook.logbook;

import java.util.ArrayList;

public class hs_logbook_proses extends AppCompatActivity {

    private RecyclerView rvLogbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hs_logbook_proses);

        rvLogbook = findViewById(R.id.rv_logbook);

        listlogbook_adapter adapter = new listlogbook_adapter(getlogbook());
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

        return listlogbook;
    }
    public void Refresh(View view) {
        Intent intent = new Intent( hs_logbook_proses.this, hs_logbook_proses2.class);
        startActivity(intent);
    }
    public void Detail(View view) {
        Intent intent = new Intent( hs_logbook_proses.this, detail_pendaftaran_ta.class);
        startActivity(intent);
    }
}