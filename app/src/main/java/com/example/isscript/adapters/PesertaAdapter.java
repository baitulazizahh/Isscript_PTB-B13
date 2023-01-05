package com.example.isscript.adapters;


import com.example.isscript.datamodels.AudiencesItem;
import com.example.isscript.models.Peserta;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.isscript.R;

import java.util.ArrayList;
import java.util.List;

public class PesertaAdapter extends RecyclerView.Adapter<PesertaAdapter.PesertaViewHolder>{

    private List<AudiencesItem> itemList= new ArrayList<>();

    public void setItemList(List<AudiencesItem> itemList) {

        this.itemList = itemList;
        notifyDataSetChanged();
    }


    ArrayList<Peserta>listPeserta = new ArrayList<>();

    public PesertaAdapter() {
        this.listPeserta = listPeserta;
    }

    @NonNull
    @Override
    public PesertaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.peserta,parent,false);
        return new PesertaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PesertaViewHolder holder, int position) {

        AudiencesItem list = itemList.get(position);

        holder.textNama.setText(list.getName());
        holder.textNim.setText(list.getNim());

/*        Peserta peserta = listPeserta.get(position);
        holder.textNama.setText(peserta.getNama());
        holder.textNim.setText(peserta.getNim());*/

    }
    @Override
    public int getItemCount() {

        return itemList.size();
    }

    public class PesertaViewHolder extends RecyclerView.ViewHolder {

        public TextView textNama, textNim;


        public PesertaViewHolder(@NonNull View itemView) {
            super(itemView);
            textNama = itemView.findViewById(R.id.textNama);
            textNim= itemView.findViewById(R.id.textNim);

        }
    }

}