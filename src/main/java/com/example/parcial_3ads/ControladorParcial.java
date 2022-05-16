/**
 * Sample Skeleton for 'Interfaz.fxml' Controller Class
 */

package com.example.parcial_3ads;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.skin.ComboBoxListViewSkin;
import javafx.stage.FileChooser;

import java.io.File;

public class ControladorParcial
{

    @FXML // fx:id="botonInscribirMateria"
    private Button botonInscribirMateria; // Value injected by FXMLLoader

    @FXML // fx:id="botonSeleccionNomina"
    private Button botonSeleccionNomina; // Value injected by FXMLLoader

    @FXML // fx:id="comboAsignarHoras"
    private ComboBox<String> comboAsignarHoras; // Value injected by FXMLLoader

    @FXML // fx:id="comboAsignarMateria"
    private ComboBox<String> comboAsignarMateria; // Value injected by FXMLLoader

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

        // Ingresar los datos en el ComboBox de Materias
        ObservableList<String> listaDeMaterias = FXCollections.observableArrayList("Programacion Avanzada", "Comunicaciones y Redes", "Analisis y Diseño de Software", "Bases de Datos");
        comboAsignarMateria.setItems(listaDeMaterias);

        // Ingresar los datos en el ComboBox de Materias
        ObservableList<String> listaDeHoras = FXCollections.observableArrayList("1", "2", "3", "4");
        comboAsignarHoras.setItems(listaDeHoras);
    }

    @FXML
    void inscribirMateria (ActionEvent event)
    {
        System.out.println("buenas tardes");

        seleccionarTipoEmpleado(event);
    }

    @FXML
    void seleccionarTipoEmpleado (ActionEvent event)
    {
        System.out.println("hola jajajaja");
    }
}
