
package com.example.parcial_3ads;


import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;



public class ControladorArchivosNomina {
    
    
    /*
        ATRIBUTOS DE CLASE.
    */

    // Sin atributos de clase.
    
    
    /*
        ATRIBUTOS DE INSTANCIA.
    */

    // Sin atributos de instancia.
    
    
    /*
        CONSTRUCTORES.
    */

    // Constructor por defecto.
    
    
    /*
        MÉTODOS DE ENCAPSULAMIENTO PARA ATRIBUTOS DE CLASE.
    */

    // Sin métodos de encapsulamiento para atributos de clase.
    
    
    /*
        MÉTODOS DE ENCAPSULAMIENTO PARA ATRIBUTOS DE INSTANCIA.
    */

    // Sin métodos de encapsulamiento para atributos de instancia.
    
    
    /*
        MÉTODOS SOBREESCRITOS.
    */

    // Sin métodos sobreescritos.
    
    
    /*
        MÉTODOS DE CLASE.
    */

    public static final void leerNomina ( ArrayList <Empleado> listaEmpleados,String caminoTXT ) {

        try {

            File archivoTXT = new File (caminoTXT) ;

            Scanner lectorDeDatos = new Scanner (archivoTXT) ;

            while ( lectorDeDatos.hasNextLine() ) {

                String contenidoTXT = lectorDeDatos.nextLine() ;

                if (contenidoTXT.contains("FIN")){ break; }
                while ( !contenidoTXT.contains("#") ) {
                    contenidoTXT = (  contenidoTXT + "\n" + lectorDeDatos.nextLine()  ) ;
                }

//                System.out.println(contenidoTXT);

                contenidoTXT = contenidoTXT.replace("#", "") ;

//                System.out.println(contenidoTXT);

                cargarNomina(listaEmpleados,contenidoTXT) ;

            }

            lectorDeDatos.close();

        } catch ( FileNotFoundException excepcionSinArchivo ) {
            excepcionSinArchivo.printStackTrace();
        }


    }

    public static final void cargarNomina ( ArrayList <Empleado> listaEmpleados,String lineaTXT ) {

        String[] filasTXT = lineaTXT.split("\n");

        String[] infoGeneral = filasTXT[0].split("%") ;

        if ( infoGeneral[2].equals("Profesor") ) {

            Profesor nuevoProfesor = new Profesor ( infoGeneral[0],infoGeneral[1],infoGeneral[2] ) ;

            nuevoProfesor.setEscalafon(filasTXT[1]);

            if ( filasTXT[1].equals("Catedra") ) {
                nuevoProfesor.setNumeroSalarios(1);
            } else if ( filasTXT[1].equals("Instructor") ) {
                nuevoProfesor.setNumeroSalarios(2);
            } else if ( filasTXT[1].equals("Asistente") ) {
                nuevoProfesor.setNumeroSalarios(3);
            } else if ( filasTXT[1].equals("Asociado") ) {
                nuevoProfesor.setNumeroSalarios(4);
            } else if ( filasTXT[1].equals("Titular") ) {
                nuevoProfesor.setNumeroSalarios(5);
            }

            nuevoProfesor.setAsignaturas_ListaCompleta(cargarAsignaturas(filasTXT)) ;

            listaEmpleados.add(nuevoProfesor) ;

        } else if ( infoGeneral[2].equals("Monitor") ) {

            Monitor nuevoMonitor = new Monitor ( infoGeneral[0],infoGeneral[1],infoGeneral[2] ) ;

            nuevoMonitor.setNumeroSalarios(0);

            nuevoMonitor.setAsignaturas_ListaCompleta(cargarAsignaturas(filasTXT)) ;

            listaEmpleados.add(nuevoMonitor) ;

        } else if ( infoGeneral[2].equals("Empleado") ) {

            Empleado nuevoEmpleado = new Empleado ( infoGeneral[0],infoGeneral[1],infoGeneral[2] ) ;

            nuevoEmpleado.setNumeroSalarios(Integer.valueOf(filasTXT[1]));

            listaEmpleados.add(nuevoEmpleado) ;

        }

    }

    public static final ArrayList <Asignatura> cargarAsignaturas ( String[] lineas ) {

        ArrayList listaAsignaturas = new ArrayList <> () ;

        for ( int i=0 ; lineas.length>i ; ++i ) {

            if ( lineas[i].contains(",") ) {

                String[] listaAux = lineas[i].split(",");

                Asignatura nuevaAsignatura = new Asignatura (listaAux[0],Double.valueOf(listaAux[1])) ;

                listaAsignaturas.add(nuevaAsignatura) ;

            }

        }

        return listaAsignaturas ;
    }
    
    
    /*
        MÉTODOS DE INSTANCIA.
    */

    // Sin métodos de instancia.
}