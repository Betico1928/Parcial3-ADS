
package com.mycompany.parcial_3;


import java.util.ArrayList;



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
    
    // Constructor por defecto.
    
    
    /*
        MÉTODOS DE ENCAPSULAMIENTO ...
    */
    
    public String getListaEmpleados ( ) {
        
        String getListaEmpleados = new String ();
        
        for ( Empleado i : empleados ) {
            getListaEmpleados += i.toString();
        }
        
    return getListaEmpleados ;
    }
    public String getEmpleadoDeLista ( ArrayList <Empleado> lista,int indice ) {
        return lista.get(indice).toString();
    }
    // El método 'set' de la lista 'empleados' le corresponde a otra cantidad de métodos.
    
    
    /*
        MÉTODOS SOBREESCRITOS.
    */
    
    // Sobrescritura del método 'ToString'.
    @Override
    public String toString ( ) {
        
        String getListaEmpleados = new String ();
        
        for ( Empleado i : empleados ) {
            getListaEmpleados += i.toString();
        }
        
    return getListaEmpleados ;
    }
    
    
    /*
        MÉTODOS DE CLASE.
    */
    
    public void aniadirEmpleado_SinCredenciales ( ArrayList <Empleado> listaEmpleados,Empleado empleadoParaAniadir ) {
        
        boolean bandera = listaEmpleados.add(empleadoParaAniadir);
        
        if ( bandera ) {
            System.out.println ("Empleado aniadido exitosamente.") ;
        } else {
            System.out.println ("No se aniade el empleado solicitado.") ;
        }
        
    }
    
    public void aniadirEmpleado_ConCredenciales ( ArrayList <Empleado> listaEmpleados,String nombre,String id,String dependencia,String cargo,Integer numeroSalarios,double valorHoraTrabajada ) {
        
        /* ¿preguntar credenciales por consola? */
        
        Empleado empleadoParaAniadir = new Empleado (nombre,id,dependencia,cargo,numeroSalarios,valorHoraTrabajada) ;
        
        boolean bandera = listaEmpleados.add(empleadoParaAniadir) ;
        
        if ( bandera ) {
            System.out.println ("Empleado aniadido exitosamente.") ;
        } else {
            System.out.println ("No se aniade el empleado solicitado.") ;
        }
        
    }
    
    public void eliminarEmpleado_SinIndice ( ArrayList <Empleado> listaEmpleados,Empleado empleadoParaEliminar ) {
        
        boolean bandera = listaEmpleados.remove(empleadoParaEliminar);
        
        if ( bandera ) {
            System.out.println ("Empleado eliminado satisfactoriamente.");
        } else {
            System.out.println ("No se ha eliminado el empleado solicitado.");
        }
        
        System.out.println ("La cantidad de empleados antes de la operación era de :" + Empleado.getCantidadEmpleados_String());
        Empleado.setCantidadEmpleados_EliminarEmpleado();
        System.out.println ("Ahora la cantidad de empleados es de: " + Empleado.getCantidadEmpleados_String());
        
    }
    
    public void eliminarEmpleado_ConIndice ( ArrayList <Empleado> listaEmpleados,int indice ) {
        
        Empleado empleadoEliminado = listaEmpleados.remove(indice);
        
        if ( !empleadoEliminado.toString().isEmpty() || !empleadoEliminado.toString().equals(null) ) {
            System.out.println ("Empleado eliminado satisfactoriamente.") ;
            System.out.println ("Las credenciales del empleado eliminado son: " + empleadoEliminado.toString()) ;
        } else {
            System.out.println ("No se ha eliminado el empleado solicitado.");
        }
        
        System.out.println ("La cantidad de empleados antes de la operación era de :" + Empleado.getCantidadEmpleados_String());
        Empleado.setCantidadEmpleados_EliminarEmpleado();
        System.out.println ("Ahora la cantidad de empleados es de: " + Empleado.getCantidadEmpleados_String());
        
    }
    
    
}
