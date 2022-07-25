package com.example.databaseconnection_kelas.dao;

import javafx.collections.ObservableList;

public interface DaoInterface <T> {
    ObservableList<T> getData();
    void addData(T data);
    boolean delData(T data);
}
