<<<<<<< HEAD:src/main/java/com/example/parcial_3ads/ControladorInterfaz.java
/**
 * Sample Skeleton for 'InterfazParcial3.fxml' Controller Class
 */

package com.example.parcial_3ads;

=======

package parcial_03_withfx;


// Importaciones generales.
import java.io.File;

// Importaciones específicas para JavaFX.
>>>>>>> JoJo:resources/ControladorInterfaz.java
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

<<<<<<< HEAD:src/main/java/com/example/parcial_3ads/ControladorInterfaz.java
import java.io.File;
import java.lang.reflect.InvocationTargetException;

public class ControladorInterfaz
{

=======


public class ControladorInterfaz {
    
    
>>>>>>> JoJo:resources/ControladorInterfaz.java
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
<<<<<<< HEAD:src/main/java/com/example/parcial_3ads/ControladorInterfaz.java
    void tomarPathDeArchivo(ActionEvent event)
    {
=======
    void tomarPathDeArchivo(ActionEvent event) {
        
>>>>>>> JoJo:resources/ControladorInterfaz.java
        // Apertura del Archivo Nomina
        String rutaDelArchivo = null;

        FileChooser SeleccionadorArchivo = new FileChooser();
<<<<<<< HEAD:src/main/java/com/example/parcial_3ads/ControladorInterfaz.java
=======
        
>>>>>>> JoJo:resources/ControladorInterfaz.java
        SeleccionadorArchivo.setTitle("Tomar el path absoluto");

        File archivoSeleccionado = SeleccionadorArchivo.showOpenDialog(null);

        if (archivoSeleccionado != null) {
<<<<<<< HEAD:src/main/java/com/example/parcial_3ads/ControladorInterfaz.java
=======
            
>>>>>>> JoJo:resources/ControladorInterfaz.java
            AbsolutePathNomina.setText(archivoSeleccionado.getAbsolutePath());

            rutaDelArchivo = AbsolutePathNomina.getText();

<<<<<<< HEAD:src/main/java/com/example/parcial_3ads/ControladorInterfaz.java
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
=======
//            System.out.println(rutaDelArchivo);
            
            ControladorArchivosNomina.leerNomina(Nomina.getEmpleados_ListaCompleta(), rutaDelArchivo);

            // Imprimir la nómina.
//            for ( Empleado emp : nomina_01.getEmpleados_ListaCompleta() )
//            {
//                if ( emp instanceof Profesor )
//                {
//                    System.out.println(emp.toString() ) ;
//                    System.out.println(( (Profesor)emp ) . getListaAsignaturas() ) ;
//                }
//                else if ( emp instanceof Monitor )
//                {
//                    System.out.println(emp.toString() ) ;
//                    System.out.println(( (Monitor)emp ) . getListaAsignaturas() ) ;
//                }
//                else if ( emp instanceof Empleado )
//                {
//                    System.out.println( emp.toString() );
//                }
//            }
            
        } else {
            System.out.println("Lo sentimos, no se ha podido abrir el archivo.") ;
>>>>>>> JoJo:resources/ControladorInterfaz.java
        }


        // Ingresar los datos en el ComboBox de Materias
        ObservableList<String> listaDeMaterias = FXCollections.observableArrayList("Introduccion a la Programacion","Programacion Avanzada","Pensamiento Sistemico",
                                                                                    "Comunicaciones y Redes","Analisis y Diseño de Software","Bases de Datos","Introduccion a la Ingenieria"
                                                                                    ,"Seguridad de la Informacion","Gestion Financiera","CDIO","Arquitectura y Organizacion del Computador"
<<<<<<< HEAD:src/main/java/com/example/parcial_3ads/ControladorInterfaz.java
                                                                                    ,"Sistemas Operativos","Sistemas Distribuidos","Desarrollo Web","Estructuras de Datos","Teoria de la Computacion");
        comboAsignarMateria.setItems(listaDeMaterias);

        // Ingresar los datos en el ComboBox de Materias
        ObservableList<String> listaDeHoras = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20");
        comboAsignarHoras.setItems(listaDeHoras);
    }

    @FXML
    void inscribirMateria (ActionEvent event)
    {
=======
                                                                                    ,"Sistemas Operativos","Sistemas Distribuidos","Desarrollo Web","Estructuras de Datos","Teoria de la Computacion") ;
        
        comboAsignarMateria.setItems(listaDeMaterias) ;

        // Ingresar los datos en el ComboBox de Materias
        ObservableList<String> listaDeHoras = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20") ;
        comboAsignarHoras.setItems(listaDeHoras) ;
        
    }

    @FXML
    void inscribirMateria (ActionEvent event) {
        
>>>>>>> JoJo:resources/ControladorInterfaz.java
        String tipoEmpleado = null;
        String seleccionMaterias = null;
        String seleccionHoras = null;
        String idEmpleado = null;
<<<<<<< HEAD:src/main/java/com/example/parcial_3ads/ControladorInterfaz.java

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

        // Pasar toda la informacion al metodo de aniadirAsignatura_A_Empleado
        Nomina.aniadirAsignatura_A_Empleado(seleccionMaterias ,Double.parseDouble(seleccionHoras) ,idEmpleado);

        // Imprimir la Notificacion
        //textoNotificaciones.setText("Se ha añadido la materia de " + seleccionMaterias + " al  " + tipoEmpleado + " con ID " + idEmpleado + " dando " + seleccionHoras + " horas.");
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
=======
        
        // Para obtener la materia seleccionada en el combobox de AsignarMateria
        seleccionMaterias = comboAsignarMateria.getSelectionModel().getSelectedItem() ;

        // Para obtener el numero de horas seleccionadas en el combobox de AsignarHoras
        seleccionHoras = comboAsignarHoras.getSelectionModel().getSelectedItem() ;

        // Para obtener el tipo de empleado al cual se le va a incribir la materia
        tipoEmpleado = seleccionarTipoEmpleado(event) ;

        //Para obetener el ID del empleado:
        idEmpleado = textIDEmpleado.getText() ;

        // Impresion de todos los datos obtenidos:
        System.out.println("La materia seleccionada es: " + seleccionMaterias) ;
        System.out.println("La cantidad de horas que se van a inscribir es de: " + seleccionHoras) ;
        System.out.println("El tipo de empleado es: " + tipoEmpleado) ;
        System.out.println("El nombre del empleado es: " + idEmpleado) ;

        // Pasar toda la informacion al metodo de aniadirAsignatura_A_Empleado
        Nomina.aniadirAsignatura_A_Empleado(seleccionMaterias ,Double.parseDouble(seleccionHoras) ,idEmpleado);
        
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
>>>>>>> JoJo:resources/ControladorInterfaz.java
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

    public String capturarExcepcion(Object probarObjeto)
    {
        try
        {
            return probarObjeto.toString();
        }
        catch (NullPointerException NullPointerException)
        {
            textoNotificaciones.setText("Los datos se han ingresado de forma incorrecta, intentelo nuevamente.");
            return "Los datos se han ingresado de forma incorrecta, intentelo nuevamente.";
        }
    }
<<<<<<< HEAD:src/main/java/com/example/parcial_3ads/ControladorInterfaz.java
=======
    
    
>>>>>>> JoJo:resources/ControladorInterfaz.java
}
