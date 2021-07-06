/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Scanner;
import tipos.Enum.tipoPropiedad;
import utils.ValidatorUtils;

/**
 *
 * @author dell
 */
public class Propiedad 
{   
    private String codigoPropiedad;
    private String descripcion;
    private double precio;
    private double metrosAncho;
    private double profundidad;
    private Ubicacion ubicacion;    
    private tipoPropiedad tipo;
    private boolean vendida;
    
    public Propiedad()
    {
        
    }

    public Propiedad(String codigoPropiedad,String descripcion, double precio, double metrosAncho, double profundidad,
                     Ubicacion ubicacion, tipoPropiedad tipo) {
        this.codigoPropiedad = codigoPropiedad;
        this.descripcion = descripcion;
        this.precio = precio;
        this.metrosAncho = metrosAncho;
        this.profundidad = profundidad;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.vendida = false;
    }

    public String getCodigoPropiedad() {
        return codigoPropiedad;
    }

    public void setCodigoPropiedad(String codigoPropiedad) {
        this.codigoPropiedad = codigoPropiedad;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getMetrosAncho() {
        return metrosAncho;
    }

    public void setMetrosAncho(double metrosAncho) {
        this.metrosAncho = metrosAncho;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public tipoPropiedad getTipo() {
        return tipo;
    }

    public void setTipo(tipoPropiedad tipo) {
        this.tipo = tipo;
    }

    public boolean isVendida() {
        return vendida;
    }

    public void setVendida(boolean vendida) {
        this.vendida = vendida;
    }
    
    

    @Override
    public String toString() {
        return codigoPropiedad.trim() + " $" + precio + " Metros: " + metrosAncho + " Profundidad: "+profundidad+" Tipo: "+ tipo.name();
    }
    
    
    
    /**
    * Cargar la información de las propiedades y mostrarlas en un listado.     
     * @param propiedades
     * @param sc
     * @return 
    */
    public static Propiedad mostrarListadoPropiedades(ArrayList<Propiedad> propiedades, Scanner sc)
    {                
        String format = " %1$-2s %2$-4s %3$-10s %4$-10s %5$-10s %6$-10s %7$-10s %8$-10s\n";        
        String op = "";
        int opcion = 0;
        int i;        
        do
        {
            do 
            {
                System.out.println("\n Listado de Propiedades");
                i = 1;
                for(Propiedad prop : propiedades)  
                {
                    if(!prop.vendida)
                    {
                        System.out.format(format,i,"Código: "+prop.getCodigoPropiedad(),
                                                   "Descripcion: "+prop.getDescripcion(),
                                                   "Precio: "+prop.getPrecio(),
                                                   "Metros Ancho: "+prop.getMetrosAncho(),
                                                   "Profundidad: "+prop.getProfundidad(),
                                                   "Tipo: "+prop.getTipo(),
                                                   "Vendida: "+prop.isVendida());                                                
                    }
                    i++;
                }
                op = sc.nextLine();
            }
            while(!ValidatorUtils.validarNumero(op));
            opcion = Integer.parseInt(op) - 1;
        }
        while(opcion < 0 || opcion > propiedades.size());
        return propiedades.get(opcion);        
    }
    
}
