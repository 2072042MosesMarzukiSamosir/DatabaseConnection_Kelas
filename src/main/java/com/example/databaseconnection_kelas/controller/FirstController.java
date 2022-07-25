package com.example.databaseconnection_kelas.controller;

import com.example.databaseconnection_kelas.dao.KategoriTransaksiDao;
import com.example.databaseconnection_kelas.dao.TransaksiDao;
import com.example.databaseconnection_kelas.model.KategoriTransaksi;
import com.example.databaseconnection_kelas.model.Transaksi;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Optional;

public class FirstController {
    public TableColumn<Transaksi, String> colId;
    public TableColumn colNama;
    public TableColumn<Transaksi, String> colJumlah;
    public TableColumn colKategori;
    public TableView tbView;
    public TextField txtNama;
    public TextField txtJumlah;
    public ComboBox cboxKat;
    public Button btnAdd;
    public ObservableList<KategoriTransaksi> KatList;
    public ObservableList<Transaksi> TransList;
    public SimpleStringProperty data;

    public void initialize() {
        KategoriTransaksiDao KatDao = new KategoriTransaksiDao();
        KatList = KatDao.getData();
        cboxKat.setItems(KatList);
        cboxKat.getSelectionModel();
        TransaksiDao TransDao = new TransaksiDao();
        TransList = TransDao.getData();
        tbView.setItems(TransList);
        colId.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getIdTran())));
        colNama.setCellValueFactory(new PropertyValueFactory<>("namaTran"));
        Locale us = new Locale("id", "ID");
        Currency dollars = Currency.getInstance(us);
        NumberFormat dollarformat = NumberFormat.getCurrencyInstance(us);
        colJumlah.setCellValueFactory(data -> new SimpleStringProperty(dollarformat.format(data.getValue().getJumlah())));
        colKategori.setCellValueFactory(new PropertyValueFactory<>("kategoriTransaksi"));
    }

    public void onAddData(ActionEvent event) {
        TransaksiDao transDao = new TransaksiDao();
        TransList = transDao.getData();
        transDao.addData(new Transaksi(TransList.size() + 1, txtNama.getText(), Double.valueOf(txtJumlah.getText()), (KategoriTransaksi) this.cboxKat.getValue()));
        TransList = transDao.getData();
        tbView.setItems(TransList);
    }

    public void onOptionDel(ActionEvent event) {
        Transaksi selDel = (Transaksi) tbView.getSelectionModel().getSelectedItem();
        if (selDel == null){
            Alert alert = new Alert(Alert.AlertType.ERROR,"please select data", ButtonType.OK);
            alert.showAndWait();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"are you sure to delete this data ?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK){
            TransaksiDao dao = new TransaksiDao();
            dao.delData(selDel);
            TransList = dao.getData();
            tbView.setItems(TransList);
        }else {
            Alert cancelled = new Alert(Alert.AlertType.INFORMATION,"deleting cancelled");
            cancelled.showAndWait();
        }
    }


}