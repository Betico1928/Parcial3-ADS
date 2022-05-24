
<<<<<<< HEAD:src/main/java/com/example/parcial_3ads/Profesor.java
package com.example.parcial_3ads;
=======
package parcial_03_withfx;
>>>>>>> JoJo:resources/Profesor.java


import java.util.ArrayList;



public class Profesor extends Empleado {
    
    
    /*
        ATRIBUTOS DE CLASE.
    */
    
    private static Integer cantidadProfesores = 0 ;
    
    
    /*
        ATRIBUTOS DE INSTANCIA.
    */
    
    private String escalafon ;
    private double valorHoraTrabajada = 10_000d ;
    
    private ArrayList <Asignatura> listaAsignaturas ;
    
    
    /*
        CONSTRUCTORES.
    */
    
    // Constructor de 'Profesor' (con todos sus datos solicitados).
    Profesor ( String nombre,String id,String dependencia,String cargo,Integer numeroSalarios,String escalafon,double valorHoraTrabajada ) {
        
        super ( nombre,id,dependencia,cargo,numeroSalarios ) ;
        
        this.escalafon = escalafon ;
        this.valorHoraTrabajada = valorHoraTrabajada ;
        
        this.listaAsignaturas = new ArrayList <> () ;
        
        ++Profesor.cantidadProfesores ;
        
    }
    
    // Constructor de 'Profesor' (con sus datos necesarios).
    Profesor ( String nombre,String id,String cargo ) {
        
        super ( nombre,id,cargo ) ;
        
        this.listaAsignaturas = new ArrayList <> () ;
        
        ++Profesor.cantidadProfesores ;
        
    }
    
    
    /*
        MÉTODOS DE ENCAPSULAMIENTO PARA ATRIBUTOS DE CLASE ...
    */
    
    // ... 'cantidadProfesores'.
    public static Integer getCantidadProfesores_Integer ( ){
        return Profesor.cantidadProfesores ;
    }
    public static String getCantidadProfesores_String ( ) {
        return Integer.toString(Profesor.cantidadProfesores) ;
    }
    public static void setCantidadProfesores_EliminarProfesor ( boolean bandera ) {
        if (bandera) { --Profesor.cantidadProfesores ; }
    }
    
    
    /*
        MÉTODOS DE ENCAPSULAMIENTO PARA ATRIBUTOS DE INSTANCIA ...
    */
    
    // ... 'escalafon'.
    public String getEscalafon ( ) {
        return this.escalafon;
    }
    public void setEscalafon ( String escalafon ) {
        this.escalafon = escalafon ;
    }
    
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
            "Profesor " + "{\n" +
                "\tnombre: " + super.getNombre() + ",\n" +
                "\tid: " + super.getId() + ",\n" +
                "\tdependencia: " + super.getDependencia() + ",\n" +
                "\tcargo: " + super.getCargo() + ",\n" +
                "\tnumeroSalarios: " + super.getNumeroSalarios_String() + ",\n" +
                "\tescalafon: " + this.escalafon +  ",\n" +
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
