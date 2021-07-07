package utils;

import java.util.Comparator;
import modelo.Consulta;

public class OrdenadorFechaConsultas implements Comparator<Consulta>{
    //Permite ordenar de mas reciente a mas antigua los reportes de los juegos de los estudiantes
     @Override
     public int compare(Consulta o1, Consulta o2) {
         return o2.getFechaConsulta().compareTo(o1.getFechaConsulta());
     }  
}
