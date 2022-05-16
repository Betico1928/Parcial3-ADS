/**
 * Sample Skeleton for 'Interfaz.fxml' Controller Class
 */

package com.example.parcial_3ads;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;

public class ControladorParcial {

    @FXML // fx:id="botonInscribirMateria"
    private Button botonInscribirMateria; // Value injected by FXMLLoader

    @FXML // fx:id="botonSeleccionNomina"
    private Button botonSeleccionNomina; // Value injected by FXMLLoader

    @FXML // fx:id="comboAsignarHoras"
    private ComboBox<?> comboAsignarHoras; // Value injected by FXMLLoader

    @FXML // fx:id="comboAsignarMateria"
    private ComboBox<?> comboAsignarMateria; // Value injected by FXMLLoader

    @FXML // fx:id="radioSeleccionMonitor"
    private RadioButton radioSeleccionMonitor; // Value injected by FXMLLoader

    @FXML // fx:id="radioSeleccionProfesor"
    private RadioButton radioSeleccionProfesor; // Value injected by FXMLLoader

    @FXML // fx:id="textoNotificaciones"
    private TextArea textoNotificaciones; // Value injected by FXMLLoader

    @FXML // fx:id="textoResultados"
    private TextArea textoResultados; // Value injected by FXMLLoader

    @FXML
    void tomarPathDeArchivo(ActionEvent event) {

    }

}
