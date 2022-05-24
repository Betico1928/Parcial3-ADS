
package com.example.parcial_3ads;


import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;



public class ControladorArchivosNomina
{
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

    public static final void modificarNomina(String pathDelArchivo) throws IOException
    {
        Writer modificadorDeArchivo = new FileWriter(pathDelArchivo, false);
        String contenidoNomina = new String();

        for (Empleado empleadoAniadido : Nomina.getEmpleados_ListaCompleta())
        {
            if (empleadoAniadido instanceof Profesor)
            {
                contenidoNomina += empleadoAniadido.getNombre() + '%' + empleadoAniadido.getId() + '%' + empleadoAniadido.getCargo() + '\n' + ((Profesor) empleadoAniadido).getEscalafon() + '\n';

                for (Asignatura asignaturaAniadida : ((Profesor) empleadoAniadido).getAsignaturas_ListaCompleta())
                {
                    contenidoNomina += asignaturaAniadida.getNombre() + ',' + asignaturaAniadida.getHoras_String() + '\n';
                }
                contenidoNomina += "#\n";
            }

            else if (empleadoAniadido instanceof Monitor)
            {
                contenidoNomina += empleadoAniadido.getNombre() + '%' + empleadoAniadido.getId() + '%' + empleadoAniadido.getCargo() + '\n';

                for (Asignatura asignaturaAniadida : ((Monitor) empleadoAniadido).getAsignaturas_ListaCompleta())
                {
                    contenidoNomina += asignaturaAniadida.getNombre() + ',' + asignaturaAniadida.getHoras_String() + '\n';
                }
                contenidoNomina += "#\n";
            }

            else if (empleadoAniadido instanceof Empleado)
            {
                contenidoNomina += empleadoAniadido.getNombre() + '%' + empleadoAniadido.getId() + '%' + empleadoAniadido.getCargo() + '\n' + empleadoAniadido.getNumeroSalarios_String() + "\n#\n";
            }
        }
        contenidoNomina += "FIN";
        modificadorDeArchivo.write(contenidoNomina);
        modificadorDeArchivo.flush();
        modificadorDeArchivo.close();
    }

    public static String presentarReporte (String pathDelArchivo) throws IOException
    {
        String mensajeVerificacion = "";
        File archivo = new File(pathDelArchivo);

        if(archivo.exists())
        {
            escribirReporte(pathDelArchivo);
            mensajeVerificacion = "El archivo existe...";
        }
        else if (archivo.createNewFile())
        {
            escribirReporte(pathDelArchivo);
            mensajeVerificacion = "El archivo fue creado";
        }
        else
        {
            escribirReporte(pathDelArchivo);
            mensajeVerificacion = "No se ha encontrado el archivo para generar un reporte D:";
        }
        return mensajeVerificacion;
    }

    public static String escribirReporte(String pathDelArchivo) throws IOException
    {
        Writer modificadorDeArchivo = new FileWriter(pathDelArchivo, false);
        String contenidoReporte = new String();

        for (Empleado empleadoAniadido : Nomina.getEmpleados_ListaCompleta())
        {
            if (empleadoAniadido instanceof Profesor)
            {
                contenidoReporte += empleadoAniadido.getNombre() + " , " + empleadoAniadido.getId() + " , \\" + Nomina.calcularSalario_Empleado(empleadoAniadido.getNombre(), empleadoAniadido.getCargo()) + '\n';
            }
            else if (empleadoAniadido instanceof Monitor)
            {
                contenidoReporte += empleadoAniadido.getNombre() + " , " + empleadoAniadido.getId() + " , \\" + Nomina.calcularSalario_Empleado(empleadoAniadido.getNombre(), empleadoAniadido.getCargo()) + '\n';
            }

            else if (empleadoAniadido instanceof Empleado)
            {
                contenidoReporte += empleadoAniadido.getNombre() + " , " + empleadoAniadido.getId() + " , \\" + Nomina.calcularSalario_Empleado(empleadoAniadido.getNombre(), empleadoAniadido.getCargo()) + '\n';
            }
        }
        modificadorDeArchivo.write(contenidoReporte);
        modificadorDeArchivo.flush();
        modificadorDeArchivo.close();
        return contenidoReporte;
    }

    /*
        MÉTODOS DE INSTANCIA.
    */

    // Sin métodos de instancia.
}