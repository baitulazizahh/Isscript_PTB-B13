package com.example.isscript.models;

public class Jadwal {

    String Nama;
    String nim;
    String jenisAcara;
    String tanggal;
    String jam;
    String lokasi;

    public Jadwal(){ }

    public Jadwal(String Nama, String nim, String jenisAcara, String tanggal, String jam, String lokasi) {
        this.Nama = Nama;
        this.nim = nim;
        this.jenisAcara = jenisAcara;
        this.tanggal = tanggal;
        this.jam = jam;
        this.lokasi = lokasi;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        this.Nama = Nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getJenisAcara() {
        return jenisAcara;
    }

    public void setJenisAcara(String jenisAcara) {
        this.jenisAcara = jenisAcara;
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
