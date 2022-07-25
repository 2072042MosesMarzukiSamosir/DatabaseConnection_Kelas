package com.example.databaseconnection_kelas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DatabaseConnectionApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DatabaseConnectionApp.class.getResource("first-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("DatabaseConnectivity_2072042MosesMarzukiSamosir");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}