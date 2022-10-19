package com.example.isscript.adapters;


import com.example.isscript.models.Peserta;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.isscript.R;

import java.util.ArrayList;

public class PesertaAdapter extends RecyclerView.Adapter<DataPesertaViewHolder>{


    ArrayList<Peserta>listPeserta = new ArrayList<>();

    public PesertaAdapter(ArrayList<Peserta> listPeserta) {
        this.listPeserta = listPeserta;
    }

    @NonNull
    @Override
    public PesertaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_peserta,parent,false);
        return new PesertaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PesertaViewHolder holder, int position) {

        Peserta peserta = listPeserta.get(position);
        holder.textnama.setText(peserta.getnama());
        holder.textnim.setText(peserta.getnim());

    }
    @Override
    public int getItemCount() {
        return listPeserta.size();
    }

    public class PesertaViewHolder extends RecyclerView.ViewHolder {

        public TextView textnama, textnim;


        public PesertaViewHolder(@NonNull View itemView) {
            super(itemView);
            textnama = itemView.findViewById(R.id.textnama);
            textnim = itemView.findViewById(R.id.textnim);

        }
    }

}