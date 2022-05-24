/**
 * Sample Skeleton for 'InterfazParcial3.fxml' Controller Class
 */

package com.example.parcial_3ads;

// Importaciones generales.
import java.io.File;
import java.io.IOException;
import java.util.Objects;

// Importaciones específicas para JavaFX.
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;



public class ControladorInterfaz {

    public static String pathDelArchivo;

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

        if (archivoSeleccionado != null)
        {

            AbsolutePathNomina.setText(archivoSeleccionado.getAbsolutePath());

            rutaDelArchivo = AbsolutePathNomina.getText();


            ControladorArchivosNomina.leerNomina(Nomina.getEmpleados_ListaCompleta(), rutaDelArchivo);

            // Asignarle la ruta a la variable del path del archivo nomina
            ControladorInterfaz.pathDelArchivo = rutaDelArchivo;
/*
            // Imprimir la nómina.
            for ( Empleado emp : Nomina.getEmpleados_ListaCompleta() )
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
 */
        } else
        {
            System.out.println("Lo sentimos, no se ha podido abrir el archivo.") ;
        }


        // Ingresar los datos en el ComboBox de Materias
        ObservableList<String> listaDeMaterias = FXCollections.observableArrayList("Introduccion a la Programacion","Programacion Avanzada","Pensamiento Sistemico",
                                                                                        "Comunicaciones y Redes","Analisis y Diseño de Software","Bases de Datos","Introduccion a la Ingenieria"
                                                                                        ,"Seguridad de la Informacion","Gestion Financiera","CDIO","Arquitectura y Organizacion del Computador"
                                                                                        ,"Sistemas Operativos","Sistemas Distribuidos","Desarrollo Web","Estructuras de Datos","Teoria de la Computacion") ;

        comboAsignarMateria.setItems(listaDeMaterias) ;

        // Ingresar los datos en el ComboBox de Materias
        ObservableList<String> listaDeHoras = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20") ;
        comboAsignarHoras.setItems(listaDeHoras);
    }

    @FXML
    void inscribirMateria (ActionEvent event) throws IOException {
        // Variables de Recoleccion
        String tipoEmpleado = null;
        String seleccionMaterias = null;
        String seleccionHoras = null;
        String idEmpleado = null;

        // Variables de Verificación
        String verificarMateria;
        String verificarHoras;
        String verificarEmpleado;
        String verificarId;


        // Para obtener la materia seleccionada en el combobox de AsignarMateria
        seleccionMaterias = comboAsignarMateria.getSelectionModel().getSelectedItem();
        verificarMateria = seleccionMaterias;

        // Para obtener el numero de horas seleccionadas en el combobox de AsignarHoras
        seleccionHoras = comboAsignarHoras.getSelectionModel().getSelectedItem() ;
        verificarHoras = seleccionHoras;

        // Para obtener el tipo de empleado al cual se le va a incribir la materia
        tipoEmpleado = seleccionarTipoEmpleado(event);
        verificarEmpleado = tipoEmpleado;

        //Para obtener el ID del empleado:
        idEmpleado = textIDEmpleado.getText() ;
        verificarId = idEmpleado;

        // Metodos Comprobacion
        verificarMateria = capturarExcepcion(seleccionMaterias);
        verificarHoras  = capturarExcepcion(seleccionMaterias);
        verificarEmpleado = capturarExcepcion(seleccionMaterias);
        verificarId = capturarExcepcion(seleccionMaterias);

        if (!Objects.equals(verificarMateria, "error") && !Objects.equals(verificarHoras, "error") && !Objects.equals(verificarEmpleado, "error") && !Objects.equals(verificarId, "error"))
        {
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
            // Pasar toda la informacion al metodo de aniadirAsignatura_A_Empleado
            boolean idCorrecto = Nomina.aniadirAsignatura_A_Empleado(seleccionMaterias ,Double.parseDouble(seleccionHoras), tipoEmpleado ,idEmpleado);

            if (idCorrecto)
            {
                textoNotificaciones.setText("Se ha inscrito la materia exitosamente :D");
                ControladorArchivosNomina.modificarNomina(pathDelArchivo);
            }
            else
            {
                textoNotificaciones.setText("No se ha inscrito la materia exitosamente D:");
            }
        }
        else
        {
            textoNotificaciones.setText("Los datos se han ingresado de forma incorrecta, intentelo nuevamente.");
        }


        // Imprimir la nómina.
        for ( Empleado emp : Nomina.getEmpleados_ListaCompleta())
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

    @FXML
    String seleccionarTipoEmpleado (ActionEvent event) {

        String tipoEmpleado = null ;

        if (radioSeleccionProfesor.isSelected()) {

            tipoEmpleado = "Profesor" ;

        }

        else if (radioSeleccionMonitor.isSelected()) {

            tipoEmpleado = "Monitor" ;

        }
        return tipoEmpleado;
    }

    @FXML
    void calcularSalarioEmpleado(ActionEvent event)
    {
        String salarioEmpleado = null;
        String nombreEmpleado = null;
        String verificarNombreEmpleado = null;

        nombreEmpleado = textIDEmpleado.getText();

        // Metodos de Comprobacion
        verificarNombreEmpleado = capturarExcepcion(nombreEmpleado);

        if (verificarNombreEmpleado == null)
        {
            //salarioEmpleado = Nomina.calcularSalario_Empleado(verificarNombreEmpleado);
        }
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

    public String capturarExcepcion(Object probarObjeto)
    {
        try
        {
            return probarObjeto.toString();
        }
        catch (NullPointerException NullPointerException)
        {
            System.out.println("Los datos se han ingresado de forma incorrecta, intentelo nuevamente.");
            return "error";
        }
    }
}