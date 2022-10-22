package com.example.isscript;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.isscript.adapters.JadwalAdapter;
import com.example.isscript.adapters.listlogbook_adapter;
import com.example.isscript.models.Jadwal;
import com.example.isscript.models.logbook;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_homescreen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_homescreen extends Fragment {



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView rvJadwal;
    ArrayList<Jadwal> listJadwal;
    private RecyclerView rvlogbook;
    ArrayList<logbook> listLogbook;

    public Fragment_homescreen() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_homescreen.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_homescreen newInstance(String param1, String param2) {
        Fragment_homescreen fragment = new Fragment_homescreen();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment

//        View view = inflater.inflate(R.layout.fragment_homescreen, container, false);
//        rvJadwal = rvJadwal.findViewById(R.id.rv_jadwal);
//        rvlogbook = rvlogbook.findViewById(R.id.rv_logbook);
//
//        listJadwal =new ArrayList<>();
//        listJadwal.add(new Jadwal(
//                "Salma",
//                "2011522002",
//                null,
//                1,
//                "Rabu, 1 Januari 2023",
//                "10.00 - 12.00 WIB",
//                "Ruang sidang SI"
//        ));
//        listJadwal.add(new Jadwal(
//                "Tuti Astuti",
//                "2011522003",
//                null,
//                1,
//                "Kamis, 2 Januari 2023",
//                "10.00 - 12.00 WIB",
//                "Ruang sidang SI"
//        ));
//        listJadwal.add(new Jadwal(
//                "Cici Melia",
//                "2011522004",
//                null,
//                1,
//                "Jumat, 3 Januari 2023",
//                "10.00 - 12.00 WIB",
//                "Ruang sidang SI"
//        ));
//        listJadwal.add(new Jadwal(
//                "Salma",
//                "2011522002",
//                null,
//                1,
//                "Rabu, 1 Januari 2023",
//                "10.00 - 12.00 WIB",
//                "Ruang sidang SI"
//        ));
//        listJadwal.add(new Jadwal(
//                "Tuti Astuti",
//                "2011522003",
//                null,
//                1,
//                "Kamis, 2 Januari 2023",
//                "10.00 - 12.00 WIB",
//                "Ruang sidang SI"
//        ));
//        listJadwal.add(new Jadwal(
//                "Cici Melia",
//                "2011522004",
//                null,
//                1,
//                "Jumat, 3 Januari 2023",
//                "10.00 - 12.00 WIB",
//                "Ruang sidang SI"
//        ));
//
//        listLogbook =new ArrayList<>();
//        listLogbook.add(new logbook(
//                "Selesai",
//                "1 Maret 2022",
//                null
//        ));
//        listLogbook.add(new logbook(
//                "Selesai",
//                "2 Maret 2022",
//                null
//        ));
//        listLogbook.add(new logbook(
//                "Selesai",
//                "3 Maret 2022",
//                null
//        ));
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
//        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this.getContext());
//        rvJadwal.setLayoutManager(layoutManager);
//        rvlogbook.setLayoutManager(layoutManager2);
//
//        rvJadwal.setAdapter(new JadwalAdapter(listJadwal));
//        rvlogbook.setAdapter(new listlogbook_adapter(listLogbook));
        return inflater.inflate(R.layout.fragment_homescreen, container, false);


    }




}