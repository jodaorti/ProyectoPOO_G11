package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class ValidatorUtils {
    
    /**
    * Validar la fecha en el siguiente formato yyyy-MM-dd
    * caso contrario devuelve falso. 
     * @param fecha
     * @return 
    */
    public static boolean validarFecha(String fecha)
    {        
        String[] fechaPart = fecha.split("/");
        String anio,mes,dia;
        if(fechaPart.length != 3)
            return false;
        dia   = fechaPart[0];
        mes   = fechaPart[1];
        anio  = fechaPart[2];     
                
        return validarNumero(anio) && validarNumero(mes) && validarNumero(dia);                   
    }
    
    /**
    * Validar si el string es un numero
    * caso contrario devuelve falso. 
     * @param numero
     * @return 
    */
    public static boolean validarNumero(String numero)
    {
        if(numero == null)return false;
        if(numero.length() == 0)return false;
        for (int i = 0; i < numero.length(); i++)
        {
            if (!Character.isDigit(numero.charAt(i)))
                return false;
        }
        return true;
    }
    
    /**
    * Validar si la edad basada en la fecha de nacimiento es valida >=18. 
     * @param numero
     * @return 
    */
    public static boolean edadValidaRegistro(LocalDate fechaNacimiento)
    {
        LocalDate fechaActual = LocalDate.now();
        if ((fechaNacimiento != null)) 
            return  Period.between(fechaNacimiento, fechaActual).getYears() >= 18;
        return false;
    }
    
    /**
    * Validar si el rango de fechas es valido. 
     * @param numero
     * @return 
    */
    public static boolean validarRangoFechas(String rangoFecha)
    {        
        String[] fechaPart = rangoFecha.split("-");
        if(fechaPart.length != 2)
            return false;
        String fechaDesde = fechaPart[0];
        String fechaHasta = fechaPart[1];
        return validarFecha(fechaDesde) && validarFecha(fechaHasta);        
    }
    
    /**
    * Validar si el rango de fechas es valido.      
     * @param rangoPrecios
     * @return 
    */
    public static boolean validarRangoPrecios(String rangoPrecios)
    {        
        String[] precioPart = rangoPrecios.split("-");
        if(precioPart.length != 2)
            return false;
        String precioDesde = precioPart[0];
        String precioHasta = precioPart[1];
        return validarNumero(precioDesde) && validarNumero(precioHasta);        
    }
}
