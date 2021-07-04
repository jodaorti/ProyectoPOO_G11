package utils;

public class ValidatorUtils {
    
    /**
    * Validar la fecha en el siguiente formato yyyy-MM-dd
    * caso contrario devuelve falso. 
     * @param fecha
     * @return 
    */
    public static boolean validarFecha(String fecha)
    {        
        String[] fechaPart = fecha.split("-");
        String anio,mes,dia;
        if(fechaPart.length != 3)
            return false;
        anio = fechaPart[2];
        mes  = fechaPart[1];
        dia  = fechaPart[0];        
        return !validarNumero(anio) || !validarNumero(mes) || !validarNumero(dia);                   
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
}
