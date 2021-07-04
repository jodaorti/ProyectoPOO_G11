package utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import modelo.AgenteVentas;
import modelo.Casa;
import modelo.Cliente;
import modelo.Sistema;
import modelo.Terreno;
import modelo.Ubicacion;
import tipos.Enum.tipoTerreno;

public class ClassUtils {
    
    /**
    * Carga los usuarios previo a ejecucion del sistema:
    * Crear dos agentes de ventas, un cliente y 4 propiedades: dos terrenos y dos casas
    * Dos de estas propiedades deben estar en la misma ciudad y sector. 
     * @return 
    */
    public static Sistema cargarInformacionDefecto()
    {
        Sistema sistema = new Sistema();
        
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
        sistema.setListaAgentes(ag1);

        //Agente 2 
        usuario = "ag2";
        contrasenia = "123";
        codigoAgente = "ag2";
        nombre = "Max";
        cedula = "2222";
        email  = "max@gmail.com";
        AgenteVentas ag2 = new AgenteVentas(usuario,contrasenia,codigoAgente,nombre,cedula,email);
        sistema.setListaAgentes(ag2);
        
        
        // Crear cliente       
        usuario = "cl1";
        contrasenia = "123";        
        nombre = "Marta";
        cedula = "1111";
        email  = "marta@gmail.com";
        fechaNacimiento = StringToDate("2001-04-10");
        Cliente cli1 = new Cliente(usuario, contrasenia, nombre, cedula,email, fechaNacimiento);
        sistema.setListaClientes(cli1);
        
        String codigoPropiedad;
        double precio,metrosAncho,profundidad;
        int numPisos,numHabitaciones;
        Ubicacion ubicacion;
        
        //Crear terrenos
        codigoPropiedad = "pr1";
        precio = 10000;
        metrosAncho = 60;
        profundidad = 10;        
        ubicacion = new Ubicacion("Guayas","Guayaquil","cdla. Sta Cecilia","norte");
        Terreno ter1 = new Terreno(codigoPropiedad,precio,metrosAncho,profundidad,ubicacion,tipoTerreno.VIVIENDA);
        sistema.setListaPropiedades(ter1);
        
        codigoPropiedad = "pr2";
        precio = 15000;
        metrosAncho = 80;
        profundidad = 20;        
        ubicacion = new Ubicacion("Guayas","Guayaquil","cdla. Alborada","norte");
        Terreno ter2 = new Terreno(codigoPropiedad,precio,metrosAncho,profundidad,ubicacion,tipoTerreno.EMPRESARIAL);
        sistema.setListaPropiedades(ter2);
        
        //Crear Casas
        codigoPropiedad = "pr3";
        precio = 17000;
        metrosAncho = 70;
        profundidad = 30;        
        ubicacion = new Ubicacion("Pichincha","Quito","cdla. Concordia","norte");
        numPisos = 2;
        numHabitaciones = 3;
        Casa casa1 = new Casa(codigoPropiedad,precio,metrosAncho,profundidad,ubicacion,numPisos,numHabitaciones);
        sistema.setListaPropiedades(casa1);
        
        codigoPropiedad = "pr4";
        precio = 8000;
        metrosAncho = 30;
        profundidad = 30;        
        ubicacion = new Ubicacion("Pichincha","Quito","cdla. Macarena","norte");
        numPisos = 1;
        numHabitaciones = 2;
        Casa casa2 = new Casa(codigoPropiedad,precio,metrosAncho,profundidad,ubicacion,numPisos,numHabitaciones);
        sistema.setListaPropiedades(casa2);
        
        return sistema;
    }        
    
    public static LocalDate StringToDate(String fecha)
    {               
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(fecha, pattern);        
    }
}
