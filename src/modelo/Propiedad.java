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

    public String getCodigoPropiedad() {
        return codigoPropiedad;
    }

    public void setCodigoPropiedad(String codigoPropiedad) {
        this.codigoPropiedad = codigoPropiedad;
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
    
    
    
}
