
<<<<<<< HEAD:src/main/java/com/example/parcial_3ads/Nomina.java
package com.example.parcial_3ads;
=======
package parcial_03_withfx;
>>>>>>> JoJo:resources/Nomina.java


import java.util.ArrayList;



public class Nomina {


    /*
        ATRIBUTOS DE CLASE.
    */

    private static Integer cantidadTotalEmpleados = 0 ;


    /*
        ATRIBUTOS DE INSTANCIA.
    */
<<<<<<< HEAD:src/main/java/com/example/parcial_3ads/Nomina.java

    private static ArrayList <Empleado> empleados ;


    /*
        CONSTRUCTORES.
    */

    // Constructor para la asignación de memoria del atributo de instancia 'empleados'.
    Nomina ( ) {
        Nomina.empleados = new ArrayList <> () ;
    }


=======
    
    private static ArrayList <Empleado> empleados = new ArrayList <> () ;
    
    
    /*
        CONSTRUCTORES.
    */
    
    // Constructor por defecto.
    
    
>>>>>>> JoJo:resources/Nomina.java
    /*
        MÉTODOS DE ENCAPSULAMIENTO PARA ATRIBUTOS DE CLASE ...
    */

    // ... 'cantidadTotalEmpleados'.
    public static Integer getCantidadTotalEmpleados_Integer ( ) {
        return Nomina.cantidadTotalEmpleados ;
    }
    public static String getCantidadTotalEmpleados_String ( ) {
        return Integer.toString(Nomina.cantidadTotalEmpleados) ;
    }
    public static void setCantidadTotalEmpleados_AdicionarEmpleado ( boolean bandera ) {
        if ( bandera ) { ++Nomina.cantidadTotalEmpleados ; }
    }
    public static void setCantidadTotalEmpleados_EliminarEmpleado ( boolean bandera ) {
        if ( bandera ) { --Nomina.cantidadTotalEmpleados ; }
    }


    /*
        MÉTODOS DE ENCAPSULAMIENTO PARA ATRIBUTOS DE INSTANCIA ...
    */

    // ... 'empleados'.
    public String getListaEmpleados ( ) {

        String getListaEmpleados = new String ();

        for ( Empleado i : Nomina.empleados ) {
            getListaEmpleados += i.toString() ;
        }

        return getListaEmpleados ;
    }
    public static ArrayList <Empleado> getEmpleados_ListaCompleta ( ) {
        return Nomina.empleados ;
    }
    // El método 'set' de la lista 'empleados' le corresponde a otro conjunto de métodos.


    /*
        MÉTODOS SOBREESCRITOS.
    */

    // Sobrescritura del método 'ToString'.
    @Override
    public String toString ( ) {

        String getListaEmpleados = new String ();

        for ( Empleado i : Nomina.empleados ) {
            getListaEmpleados += i.toString();
        }

        return getListaEmpleados ;
    }


    /*
        MÉTODOS ADICIONALES.
    */

    // Métodos para añadir un empleado a la nómina.

    public static void aniadirEmpleado_ConObjetoEmpleado ( Empleado empleadoParaAniadir ) {

        boolean bandera = Nomina.empleados.add(empleadoParaAniadir) ;

        Nomina.mensajeValidador___AniadirEmpleado( bandera ) ;
        Nomina.setCantidadTotalEmpleados_AdicionarEmpleado( bandera ) ;

    }

