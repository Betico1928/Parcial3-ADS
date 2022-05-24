
<<<<<<< HEAD:src/main/java/com/example/parcial_3ads/Monitor.java
package com.example.parcial_3ads;
=======
package parcial_03_withfx;
>>>>>>> JoJo:resources/Monitor.java


import java.util.ArrayList;



public class Monitor extends Empleado {
    
    
    /*
        ATRIBUTOS DE CLASE.
    */
    
    private static Integer cantidadMonitores = 0 ;
    
    
    /*
        ATRIBUTOS DE INSTANCIA.
    */
    
    private double valorHoraTrabajada = 10_000d ;
    
    private ArrayList <Asignatura> listaAsignaturas ;
    
    
    /*
        CONSTRUCTORES.
    */
    
    // Constructor de 'Monitor' (con todos sus datos solicitados).
    Monitor ( String nombre,String id,String dependencia,String cargo,Integer numeroSalarios,double valorHoraTrabajada ) {
        
        super ( nombre,id,dependencia,cargo,numeroSalarios ) ;
        
        this.valorHoraTrabajada = valorHoraTrabajada ;
        
        this.listaAsignaturas = new ArrayList <> () ;
        
        ++Monitor.cantidadMonitores ;
        
    }
    
    // Constructor de 'Monitor' (con sus datos necesarios).
    Monitor ( String nombre,String id,String cargo ) {
        
        super ( nombre,id,cargo ) ;
        
        this.listaAsignaturas = new ArrayList <> () ;
        
        ++Monitor.cantidadMonitores ;
        
    }
    
    
    /*
        MÉTODOS DE ENCAPSULAMIENTO PARA ATRIBUTOS DE CLASE ...
    */
    
    // ... 'cantidadMonitores'.
    public static Integer getCantidadMonitores_Integer ( ){
        return Monitor.cantidadMonitores ;
    }
    public static String getCantidadMonitores_String ( ) {
        return Integer.toString(Monitor.cantidadMonitores) ;
    }
    public static void setCantidadMonitores_EliminarMonitor ( boolean bandera ) {
        if ( bandera ) { --Monitor.cantidadMonitores ; }
    }
    
    
    /*
        MÉTODOS DE ENCAPSULAMIENTO PARA ATRIBUTOS DE INSTANCIA ...
    */
    
    // ... 'valorHoraTrabajada'.
    public double getValorHoraTrabajada_double ( ) {
        return this.valorHoraTrabajada ;
    }
    public String getValorHoraTrabajada_String ( ) {
        return Double.toString ( this.valorHoraTrabajada ) ;
    }
    public void setValorHoraTrabajada ( double valorHoraTrabajada ) {
        this.valorHoraTrabajada = valorHoraTrabajada ;
    }
    
    // ... 'listaAsignaturas'.
    public String getListaAsignaturas ( ) {
        
        String getListaAsignaturas = new String () ;
        
        for ( Asignatura i : this.listaAsignaturas ) {
            getListaAsignaturas += i.toString() ;
        }
        
    return getListaAsignaturas ;
    }
    public ArrayList <Asignatura> getAsignaturas_ListaCompleta ( ) {
        return this.listaAsignaturas ;
    }
    public void setAsignaturas_ListaCompleta ( ArrayList <Asignatura> listaAsignaturas ) {
        this.listaAsignaturas = listaAsignaturas ;
    }
    
    
    /*
        MÉTODOS SOBREESCRITOS.
    */
    
    // Sobrescritura del método 'ToString'.
    @Override
    public String toString() {
        return "\n\n" +
            "Monitor " + "{\n" +
                "\tnombre: " + super.getNombre() + ",\n" +
                "\tid: " + super.getId() + ",\n" +
                "\tdependencia: " + super.getDependencia() + ",\n" +
                "\tcargo: " + super.getCargo() + ",\n" +
                "\tnumeroSalarios: " + super.getNumeroSalarios_String() + ",\n" +
                "\tvalorHoraTrabajada: " + this.valorHoraTrabajada + "\n" +
            "}" +
        "\n\n";
    }
    
    
    /*
        MÉTODOS DE CLASE.
    */
    
    // Sin métodos de clase.
    
    
    /*
        MÉTODOS DE INSTANCIA.
    */
    
    // Sin métodos de instancia.
    
    
}
