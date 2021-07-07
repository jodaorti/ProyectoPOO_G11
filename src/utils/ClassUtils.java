package utils;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import modelo.Administrador;
import modelo.AgenteVentas;
import modelo.Casa;
import modelo.Cliente;
import modelo.Sistema;
import modelo.Terreno;
import modelo.Ubicacion;
import modelo.Usuario;
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
        sistema.getListaAgentes().add(ag1);

        //Agente 2 
        usuario = "ag2";
        contrasenia = "123";
        codigoAgente = "ag2";
        nombre = "Max";
        cedula = "2222";
        email  = "max@gmail.com";
        AgenteVentas ag2 = new AgenteVentas(usuario,contrasenia,codigoAgente,nombre,cedula,email);
        sistema.getListaAgentes().add(ag2);
        
        
        // Crear cliente       
        usuario = "cl1";
        contrasenia = "123";        
        nombre = "Marta";
        cedula = "1111";
        email  = "marta@gmail.com";
        fechaNacimiento = StringToDate("10/04/2001");
        Cliente cli1 = new Cliente(usuario, contrasenia, nombre, cedula,email, fechaNacimiento);
        sistema.getListaClientes().add(cli1);
        
        // Crear Administrador       
        usuario = "adm1";
        contrasenia = "123";        
        nombre = "Luis";
        cedula = "1111";
        email  = "marta@gmail.com";        
        Administrador adm = new Administrador( usuario, contrasenia, nombre, cedula,email);
        sistema.getListaAdministradores().add(adm);
        
        String codigoPropiedad,descripcion;
        double precio,metrosAncho,profundidad;
        int numPisos,numHabitaciones;
        Ubicacion ubicacion;
        
        //Crear terrenos
        codigoPropiedad = "pr1";
        descripcion = "Terreno 1";
        precio = 10000;
        metrosAncho = 60;
        profundidad = 10;        
        ubicacion = new Ubicacion("Guayas","Guayaquil","cdla. Sta Cecilia","norte");
        Terreno ter1 = new Terreno(codigoPropiedad,descripcion, precio,metrosAncho,profundidad,ubicacion,tipoTerreno.VIVIENDA,ag1);
        sistema.agregarPropiedad(ter1);
        
        codigoPropiedad = "pr2";
        descripcion = "Terreno 2";
        precio = 15000;
        metrosAncho = 80;
        profundidad = 20;        
        ubicacion = new Ubicacion("Guayas","Guayaquil","cdla. Alborada","norte");
        Terreno ter2 = new Terreno(codigoPropiedad,descripcion, precio,metrosAncho,profundidad,ubicacion,tipoTerreno.EMPRESARIAL,ag2);
        sistema.agregarPropiedad(ter2);
        
        //Crear Casas
        codigoPropiedad = "pr3";
        descripcion = "Casa 1";
        precio = 17000;
        metrosAncho = 70;
        profundidad = 30;        
        ubicacion = new Ubicacion("Pichincha","Quito","cdla. Concordia","norte");
        numPisos = 2;
        numHabitaciones = 3;
        Casa casa1 = new Casa(codigoPropiedad,descripcion, precio,metrosAncho,profundidad,ubicacion,numPisos,numHabitaciones,ag1);
        sistema.agregarPropiedad(casa1);
        
        codigoPropiedad = "pr4";
        descripcion = "Casa 2";
        precio = 8000;
        metrosAncho = 30;
        profundidad = 30;        
        ubicacion = new Ubicacion("Pichincha","Quito","cdla. Macarena","norte");
        numPisos = 1;
        numHabitaciones = 2;
        Casa casa2 = new Casa(codigoPropiedad,descripcion, precio,metrosAncho,profundidad,ubicacion,numPisos,numHabitaciones,ag2);
        sistema.agregarPropiedad(casa2);
        
        return sistema;
    }        
    
    /**
    * Permite convertir la fecha de tipo String a LocalDate.               
     * @param fecha
     * @return 
    */
    public static LocalDate StringToDate(String fecha)
    {               
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(fecha, pattern);        
    }
    
    /**
    * Permite convertir la fecha de tipo String a LocalDateTime.               
     * @param fecha
     * @return 
    */
    public static LocalDateTime StringToDateTime(String fecha)
    {               
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.parse(fecha, pattern);        
    }        
    
    /**
    * Permite convertir la fecha de tipo Date a String para ser guardada en el archivo..               
     * @param fecha
     * @return 
    */
    public static String dateTimeToString(LocalDateTime fecha)
    {
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return fecha.format(formatter);                       
    }
    
    /**
    * Ingresa los datos del usuario a verificar, si es asi devuelve true caso contrario false
    * Dos de estas propiedades deben estar en la misma ciudad y sector. 
     * @param usuarios
     * @param usuario
     * @return 
    */
    public static Usuario verificarUsuarioSistema(ArrayList<Usuario> usuarios, Usuario usuario)
    {
        for(Usuario us : usuarios)
        {
            if(usuario.getUsuario().trim().equalsIgnoreCase(us.getUsuario().trim()) && 
               usuario.getContrasenia().trim().equalsIgnoreCase(us.getContrasenia().trim()))
                return us;            
        }
        return null; 
    }           
}
