package com.example.isscript.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.isscript.R;
import com.example.isscript.datamodels.LogbooksItem;
import com.example.isscript.models.logbook;

import java.util.ArrayList;
import java.util.List;

public class listlogbook_adapter extends RecyclerView.Adapter<listlogbook_adapter.listlogbookVH>{

    private List<LogbooksItem> itemLogbooks = new ArrayList<>();

    public void setItemLogbooks(List<LogbooksItem> itemLogbooks) {
        this.itemLogbooks = itemLogbooks;
        notifyDataSetChanged();
    }

    ArrayList<logbook> listLoogbook = new ArrayList<>();

    public listlogbook_adapter() {
        this.listLoogbook = listLoogbook;
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
        LogbooksItem list = itemLogbooks.get(position);
        holder.imageView4.setImageResource(R.drawable.ic_dalamproses);
        holder.texttanggal.setText(logbook.getTanggal());
        holder.imageView8.setImageResource(R.drawable.ic_panahkanan);
    }

    @Override
    public int getItemCount() {
        return itemLogbooks.size();
        //return itemLogbooks.size();
    }

    public interface logbookClickListener{
        void onlogbookClick(logbook logbook);
    }

    public class listlogbookVH extends RecyclerView.ViewHolder{
        public TextView texttanggal;
        public ImageView imageView8, imageView4;

        public listlogbookVH(@NonNull View itemView) {
            super(itemView);
            imageView4 = itemView.findViewById(R.id.imageView4);
            texttanggal = itemView.findViewById(R.id.texttanggal) ;
            imageView8 = itemView.findViewById(R.id.imageView8);
        }
    }
    }