    public static void aniadirEmpleado_ConCredenciales ( String nombre,String id,String cargo ) {

        if ( cargo.equals("Profesor") ) {

            boolean bandera = Nomina.empleados.add( new Profesor (nombre,id,cargo) ) ;
            Nomina.mensajeValidador___AniadirEmpleado( bandera ) ;
            Nomina.setCantidadTotalEmpleados_AdicionarEmpleado( bandera ) ;

        } else if ( cargo.equals("Monitor") ) {

            boolean bandera = Nomina.empleados.add( new Monitor (nombre,id,cargo) ) ;
            Nomina.mensajeValidador___AniadirEmpleado( bandera ) ;
            Nomina.setCantidadTotalEmpleados_AdicionarEmpleado( bandera ) ;

        } else if ( cargo.equals("Empleado") ) {

            boolean bandera = Nomina.empleados.add( new Empleado (nombre,id,cargo) ) ;
            Nomina.mensajeValidador___AniadirEmpleado( bandera ) ;
            Nomina.setCantidadTotalEmpleados_AdicionarEmpleado( bandera ) ;

        }


    }

    // Métodos para eliminar un empleado a la nómina.

    public static void eliminarEmpleado_ConObjetoEmpleado ( Empleado empleadoParaEliminar ) {

        boolean bandera = Nomina.empleados.remove(empleadoParaEliminar) ;

        Nomina.mensajeValidador___EliminarEmpleado( bandera ) ;
        Nomina.setCantidadTotalEmpleados_EliminarEmpleado( bandera );

        if ( empleadoParaEliminar instanceof Profesor ) {
            Profesor.setCantidadProfesores_EliminarProfesor(bandera);
        } else if ( empleadoParaEliminar instanceof Monitor ) {
            Monitor.setCantidadMonitores_EliminarMonitor(bandera);
        } else if ( empleadoParaEliminar instanceof Empleado ) {
            Empleado.setCantidadEmpleados_EliminarEmpleado(bandera);
        }

    }

    public static void eliminarEmpleado_ConID ( String id_E ) {

        int indiceBorrado = -1 ;

        for ( Empleado trabajador : Nomina.empleados ) {

            if ( trabajador.getId().equals(id_E) ) {
                Nomina.mensajeValidador___EncontrarEmpleado( trabajador.getId().equals(id_E),id_E );

                indiceBorrado = Nomina.empleados.indexOf(trabajador) ;
                break ;

            }

        }

        try {

            Empleado trabajadorEliminado = Nomina.empleados.remove(indiceBorrado) ;

            boolean bandera = ( !trabajadorEliminado.toString().isEmpty() || trabajadorEliminado.toString().length() != 0 ) ;

            if ( bandera ) {
                System.out.println ("Las credenciales del empleado recientemente eliminado son: " + trabajadorEliminado.toString()) ;
            }

            Nomina.mensajeValidador___EliminarEmpleado( bandera ) ;
            Nomina.setCantidadTotalEmpleados_EliminarEmpleado( bandera ) ;

            if ( trabajadorEliminado instanceof Profesor ) {
                Profesor.setCantidadProfesores_EliminarProfesor(bandera);
            } else if ( trabajadorEliminado instanceof Monitor ) {
                Monitor.setCantidadMonitores_EliminarMonitor(bandera);
            } else if ( trabajadorEliminado instanceof Empleado ) {
                Empleado.setCantidadEmpleados_EliminarEmpleado(bandera);
            }

        } catch ( Exception newException ) {

            System.out.println("Indice no encontrado.");

        }

    }

    // Métodos para calcular datos de la nómina.

    public static void aniadirAsignatura_A_Empleado ( String nombre_A,double horas_A,String id_E ) {

        for ( Empleado trabajador : Nomina.empleados ) {

            if ( id_E.equals(trabajador.getId()) ) {
                Nomina.mensajeValidador___EncontrarEmpleado(id_E.equals(trabajador.getId()),id_E) ;

                if ( trabajador instanceof Profesor ) {

                    Asignatura nuevaAsignatura = new Asignatura (nombre_A,horas_A) ;

                    boolean bandera = ( (Profesor)trabajador ).getAsignaturas_ListaCompleta().add(nuevaAsignatura) ;
                    Nomina.mensajeValidador___aniadirAsignatura_A_Empleado ( bandera , nuevaAsignatura ) ;

                    break;

                } else if ( trabajador instanceof Monitor ) {

                    Asignatura nuevaAsignatura = new Asignatura (nombre_A,horas_A) ;

                    boolean bandera = ( (Monitor)trabajador ).getAsignaturas_ListaCompleta().add(nuevaAsignatura) ;
                    Nomina.mensajeValidador___aniadirAsignatura_A_Empleado ( bandera , nuevaAsignatura ) ;

                    break;

                } else if ( trabajador instanceof Empleado ) {

                    System.out.println("El empleado solicitado no tiene asignaturas a su cargo. Por lo tanto, no es posible agregar la materia solicitada.");

                    break;

                }

            }

        }

    }

