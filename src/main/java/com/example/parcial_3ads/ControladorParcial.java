/**
 * Sample Skeleton for 'Interfaz.fxml' Controller Class
 */

package com.example.parcial_3ads;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;

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
    private Label AbsolutePathNomina;

    @FXML
    void tomarPathDeArchivo(ActionEvent event)
    {
        String rutaDelArchivo;

        FileChooser SeleccionadorArchivo = new FileChooser();
        SeleccionadorArchivo.setTitle("Tomar el path absoluto");

        File archivoSeleccionado = SeleccionadorArchivo.showOpenDialog(null);

        if (archivoSeleccionado != null) {
            AbsolutePathNomina.setText(archivoSeleccionado.getAbsolutePath());

            rutaDelArchivo = AbsolutePathNomina.getText();

            System.out.println(rutaDelArchivo);
        }
        else
        {
            System.out.println("Lo sentimos, no se ha podido abrir el archivo D:");
        }
    }

}
