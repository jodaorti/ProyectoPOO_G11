package utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import modelo.AgenteVentas;
import modelo.Cliente;

public class ClassUtils {
    
    /**
    * Carga los usuarios previo a ejecucion del sistema:
    * Crear dos agentes de ventas, un cliente y 4 propiedades: dos terrenos y dos casas
    * Dos de estas propiedades deben estar en la misma ciudad y sector. 
    */
    public static void cargarInformacionDefecto()
    {
        String usuario,contrasenia,codigoAgente,nombre,cedula,email;        
        LocalDate fechaNacimiento;
        
        //Crear agentes de ventas
        
        //Agente 1
        usuario = "ag1";
        contrasenia = "123";
        codigoAgente = "ag1";
        nombre = "Marina";
        cedula = "1234";
        email  = "marina@gmail.com";
        AgenteVentas ag1 = new AgenteVentas(usuario,contrasenia,codigoAgente,nombre,cedula,email);

        //Agente 2 
        usuario = "ag2";
        contrasenia = "123";
        codigoAgente = "ag2";
        nombre = "Max";
        cedula = "2222";
        email  = "max@gmail.com";
        AgenteVentas ag2 = new AgenteVentas(usuario,contrasenia,codigoAgente,nombre,cedula,email);
        
        
        // Crear cliente       
        usuario = "cl1";
        contrasenia = "123";        
        nombre = "Marta";
        cedula = "1111";
        email  = "marta@gmail.com";
        fechaNacimiento = StringToDate("2001-04-10");
        Cliente cli1 = new Cliente(usuario, contrasenia, nombre, cedula,email, fechaNacimiento);
        
        
    }        
    
    public static LocalDate StringToDate(String fecha)
    {               
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(fecha, pattern);        
    }
}
