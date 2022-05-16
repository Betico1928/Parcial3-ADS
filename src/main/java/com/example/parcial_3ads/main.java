
package com.mycompany.parcial_3;


// imports



public class main {


    public static void main ( String args[] ) {
        
        Nomina nomina_X_empresa_01 = new Nomina();
        
        nomina_X_empresa_01.leerNomina("G:\\1. PCs\\1. inASUS_TUF\\1. Documents\\PUJ\\Java\\IV\\ADS\\Parcial_3\\Nomina.txt");
                
        for ( Empleado e : nomina_X_empresa_01.getEmpleados_ListaCompleta() ) {
            System.out.println(e.toString());
            System.out.println(e.getListaAsignaturas());
        }
        
    }


}
