
package com.mycompany.parcial_3;


// imports



public class Empleado {
    
    
    /*
        ATRIBUTOS.
    */
    
    // Atributo de clase.
    private static double smlv = 1000000.0d ;
    private static Integer cantidadEmpleados = 0 ;

    // Atributos de instancia.
    private String nombre = new String() ;
    private String id = new String() ;
    private String dependencia = new String() ;
    private String cargo = new String() ;
    private Integer numeroSalarios ;
    private double valorHoraTrabajada ;
    /* ¿Empleado tiene lista de tipo 'Asignatura'? */
    
    
    /*
        CONSTRUCTORES.
    */
    
    // Constructor de 'Empleado' (con todos sus datos solicitados).
    Empleado ( String nombre,String id,String dependencia,String cargo,Integer numeroSalarios,double valorHoraTrabajada ) {

        this.nombre = nombre ;
        this.id = id ;
        this.dependencia = dependencia ;
        this.cargo = cargo ;
        this.numeroSalarios = numeroSalarios ;
        this.valorHoraTrabajada = valorHoraTrabajada ;
        
        Empleado.cantidadEmpleados++ ;

    }
    
    
    /*
        MÉTODOS DE ENCAPSULAMIENTO ...
    */
    
    // ... para el atributo de clase 'smlv'.
    public static double getSmlv_double ( ) {
        return Empleado.smlv ;
    }
    public static String getSmlv_String ( ) {
        return Double.toString ( Empleado.smlv ) ;
    }
    public static void setSmlv ( double smlv ) {
        Empleado.smlv = smlv ;
    }
    // ... para el atributo de clase 'cantidadEmpleados'.
    public static Integer getCantidadEmpleados_Integer ( ){
        return Empleado.cantidadEmpleados;
    }
    public static String getCantidadEmpleados_String ( ) {
        return Integer.toString(Empleado.cantidadEmpleados) ;
    }
    public static void setCantidadEmpleados_EliminarEmpleado ( ) {
        Empleado.cantidadEmpleados--;
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
    // ... para el atrinuto 'dependencia'.
    public String getDependencia ( ) {
        return this.dependencia ;
    }
    public void setDependencia ( String dependencia ) {
        this.dependencia = dependencia ;
    }
    // ... para el atributo 'cargo'.
    public String getCargo ( ) {
        return this.cargo ;
    }
    public void setCargo ( String cargo ) {
        this.cargo = cargo ;
    }
    // ... para el atributo 'numeroSalarios'.
    public Integer getNumeroSalarios_Integer ( ) {
        return this.numeroSalarios ;
    }
    public String getNumeroSalarios_String ( ) {
        return Integer.toString ( this.numeroSalarios ) ;
    }
    public void setNumeroSalarios ( Integer numeroSalarios ) {
        this.numeroSalarios = numeroSalarios ;
    }
    // ... para el atributo 'valorHoraTrabajada'.
    public double getValorHoraTrabajada_double ( ) {
        return this.valorHoraTrabajada ;
    }
    public String getValorHoraTrabajada_String ( ) {
        return Double.toString ( this.valorHoraTrabajada ) ;
    }
    public void setValorHoraTrabajada ( double valorHoraTrabajada ) {
        this.valorHoraTrabajada = valorHoraTrabajada ;
    }
    
    
    /*
        MÉTODOS SOBREESCRITOS.
    */
    
    // Sobrescritura del método 'ToString'.
    @Override
    public String toString() {
        return "\n\n" +
            "Empleado " + "{\n" +
                "\tnombre: " + nombre + ",\n" +
                "\tid: " + id + ",\n" +
                "\tdependencia: " + dependencia + ",\n" +
                "\tcargo: " + cargo + ",\n" +
                "\tnumeroSalarios: " + numeroSalarios + ",\n" +
                "\tvalorHoraTrabajada: " + valorHoraTrabajada + ",\n" +
            "}" +
        "\n\n";
    }
    
    
    /*
        MÉTODOS DE LA CLASE.
    */
    
    
}
