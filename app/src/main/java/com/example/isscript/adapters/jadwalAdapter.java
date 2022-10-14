package com.example.isscript.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class jadwalAdapter extends RecyclerView.Adapter<jadwalAdapter.jadwalViewHolder> {

    Arraylist<Jadwal>

    @NonNull
    @Override
    public jadwalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull jadwalViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class jadwalViewHolder extends RecyclerView.ViewHolder {
        public jadwalViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
