/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import tipos.Enum.tipoPropiedad;

/**
 *
 * @author dell
 */
public class Propiedad 
{   
    private String codigoPropiedad;
    private double precio;
    private double metrosAncho;
    private double profundidad;
    private Ubicacion ubicacion;    
    private tipoPropiedad tipo;
    
    public Propiedad()
    {
        
    }

    public Propiedad(String codigoPropiedad, double precio, double metrosAncho, double profundidad,
                     Ubicacion ubicacion, tipoPropiedad tipo) {
        this.codigoPropiedad = codigoPropiedad;
        this.precio = precio;
        this.metrosAncho = metrosAncho;
        this.profundidad = profundidad;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
    }
    
    
}
