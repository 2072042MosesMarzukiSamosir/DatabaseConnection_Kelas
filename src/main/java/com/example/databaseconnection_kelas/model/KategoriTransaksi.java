package com.example.databaseconnection_kelas.model;

public class KategoriTransaksi {
    private int id;
    private String namaTransaksi;

    @Override
    public String toString() {
        return namaTransaksi;
    }

    public KategoriTransaksi(int id, String namaTransaksi) {
        this.id = id;
        this.namaTransaksi = namaTransaksi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaTransaksi() {
        return namaTransaksi;
    }

    public void setNamaTransaksi(String namaTransaksi) {
        this.namaTransaksi = namaTransaksi;
    }
}
