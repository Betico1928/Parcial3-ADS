package com.example.parcial_3ads;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AplicacionParcial extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(AplicacionParcial.class.getResource("Interfaz.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Parcial 3 (Te amo Angela!)");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}