package com.example.databaseconnection_kelas.dao;

import com.example.databaseconnection_kelas.model.KategoriTransaksi;
import com.example.databaseconnection_kelas.util.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KategoriTransaksiDao implements DaoInterface<KategoriTransaksi> {

    @Override
    public ObservableList<KategoriTransaksi> getData() {
        ObservableList<KategoriTransaksi>KatTranList;
        KatTranList = FXCollections.observableArrayList();

        Connection conn = MyConnection.getConnection();
        String query = "select * from kategoritransaksi";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            while(result.next()){
                int id = result.getInt("idKategoriTransaksi");
                String namaKategori = result.getString("NamaKategoriTransaksicol");
                KategoriTransaksi kat = new KategoriTransaksi(id,namaKategori);
                KatTranList.add(kat);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return KatTranList;
    }

    @Override
    public void addData(KategoriTransaksi data) {

    }

    @Override
    public boolean delData(KategoriTransaksi data) {

        return false;
    }
}
