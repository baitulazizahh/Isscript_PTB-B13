package com.example.isscript.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.isscript.R;
import com.example.isscript.models.logbook;

import java.util.ArrayList;

public class listlogbook_adapter extends RecyclerView.Adapter<listlogbook_adapter.listlogbookVH>{

    ArrayList<logbook> listLoogbook = new ArrayList<>();
    logbookClickListener listenerlb;


    public listlogbook_adapter(ArrayList<logbook> listLoogbook) {
        this.listLoogbook = listLoogbook;
    }

    public void setListLoogbook(ArrayList<logbook> listLoogbook) {
        this.listLoogbook = listLoogbook;
    }

    public void setListenerlb(logbookClickListener listenerlb) {
        this.listenerlb = listenerlb;
    }


    @NonNull
    @Override
    public listlogbookVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_listlogbook2, parent, false);
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

    public interface logbookClickListener{
        void onlogbookClick(logbook logbook);
    }

    public class listlogbookVH extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView textstatus,texttanggal;
        public ImageView imageView8;

        public listlogbookVH(@NonNull View itemView) {
            super(itemView);
            textstatus = itemView.findViewById(R.id.textstatus);
            texttanggal = itemView.findViewById(R.id.texttanggal) ;
            imageView8 = itemView.findViewById(R.id.imageView8);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            logbook logbook = listLoogbook.get(getAdapterPosition());
            listenerlb.onlogbookClick(logbook);
        }
    }
}