    public String calcularSalario_Empleado ( String id ) {

        double resultado = 0.0d ;

        for ( Empleado trabajador : Nomina.empleados ) {

            if ( trabajador.getId().equals(id) ) {
                Nomina.mensajeValidador___EncontrarEmpleado(id.equals(trabajador.getId()),id) ;

                if ( trabajador instanceof Profesor ) {

                    double primer_double = 0.88d ;
                    double segundo_double = Double.valueOf( ( (Profesor)trabajador ) . getNumeroSalarios_Integer() ) ;
                    double tercer_double = calcularHorasTotales_Empleado(id) ;

                    resultado = primer_double * segundo_double * tercer_double ;

                    break;

                } else if ( trabajador instanceof Monitor ) {

                    double primer_double = calcularHorasTotales_Empleado(id) ;
                    double segundo_double = ( (Monitor)trabajador ) . getValorHoraTrabajada_double() ;

                    resultado = primer_double * segundo_double ;

                    break;

                } else if ( trabajador instanceof Empleado ) {

                    double primer_double = 0.88d ;
                    double segundo_double = Double.valueOf(trabajador.getNumeroSalarios_Integer()) ;

                    resultado = primer_double * segundo_double ;

                    break;

                }

            }

        }

        return String.format("$%,.2f",resultado) ;
    }

    public double calcularHorasTotales_Empleado ( String id ) {

        double horas = 0.0d ;

        for ( Empleado trabajador : Nomina.empleados ) {

            if ( trabajador.getId().equals(id) ) {

                if ( trabajador instanceof Profesor ) {

                    for ( Asignatura materia : ( (Profesor)trabajador ) . getAsignaturas_ListaCompleta() ) {

                        horas += materia.getHoras_double() ;

                    }

                    break;

                } else if ( trabajador instanceof Monitor ) {

                    for ( Asignatura materia : ( (Monitor)trabajador ) . getAsignaturas_ListaCompleta() ) {

                        horas += materia.getHoras_double() ;

                    }

                    break;

                }

            }

        }

        return horas ;
    }

    // Mensajes validadores.

    public static void mensajeValidador___AniadirEmpleado ( boolean bandera ) {

        if ( bandera ) {
            System.out.println ("Empleado aniadido exitosamente.") ;
        } else {
            System.out.println ("No se ha aniadido el empleado solicitado.") ;
        }

    }

    public static void mensajeValidador___EliminarEmpleado ( boolean bandera ) {

        if ( bandera ) {
            System.out.println ("Empleado eliminado satisfactoriamente.");
        } else {
            System.out.println ("No se ha eliminado el empleado solicitado.");
        }

    }

    public static void mensajeValidador___EncontrarEmpleado ( boolean bandera , String id ) {

        if ( bandera ) {
            System.out.println ( "El empleado con el numero de identificacion " + id + " fue encontrado." ) ;
        } else {
            System.out.println ( "El empleado con el numero de identificacion " + id + " NO fue encontrado." ) ;
        }

    }

    public static void mensajeValidador___aniadirAsignatura_A_Empleado ( boolean bandera , Asignatura materia ) {

        if ( bandera ) {
            System.out.println("La materia," + materia.toString() + ", se ha aniadido exitosamente.");
        } else {
            System.out.println("La materia," + materia.toString() + ", NO se ha aniadido exitosamente.");
        }

    }


}