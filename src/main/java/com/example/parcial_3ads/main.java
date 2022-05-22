package com.example.parcial_3ads;


// imports



public class main {


    public static void main ( String args[] ) {
        
        Nomina nomina_01 = new Nomina () ;
        
        ControladorArchivosNomina.leerNomina(nomina_01.getEmpleados_ListaCompleta(),"G:\\1. PCs\\1. inASUS_TUF\\1. Documents\\PUJ\\Java\\IV\\ADS\\Parcial_3\\Nomina.txt");
        
//        for ( Empleado emp : nomina_01.getEmpleados_ListaCompleta() ) {
//            
//            if ( emp instanceof Profesor ) {
//                
//                System.out.println(emp.toString() ) ;
//                System.out.println(( (Profesor)emp ) . getListaAsignaturas() ) ;
//                
//            } else if ( emp instanceof Monitor ) {
//                
//                System.out.println(emp.toString() ) ;
//                System.out.println(( (Monitor)emp ) . getListaAsignaturas() ) ;
//            
//            } else if ( emp instanceof Empleado ) {
//                
//                System.out.println( emp.toString() );
//            
//            }
//            
//        }
        
    }


}
