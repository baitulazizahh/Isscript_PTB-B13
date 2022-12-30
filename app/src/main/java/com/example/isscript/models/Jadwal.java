package com.example.isscript.models;

public class Jadwal {

    String nama;
    String nim;
    String lencana;
    String tanggal;
    String jam;
    String lokasi;

    public Jadwal() {}

    public Jadwal(String nama, String nim, String lencana, String tanggal, String jam, String lokasi) {
        this.nama = nama;
        this.nim = nim;
        this.lencana = lencana;
        this.tanggal = tanggal;
        this.jam = jam;
        this.lokasi = lokasi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getLencana() {
        return lencana;
    }

    public void setLencana(String lencana) {
        this.lencana = lencana;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
}
