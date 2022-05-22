
package com.example.parcial_3ads;


// imports



public class Asignatura {
    
    
    /*
        ATRIBUTOS DE CLASE.
    */
    
    private static Integer cantidadAsignaturas = 0 ;
    
    
    /*
        ATRIBUTOS DE INSTANCIA.
    */
    
    private String id = new String() ;
    private String nombre = new String() ;
    private double horas ;
    
    
    /*
        CONSTRUCTORES.
    */
    
    // Constructor de 'Asignatura' (con todos sus datos solicitados).
    Asignatura ( String id,String nombre,double horas ) {
        
        this.id = id ;
        this.nombre = nombre ;
        this.horas = horas ;
        
        ++Asignatura.cantidadAsignaturas ;
        
    }
    
    // Constructor de 'Asignatura' (con algunos datos).
    Asignatura ( String id,String nombre ) {
        
        this.id = id ;
        this.nombre = nombre ;
        
        ++Asignatura.cantidadAsignaturas ;
        
    }
    
    // Constructor de 'Asignatura' (con otros datos).
    Asignatura ( String nombre, double horas ) {
        
        this.nombre = nombre ;
        this.horas = horas ;
        
        ++Asignatura.cantidadAsignaturas ;
        
    }
    
    
    /*
        MÉTODOS DE ENCAPSULAMIENTO PARA ATRIBUTOS DE CLASE ...
    */
    
    // ... 'cantidadAsignaturas'.
    public static Integer getCantidadAsignaturas_Integer ( ) {
        return Asignatura.cantidadAsignaturas ;
    }
    public static String getCantidadAsignaturas_String ( ) {
        return Integer.toString(Asignatura.cantidadAsignaturas) ;
    }
    public static void setCantidadAsignaturas_EliminarAsignatura ( boolean bandera ) {
        if ( bandera ) { --Asignatura.cantidadAsignaturas ; }
    }
    
    
    /*
        MÉTODOS DE ENCAPSULAMIENTO PARA ATRIBUTOS DE INSTANCIA ...
    */
    
    // ... 'nombre'.
    public String getNombre ( ) {
        return this.nombre ;
    }
    public void setNombre ( String nombre ) {
        this.nombre = nombre ;
    }
    
    // ... 'id'.
    public String getId ( ) {
        return this.id ;
    }
    public void setId ( String id ) {
        this.id = id ;
    }
    
    // ... 'horas'.
    public double getHoras_double ( ) {
        return this.horas ;
    }
    public String getHoras_String ( ) {
        return Double.toString(this.horas) ;
    }
    public void setHoras ( double horas ) {
        this.horas = horas ;
    }
    
    
    /*
        MÉTODOS SOBREESCRITOS.
    */
    
    // Sobrescritura del método 'ToString'.
    @Override
    public String toString() {
        return "\n\n" +
            "Asignatura " + "{\n" +
                "\tnombre: " + this.nombre + ",\n" +
                "\tid: " + this.id + ",\n" +
                "\thoras: " + this.horas + "\n" +
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
