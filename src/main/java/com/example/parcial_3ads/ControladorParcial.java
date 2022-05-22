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
        // Apertura del Archivo Nomina
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
        ObservableList<String> listaDeHoras = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7");
        comboAsignarHoras.setItems(listaDeHoras);
    }

    @FXML
    void inscribirMateria (ActionEvent event)
    {
        String tipoEmpleado = null;

        // Para obtener la materia seleccionada en el combobox de AsignarMateria
        String seleccionMaterias = comboAsignarMateria.getSelectionModel().getSelectedItem().toString();

        // Para obtener el numero de horas seleccionadas en el combobox de AsignarHoras
        String seleccionHoras = comboAsignarHoras.getSelectionModel().getSelectedItem().toString();

        // Para obtener el tipo de empleado al cual se le va a incribir la materia
        tipoEmpleado = seleccionarTipoEmpleado(event);

        // Impresion de todos los datos obtenidos:
        System.out.println("La materia seleccionada es: " + seleccionMaterias + "\n");
        System.out.println("La cantidad de horas que se van a inscribir es de: " + seleccionHoras+ "\n");
        System.out.println("El tipo de empleado es: " + tipoEmpleado+ "\n");
    }

    @FXML
    String seleccionarTipoEmpleado (ActionEvent event)
    {
        String tipoEmpleado = null;

        if (radioSeleccionProfesor.isSelected())
        {
            tipoEmpleado = "Profesor";
        }

        else if (radioSeleccionMonitor.isSelected())
        {
            tipoEmpleado = "Monitor";
        }
        return tipoEmpleado;
    }


}
