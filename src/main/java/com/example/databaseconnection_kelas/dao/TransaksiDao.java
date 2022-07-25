package com.example.databaseconnection_kelas.dao;

import com.example.databaseconnection_kelas.model.KategoriTransaksi;
import com.example.databaseconnection_kelas.model.Transaksi;
import com.example.databaseconnection_kelas.util.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransaksiDao implements DaoInterface<Transaksi>{
    @Override
    public ObservableList<Transaksi> getData() {
        ObservableList<Transaksi>TransList;
        TransList = FXCollections.observableArrayList();

        Connection conn = MyConnection.getConnection();
        String query = "select k.idKategoriTransaksi, k.NamaKategoriTransaksicol, t.idTransaksi, t.NamaTransaksi, t.Jumlah, t.KategoriTransaksi_idKategoriTransaksi from transaksi t join kategoritransaksi k on t.KategoriTransaksi_idKategoriTransaksi = k.idKategoriTransaksi ";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            while (result.next()){
                int id = result.getInt("idTransaksi");
                String namaTran = result.getString("NamaTransaksi");
                int jumlah = result.getInt("Jumlah");
                int idKat = result.getInt("idKategoriTransaksi");
                String namaKat = result.getString("NamaKategoriTransaksicol");
                KategoriTransaksi kategoriTransaksi = new KategoriTransaksi(idKat,namaKat);
                Transaksi tran = new Transaksi(id,namaTran,jumlah,kategoriTransaksi);
                TransList.add(tran);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return TransList;
    }

    @Override
    public void addData(Transaksi data) {
        Connection conn = MyConnection.getConnection();
        String query = "insert into transaksi(idTransaksi,NamaTransaksi,jumlah,KategoriTransaksi_idKategoriTransaksi) values(?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1,data.getIdTran());
            ps.setString(2,data.getNamaTran());
            ps.setDouble(3,data.getJumlah());
            ps.setDouble(4,data.getKategoriTransaksi().getId());;
            int result = ps.executeUpdate();
            if (result > 0){
                System.out.println("berhasil masukkin data");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delData(Transaksi data) {
        Connection conn = MyConnection.getConnection();
        String query = "DELETE FROM transaksi Where idTransaksi = ?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1,data.getIdTran());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
