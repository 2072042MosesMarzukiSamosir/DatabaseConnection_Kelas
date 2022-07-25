package com.example.databaseconnection_kelas.model;

public class Transaksi {
    private int idTran;
    private String namaTran;
    private double jumlah;
    private KategoriTransaksi kategoriTransaksi;

    @Override
    public String toString() {
        return idTran + namaTran + jumlah + kategoriTransaksi.getNamaTransaksi();
    }

    public Transaksi(int idTran, String namaTran, double jumlah, KategoriTransaksi kategoriTransaksi) {
        this.idTran = idTran;
        this.namaTran = namaTran;
        this.jumlah = jumlah;
        this.kategoriTransaksi = kategoriTransaksi;
    }

    public int getIdTran() {
        return idTran;
    }

    public void setIdTran(int idTran) {
        this.idTran = idTran;
    }

    public String getNamaTran() {
        return namaTran;
    }

    public void setNamaTran(String namaTran) {
        this.namaTran = namaTran;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public KategoriTransaksi getKategoriTransaksi() {
        return kategoriTransaksi;
    }

    public void setKategoriTransaksi(KategoriTransaksi kategoriTransaksi) {
        this.kategoriTransaksi = kategoriTransaksi;
    }

}
