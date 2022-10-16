package com.example.isscript.adapter_listlogbook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.isscript.R;
import com.example.isscript.models_listlogbook.logbook;

import java.util.ArrayList;

public class listlogbook_adapter extends RecyclerView.Adapter<listlogbook_adapter.listlogbookVH>{

    ArrayList<logbook> listLoogbook = new ArrayList<>();

    public listlogbook_adapter(ArrayList<logbook> listLoogbook) {
        this.listLoogbook = listLoogbook;
    }

    @NonNull
    @Override
    public listlogbookVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_listlogbook, parent, false);
        return new listlogbookVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull listlogbookVH holder, int position) {
        logbook logbook = listLoogbook.get(position);
        holder.textstatus.setText(logbook.getStatus());
        holder.texttanggal.setText(logbook.getTanggal());
        holder.imageView8.setImageResource(R.drawable.ic_panahkanan);
    }

    @Override
    public int getItemCount() {
        return listLoogbook.size();
    }

    public class listlogbookVH extends RecyclerView.ViewHolder {
        public TextView textstatus,texttanggal;
        public ImageView imageView8;
        public listlogbookVH(@NonNull View itemView) {
            super(itemView);
            textstatus = itemView.findViewById(R.id.textstatus);
            texttanggal = itemView.findViewById(R.id.texttanggal) ;
            imageView8 = itemView.findViewById(R.id.imageView8);
        }
    }
}
