package com.example.parcial_3ads;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControladorParcial
{
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick()
    {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}