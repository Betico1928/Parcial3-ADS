/**
 * Sample Skeleton for 'Interfaz.fxml' Controller Class
 */

package com.example.parcial_3ads;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

public class ControladorInterfaz
{

    @FXML // fx:id="botonInscribirMateria"
    private Button botonInscribirMateria; // Value injected by FXMLLoader

    @FXML // fx:id="botonSeleccionNomina"
    private Button botonSeleccionNomina; // Value injected by FXMLLoader

    @FXML // fx:id="botonGenerarNomina"
    private Button botonGenerarNomina; // Value injected by FXMLLoader

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
    private TextField textIDEmpleado;

    @FXML
    void tomarPathDeArchivo(ActionEvent event)
    {
        // Apertura del Archivo Nomina
        String rutaDelArchivo = null;

        FileChooser SeleccionadorArchivo = new FileChooser();
        SeleccionadorArchivo.setTitle("Tomar el path absoluto");

        File archivoSeleccionado = SeleccionadorArchivo.showOpenDialog(null);

        if (archivoSeleccionado != null) {
            AbsolutePathNomina.setText(archivoSeleccionado.getAbsolutePath());

            rutaDelArchivo = AbsolutePathNomina.getText();

            System.out.println(rutaDelArchivo);

            Nomina nomina_01 = new Nomina();
            ControladorArchivosNomina.leerNomina(nomina_01.getEmpleados_ListaCompleta(), rutaDelArchivo);

            // Imprimir el archivo
            for ( Empleado emp : nomina_01.getEmpleados_ListaCompleta() )
            {
                if ( emp instanceof Profesor )
                {
                    System.out.println(emp.toString() ) ;
                    System.out.println(( (Profesor)emp ) . getListaAsignaturas() ) ;
                }
                else if ( emp instanceof Monitor )
                {
                    System.out.println(emp.toString() ) ;
                    System.out.println(( (Monitor)emp ) . getListaAsignaturas() ) ;
                }
                else if ( emp instanceof Empleado )
                {
                    System.out.println( emp.toString() );
                }
            }
        }
        else
        {
            System.out.println("Lo sentimos, no se ha podido abrir el archivo D:");
        }


        // Ingresar los datos en el ComboBox de Materias
        ObservableList<String> listaDeMaterias = FXCollections.observableArrayList("Introduccion a la Programacion","Programacion Avanzada","Pensamiento Sistemico",
                                                                                    "Comunicaciones y Redes","Analisis y Diseño de Software","Bases de Datos","Introduccion a la Ingenieria"
                                                                                    ,"Seguridad de la Informacion","Gestion Financiera","CDIO","Arquitectura y Organizacion del Computador"
                                                                                    ,"Sistemas Operativos","Sistemas Distribuidos","Desarrollo Web","Estructuras de Datos","Teoria de la Computacion");
        comboAsignarMateria.setItems(listaDeMaterias);

        // Ingresar los datos en el ComboBox de Materias
        ObservableList<String> listaDeHoras = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20");
        comboAsignarHoras.setItems(listaDeHoras);
    }

    @FXML
    void inscribirMateria (ActionEvent event)
    {
        String tipoEmpleado = null;
        String seleccionMaterias = null;
        String seleccionHoras = null;
        String idEmpleado = null;

        // Para obtener la materia seleccionada en el combobox de AsignarMateria
        seleccionMaterias = comboAsignarMateria.getSelectionModel().getSelectedItem().toString();

        // Para obtener el numero de horas seleccionadas en el combobox de AsignarHoras
        seleccionHoras = comboAsignarHoras.getSelectionModel().getSelectedItem().toString();

        // Para obtener el tipo de empleado al cual se le va a incribir la materia
        tipoEmpleado = seleccionarTipoEmpleado(event);

        // Para obetener el ID del empleado:
        idEmpleado = textIDEmpleado.getText();

        // Impresion de todos los datos obtenidos:
        System.out.println("La materia seleccionada es: " + seleccionMaterias);
        System.out.println("La cantidad de horas que se van a inscribir es de: " + seleccionHoras);
        System.out.println("El tipo de empleado es: " + tipoEmpleado);
        System.out.println("El ID del empleado es: " + idEmpleado);

        // Convertir las horas a Double
        double seleccionHorasDouble = Double.parseDouble(seleccionHoras);

        // Pasar toda la informacion al metodo de aniadirAsignatura_A_Empleado
        Nomina.aniadirAsignatura_A_Empleado(seleccionMaterias ,seleccionHorasDouble ,idEmpleado);

        // Imprimir la Notificacion
        textoNotificaciones.setText("Se ha añadido la materia de " + seleccionMaterias + " al  " + tipoEmpleado + " con ID " + idEmpleado + " dando " + seleccionHoras + " horas.");
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

    @FXML
    void calcularSalarioEmpleado(ActionEvent event)
    {

    }

    @FXML
    void calcularSalarioMonitor(ActionEvent event)
    {

    }

    @FXML
    void calcularSalarioProfesor(ActionEvent event)
    {

    }

    @FXML
    void generarNomina(ActionEvent event)
    {

    }
}
