package com.example.parcial_3ads;


// imports



public class Empleado {
    
    
    /*
        ATRIBUTOS DE CLASE.
    */
    
    private static final double SMLV = 1000000.0d ;
    private static Integer cantidadEmpleados = 0 ;
    
    
    /*
        ATRIBUTOS DE INSTANCIA.
    */
    
    private String nombre = new String() ;
    private String id = new String() ;
    private String dependencia = new String() ;
    private String cargo = new String() ;
    private Integer numeroSalarios ;
    
    
    /*
        CONSTRUCTORES.
    */
    
    // Constructor de 'Empleado' (con todos sus datos solicitados).
    Empleado ( String nombre,String id,String dependencia,String cargo,Integer numeroSalarios ) {

        this.nombre = nombre ;
        this.id = id ;
        this.dependencia = dependencia ;
        this.cargo = cargo ;
        this.numeroSalarios = numeroSalarios ;
                
        ++Empleado.cantidadEmpleados ;

    }
    
    // Constructor de 'Empleado' (con sus datos necesarios).
    Empleado ( String nombre,String id,String cargo ) {

        this.nombre = nombre ;
        this.id = id ;
        this.cargo = cargo ;
        
        ++Empleado.cantidadEmpleados ;

    }
    
    
    /*
        MÉTODOS DE ENCAPSULAMIENTO PARA ATRIBUTOS DE CLASE ...
    */
    
    // ... 'SMLV'.
    public static double getSmlv_double ( ) {
        return Empleado.SMLV ;
    }
    public static String getSmlv_String ( ) {
        return Double.toString (Empleado.SMLV ) ;
    }
    // El 'set' se omite por se un atributo de clase constante.
    
    // ... 'cantidadEmpleados'.
    public static Integer getCantidadEmpleados_Integer ( ){
        return Empleado.cantidadEmpleados ;
    }
    public static String getCantidadEmpleados_String ( ) {
        return Integer.toString(Empleado.cantidadEmpleados) ;
    }
    public static void setCantidadEmpleados_EliminarEmpleado ( boolean bandera ) {
        if ( bandera ) { --Empleado.cantidadEmpleados ; }
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
    
    // ... 'dependencia'.
    public String getDependencia ( ) {
        return this.dependencia ;
    }
    public void setDependencia ( String dependencia ) {
        this.dependencia = dependencia ;
    }
    
    // ... 'cargo'.
    public String getCargo ( ) {
        return this.cargo ;
    }
    public void setCargo ( String cargo ) {
        this.cargo = cargo ;
    }
    
    // ... 'numeroSalarios'.
    public Integer getNumeroSalarios_Integer ( ) {
        return this.numeroSalarios ;
    }
    public String getNumeroSalarios_String ( ) {
        return Integer.toString ( this.numeroSalarios ) ;
    }
    public void setNumeroSalarios ( Integer numeroSalarios ) {
        this.numeroSalarios = numeroSalarios ;
    }
    
    
    /*
        MÉTODOS SOBREESCRITOS.
    */
    
    // Sobrescritura del método 'ToString'.
    @Override
    public String toString() {
        return "\n\n" +
            "Empleado " + "{\n" +
                "\tnombre: " + this.nombre + ",\n" +
                "\tid: " + this.id + ",\n" +
                "\tdependencia: " + this.dependencia + ",\n" +
                "\tcargo: " + this.cargo + ",\n" +
                "\tnumeroSalarios: " + this.numeroSalarios + "\n" +
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
