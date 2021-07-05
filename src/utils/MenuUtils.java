package utils;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Usuario;

/**
 * Carga la información de los menus a visualizar. 
 */
public class MenuUtils {

    /**
    * Carga la información de las opciones del menu principal.
     * @param sc Contiene el objeto que permite ingresar la opción
     * @return Devuelve la opción escogida
    */
    public static int generarMenuPrincipal(Scanner sc)
    {        
        System.out.println("\tSistema de Bienes Raices v 1.0");               
        String op = "";              
        do 
        {
            System.out.println("\n1. Iniciar Sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            op = sc.nextLine();             
        }
        while(!op.equalsIgnoreCase("1") && !op.equalsIgnoreCase("2") && !op.equalsIgnoreCase("3"));
        return Integer.parseInt(op);       
    }
    
    /**
    * Carga la información de las opciones del menu 1 
    * Verifica si el usuario existe en el listado de usuarios
     * @param usuarios
     * @param sc 
     * @return 
    */
    public static Usuario verificarEIngresarUsuario(ArrayList<Usuario> usuarios, Scanner sc)
    {                
        String us,cont = "";                      
        System.out.println("Ingresar usuario");
        us = sc.nextLine();
        System.out.println("Ingresar contrasenia");            
        cont = sc.nextLine();             
        return ClassUtils.verificarUsuarioSistema(usuarios,new Usuario(us, cont));              
    }
    
    /**
    * Muestra el menu de Administrador.
    */
    public static void generarMenuAdministrador(Scanner sc)
    {   
        System.out.println("\n Menu del Administrador");
        System.out.println("1. Registrar Propiedad");
        System.out.println("2. Registrar Agente");
        System.out.println("3. Reporte Contactos y Ventas");  
        System.out.println("4. Regresar");  
    }
    
    /**
    * Muestra el menu de Cliente.     
    */
    public static void generarMenuCliente()
    {
        System.out.println("\n Menu del Cliente");
        System.out.println("1. Consultar Propiedades");
        System.out.println("2. Buzón de Consultas");
        System.out.println("3. Crear Alerta");  
        System.out.println("4. Simular Préstamo");  
        System.out.println("5. Regresar");  
    }
    
    /**
    * Muestra el menu de Agente.
    */
    public static void generarMenuAgente()
    {
        System.out.println("\n Menu del Agente");
        System.out.println("1. Revisar buzón");
        System.out.println("2. Registrar Venta");
        System.out.println("5. Regresar"); 
    }                
}
