package utils;

import java.util.Scanner;

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
            op = sc.nextLine();             
        }
        while(!op.equalsIgnoreCase("1") && !op.equalsIgnoreCase("2"));
        return Integer.parseInt(op);       
    }
    
    
    
}
