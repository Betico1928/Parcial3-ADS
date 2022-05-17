
package com.mycompany.parcial_3;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class Nomina {
    
    
    /*
        ATRIBUTOS.
    */

    // Sin atributos de clase.
    
    // Atributos de instancia.
    private ArrayList <Empleado> empleados ;
    
    
    /*
        CONSTRUCTORES.
    */
    
    // Constructor para la asignación de memoria del atributo de instancia 'empleados'.
    Nomina ( ) {
        this.empleados = new ArrayList <> () ;
    }
    
    
    /*
        MÉTODOS DE ENCAPSULAMIENTO ...
    */
    
    public String getListaEmpleados ( ) {
        
        String getListaEmpleados = new String ();
        
        for ( Empleado i : this.empleados ) {
            getListaEmpleados += i.toString() ;
        }
        
    return getListaEmpleados ;
    }
    public String getEmpleadoDeLista ( int indice ) {
        return this.empleados.get(indice).toString();
    }
    public ArrayList <Empleado> getEmpleados_ListaCompleta ( ) {
        return this.empleados ;
    }
    // El método 'set' de la lista 'empleados' le corresponde a otro conjunto de métodos.
    
    
    /*
        MÉTODOS SOBREESCRITOS.
    */
    
    // Sobrescritura del método 'ToString'.
    @Override
    public String toString ( ) {
        
        String getListaEmpleados = new String ();
        
        for ( Empleado i : this.empleados ) {
            getListaEmpleados += i.toString();
        }
        
    return getListaEmpleados ;
    }
    
    
    /*
        MÉTODOS DE CLASE.
    */
    
    public void aniadirEmpleado_SinCredenciales ( Empleado empleadoParaAniadir ) {
        
        validarAniadirEmpleado( this.empleados.add(empleadoParaAniadir) ) ;
        
    }
    
    public void aniadirEmpleado_ConTodasSusCredenciales ( String nombre,String id,String dependencia,String cargo,Integer numeroSalarios,double valorHoraTrabajada,int escalafon ) {
        
        /* ¿preguntar credenciales por consola? */
        
        Empleado empleadoParaAniadir = new Empleado (nombre,id,dependencia,cargo,numeroSalarios,valorHoraTrabajada,escalafon) ;
        
        validarAniadirEmpleado( this.empleados.add(empleadoParaAniadir) ) ;
        
    }
    
    public void aniadirEmpleado_ConAlgunasCredenciales ( String nombre,String id,String cargo ) {
        
        /* ¿preguntar credenciales por consola? */
        
        Empleado empleadoParaAniadir = new Empleado (nombre,id,cargo) ;
        
        validarAniadirEmpleado( this.empleados.add(empleadoParaAniadir) ) ;
        
    }
    
    public void aniadirEmpleado_ConAlgunasCredenciales ( String nombre,String id,String dependencia,String cargo ) {
        
        /* ¿preguntar credenciales por consola? */
        
        Empleado empleadoParaAniadir = new Empleado (nombre,id,dependencia,cargo) ;
        
        validarAniadirEmpleado( this.empleados.add(empleadoParaAniadir) ) ;
        
    }
    
    
    public void validarAniadirEmpleado ( boolean bandera ) {
        
        if ( bandera ) {
            System.out.println ("Empleado aniadido exitosamente.") ;
        } else {
            System.out.println ("No se aniade el empleado solicitado.") ;
        }
        
    }
    
    
    public void eliminarEmpleado_SinIndice ( Empleado empleadoParaEliminar ) {
        
        validarEliminarEmpleado( this.empleados.remove(empleadoParaEliminar) ) ;
        
    }
    
    public void eliminarEmpleado_ConIndice ( int indice ) {
        
        Empleado empleadoEliminado = this.empleados.remove(indice);
        
        validarEliminarEmpleado( !empleadoEliminado.toString().isEmpty() || !empleadoEliminado.toString().equals(null) ) ;
        
        if ( !empleadoEliminado.toString().isEmpty() || !empleadoEliminado.toString().equals(null) ) {
            System.out.println ("Las credenciales del empleado eliminado son: " + empleadoEliminado.toString()) ;
        }
        
    }
    
    
    public void validarEliminarEmpleado ( boolean bandera ) {
        
        if ( bandera ) {
            System.out.println ("Empleado eliminado satisfactoriamente.");
        } else {
            System.out.println ("No se ha eliminado el empleado solicitado.");
        }
        
        System.out.println ("La cantidad de empleados antes de la operación era de :" + Empleado.getCantidadEmpleados_String());
        Empleado.setCantidadEmpleados_EliminarEmpleado();
        System.out.println ("Ahora la cantidad de empleados es de: " + Empleado.getCantidadEmpleados_String());
        
    }
    
    
    public final void leerNomina ( String caminoTXT ) {
        
        try {
            
            File archivoTXT = new File (caminoTXT) ;
            
            Scanner lectorDeDatos = new Scanner (archivoTXT) ;
            
            while (lectorDeDatos.hasNextLine()) {
                String contenidoTXT = lectorDeDatos.nextLine() ;
                if (contenidoTXT.equalsIgnoreCase("FIN")){ break; }
//                System.out.println(contenidoTXT);
                cargarNomina(contenidoTXT);
            }
            
            lectorDeDatos.close();
            
        } catch ( FileNotFoundException excepcionSinArchivo ) {
            excepcionSinArchivo.printStackTrace();
        }
        
    }
    
    public final void cargarNomina ( String texto ) {
        
        if ( texto.contains("#") ) { 
            
            System.out.println("#####");
            
        } else if ( texto.contains("%") ) {
            
            String[] aux = texto.split("%") ;
            
            this.aniadirEmpleado_ConAlgunasCredenciales(aux[0],aux[1],aux[2]);
            
        } else if ( texto.contains(",") ) {
            
            String[] aux = texto.split(",") ;
            
            this.empleados.get(this.empleados.size()-1).getAsignaturas_ListaCompleta().add(new Asignatura (aux[0],Double.valueOf(aux[1]))) ;
                        
        } else if ( !(texto.contains("%")) && !(texto.contains(",")) ) {
            
            if ( texto.matches("[0-9]") ) {
                
                String escalafon = texto ;
                this.empleados.get(this.empleados.size()-1).setEscalafon(Integer.parseInt(escalafon)) ;
                
            } else {
                
                String dependencia = texto ;
                this.empleados.get(this.empleados.size()-1).setDependencia(dependencia) ;
                
            }
            
        }
        
        completarEscalafones () ;
        
    }
    
    public void completarEscalafones ( ) {
        
        for ( Empleado e : this.empleados ) {
            
            if ( e.getDependencia().equals("Catedra") ) {
                e.setEscalafon(1);
            } else if ( e.getDependencia().equals("Instructor") ) {
                e.setEscalafon(2);
            } else if ( e.getDependencia().equals("Asistente") ) {
                e.setEscalafon(3);
            } else if ( e.getDependencia().equals("Asociado") ) {
                e.setEscalafon(4);
            } else if ( e.getDependencia().equals("Titular") ) {
                e.setEscalafon(5);
            }
            
        }
        
    }
    
    public void asignatura_A_empleado ( String nombre_A,double horas_A,String id_E,String cargo_E ) {
        
        Asignatura nuevaAsignatura = new Asignatura (nombre_A,horas_A) ;
        
        for ( Empleado e : this.empleados ) {
            
            if ( e.getId().equals(id_E) && e.getCargo().equals(cargo_E) ) {
                
                e.getAsignaturas_ListaCompleta().add(nuevaAsignatura) ;
                
                System.out.println("La signatura " + nuevaAsignatura.toString() + " se ha aniadido al empleado " + e.toString() + ".") ;
                
            } else {
                
                System.out.println("La asignatura no fue aniadida.");
                
            }
            
        }
        
    }
    
    public String calcularSalario_Empleado ( String id ) {
        
        double resultado = 0.0d ;
        
        for ( Empleado e : this.empleados ) {
            
            if ( e.getId().equals(id) ) {
                
                try {
                    
                    double primer_double = Double.valueOf(e.getNumeroSalarios_Integer()) ;
                    double segundo_double = Empleado.getSmlv_double();
                    double tercer_double = 0.88d ;
                    
                    resultado = primer_double * segundo_double * tercer_double ;
                    
                } catch (Exception exception) {
                    
                    double segundo_double = Empleado.getSmlv_double();
                    double tercer_double = 0.88d ;
                    
                    resultado = segundo_double * tercer_double ;
                    
                }
                
            }
            
        }
        
    return String.format("$%,.2f",resultado) ;
    }
    
    public String calcularSalario_Empleado ( String nombre,String cargo ) {
        
        double resultado = 0.0d ;
        
        for ( Empleado e : this.empleados ) {
            
            if ( e.getNombre().equals(nombre) && e.getCargo().equals(cargo) && cargo.equals("Profesor") ) {
                
                try {
                
                    double primer_double = Double.valueOf(e.getEscalafon_Integer()) ;
                    double segundo_double = Empleado.getSmlv_double() ;
                    double tercer_double = 0.88d ;
                    double cuarto_double = calcularHorasTotales(e.getId()) ;
                
                    resultado = primer_double * segundo_double * tercer_double * cuarto_double ;
                
                } catch (Exception exception) {
                
                    double segundo_double = Empleado.getSmlv_double() ;
                    double tercer_double = 0.88d ;
                    double cuarto_double = calcularHorasTotales(e.getId()) ;

                    resultado = segundo_double * tercer_double * cuarto_double ;
                
                }
                
            }
            
            if ( e.getNombre().equals(nombre) && e.getCargo().equals(cargo) && cargo.equals("Monitor") ) {
                
                double primer_double = e.getValorHoraTrabajada_double() ;
                double segundo_double = calcularHorasTotales(e.getId()) ;

                resultado = primer_double * segundo_double ;
                
            }
            
        }
        
    return String.format("$%,.2f",resultado) ;
    }
    
    public double calcularHorasTotales ( String id ) {
        
        double horasTotales = 0 ;
        
        for ( Empleado e : this.empleados ) {
            
            if ( e.getId().equals(id) ) {
            
                for ( Asignatura a : e.getAsignaturas_ListaCompleta() ) {

                    horasTotales += a.getHoras();

                }
                
            }
            
        }
    
    return horasTotales ;
    }
    
    
}
