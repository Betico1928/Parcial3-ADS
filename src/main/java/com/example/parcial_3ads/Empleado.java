
package com.mycompany.parcial_3;


import java.util.ArrayList;



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
    private Integer escalafon ;
    private ArrayList <Asignatura> listaAsignaturas ;
    
    
    /*
        CONSTRUCTORES.
    */
    
    // Constructor de 'Empleado' (con todos sus datos solicitados).
    Empleado ( String nombre,String id,String dependencia,String cargo,Integer numeroSalarios,double valorHoraTrabajada,int escalafon ) {

        this.nombre = nombre ;
        this.id = id ;
        this.dependencia = dependencia ;
        this.cargo = cargo ;
        this.numeroSalarios = numeroSalarios ;
        this.valorHoraTrabajada = valorHoraTrabajada ;
        this.escalafon = escalafon ;
        this.listaAsignaturas = new ArrayList <> () ;
        
        Empleado.cantidadEmpleados++ ;

    }
    // Constructor de 'Empleado' (con los datos necesarios).
    Empleado ( String nombre,String id,String cargo ) {

        this.nombre = nombre ;
        this.id = id ;
        this.cargo = cargo ;
        this.listaAsignaturas = new ArrayList <> () ;
        
        Empleado.cantidadEmpleados++ ;

    }
    // Constructor de 'Empleado' (con otros datos).
    Empleado ( String nombre,String id,String dependencia,String cargo ) {

        this.nombre = nombre ;
        this.id = id ;
        this.dependencia = dependencia ;
        this.cargo = cargo ;
        this.listaAsignaturas = new ArrayList <> () ;
        
        Empleado.cantidadEmpleados++ ;

    }
    // Constructor de 'Empleado' (con otros datos).
    Empleado ( String nombre,String id,String dependencia,String cargo,int escalafon ) {

        this.nombre = nombre ;
        this.id = id ;
        this.dependencia = dependencia ;
        this.cargo = cargo ;
        this.escalafon = escalafon ;
        this.listaAsignaturas = new ArrayList <> () ;
        
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
    // ... para el atributo 'escalafon'.
    public Integer getEscalafon_Integer ( ) {
        return this.escalafon ;
    }
    public String getEscalafon_String ( ) {
        return Integer.toString(this.escalafon);
    }
    public void setEscalafon ( Integer escalafon ) {
        this.escalafon = escalafon ;
    }
    // ... para el atributo 'listaAsignaturas'.
    public String getListaAsignaturas ( ) {
        
        String getListaAsignaturas = new String () ;
        
        for ( Asignatura i : this.listaAsignaturas ) {
            getListaAsignaturas += i.toString() ;
        }
        
    return getListaAsignaturas ;
    }
    public String getAsignaturaDeLista ( int indice ) {
        return this.listaAsignaturas.get(indice).toString() ;
    }
    public ArrayList <Asignatura> getAsignaturas_ListaCompleta ( ) {
        return this.listaAsignaturas ;
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
                "\tnumeroSalarios: " + this.numeroSalarios + ",\n" +
                "\tvalorHoraTrabajada: " + this.valorHoraTrabajada + ",\n" +
                "\tescalafon: " + this.escalafon + "\n" +
            "}" +
        "\n\n";
    }
    
    
    /*
        MÉTODOS DE LA CLASE.
    */
    
    
}
