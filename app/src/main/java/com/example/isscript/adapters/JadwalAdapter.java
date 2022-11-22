package com.example.isscript.adapters;

import com.example.isscript.models.Jadwal;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.isscript.R;

import java.util.ArrayList;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.JadwalViewHolder>{

    ArrayList<Jadwal> ListJadwal = new ArrayList<>();

    public JadwalAdapter(ArrayList<Jadwal> listJadwal) {
        this.ListJadwal = listJadwal;
    }

    @NonNull
    @Override
    public JadwalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.jadwal,parent,false);
        return new JadwalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalViewHolder holder, int position) {
        Jadwal jadwal = ListJadwal.get(position);
        holder.textNama.setText(jadwal.getNama());
        holder.textNim.setText(jadwal.getNim());
        holder.imageLencana.setImageResource(R.drawable.lencana_semhas);
        holder.textJenisAcara.setText(jadwal.getJenisAcara());
        holder.textTanggal.setText(jadwal.getTanggal());
        holder.textJam.setText(jadwal.getJam());
        holder.textLokasi.setText(jadwal.getLokasi());
        holder.imageIconTanggal.setImageResource(R.drawable.ic_kalender);
        holder.imageIconJam.setImageResource(R.drawable.ic_jam);
        holder.imageIconLokasi.setImageResource(R.drawable.ic_pin);
    }

    @Override
    public int getItemCount() {
        return ListJadwal.size();
    }

    public class JadwalViewHolder extends RecyclerView.ViewHolder {

        public TextView textNama, textNim, textJenisAcara, textTanggal, textJam, textLokasi;
        public ImageView imageLencana, imageIconTanggal, imageIconJam, imageIconLokasi;

        public JadwalViewHolder(@NonNull View itemView) {
            super(itemView);
            imageIconTanggal = itemView.findViewById(R.id.imageIconTanggal);
            imageIconJam = itemView.findViewById(R.id.imageIconJam);
            imageIconLokasi = itemView.findViewById(R.id.imageIconLokasi);
            imageLencana = itemView.findViewById(R.id.imageLencana);
            textNama = itemView.findViewById(R.id.textNama);
            textNim = itemView.findViewById(R.id.textNim);
            textJenisAcara = itemView.findViewById(R.id.textJenisAcara);
            textTanggal = itemView.findViewById(R.id.textTanggal);
            textJam = itemView.findViewById(R.id.textJam);
            textLokasi = itemView.findViewById(R.id.textLokasi);
        }
    }
}
