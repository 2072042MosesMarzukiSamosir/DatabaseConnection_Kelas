module com.example.databaseconnection_kelas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.databaseconnection_kelas to javafx.fxml;
    exports com.example.databaseconnection_kelas;
    exports com.example.databaseconnection_kelas.controller;
    opens com.example.databaseconnection_kelas.controller to javafx.fxml;
    exports com.example.databaseconnection_kelas.model;
    opens com.example.databaseconnection_kelas.model to javafx.fxml;
}