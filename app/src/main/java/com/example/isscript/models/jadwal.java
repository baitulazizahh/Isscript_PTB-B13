package com.example.isscript.models;

public class jadwal {

    String nama;
    Integer nim;
    Integer jenis;
    String tanggal;
    String jam;
    String lokasi;

    public jadwal(){ }

    public jadwal(String nama, Integer nim, Integer jenis, String tanggal, String jam, String lokasi) {
        this.nama = nama;
        this.nim = nim;
        this.jenis = jenis;
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

    public Integer getNim() {
        return nim;
    }

    public void setNim(Integer nim) {
        this.nim = nim;
    }

    public Integer getJenis() {
        return jenis;
    }

    public void setJenis(Integer jenis) {
        this.jenis = jenis;
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
