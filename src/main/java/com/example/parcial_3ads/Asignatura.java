
package com.mycompany.parcial_3;


// imports



public class Asignatura {
    
    
    /*
        ATRIBUTOS.
    */
    
    // Atributo de clase.
    private static Integer cantidadAsignaturas = 0 ;
    
    // Atributos de instancia.
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
        
        Asignatura.cantidadAsignaturas++ ;
        
    }
    // Constructor de 'Asignatura' (con algunos datos).
    Asignatura ( String id,String nombre ) {
        
        this.id = id ;
        this.nombre = nombre ;
        
        Asignatura.cantidadAsignaturas++ ;
        
    }
    // Constructor de 'Asignatura' (con otros datos).
    Asignatura ( String nombre, double horas ) {
        
        this.nombre = nombre ;
        this.horas = horas ;
        
        Asignatura.cantidadAsignaturas++ ;
        
    }
    
    /*
        MÉTODOS DE ENCAPSULAMIENTO.
    */
    
    // ... para el atributo de clase 'cantidadAsignaturas'.
    public static Integer getCantidadAsignaturas_Integer ( ) {
        return Asignatura.cantidadAsignaturas ;
    }
    public static String getCantidadAsignaturas_String ( ) {
        return Integer.toString(Asignatura.cantidadAsignaturas) ;
    }
    public static void setCantidadAsignaturas_EliminarAsignatura ( ) {
        Asignatura.cantidadAsignaturas--;
    }
    // ... para el atributo 'nombre'.
    public String getNombre ( ) {
        return this.nombre ;
    }
    public void setNombre ( String nombre ) {
        this.nombre = nombre ;
    }
    // ... para el atributo 'id'.
    public String getId ( ) {
        return this.id ;
    }
    public void setId ( String id ) {
        this.id = id ;
    }
    // ... para el atributo 'horas'.
    public double getHoras () {
        return this.horas;
    }
    public void setId ( double horas ) {
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
        
    
}
