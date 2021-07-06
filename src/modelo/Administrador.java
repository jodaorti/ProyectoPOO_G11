/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import tipos.Enum;
import tipos.Enum.tipoUsuario;

/**
 * 
 * @author Joffre Ortiz
 */
public class Administrador extends Usuario 
{
    private String nombre;
    private String cedula;
    private String correo;
    
    public Administrador()
    {
        
    }   

    public Administrador(String usuario, String contrasenia,String nombre,
                         String cedula, String correo ) {
        super(usuario, contrasenia, tipoUsuario.ADMINISTRADOR);
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    
    /**
     * Se registra la propiedad del cliente
     */
    public void registrarPropiedad(){
        
    }
    /**
     * Se registra el agente con el cual se hará la venta
     * @param nombre
     * @param cedula
     * @param correo 
     */
    public void registrarAgente(String nombre,String cedula,String correo){
        
    }
    /**
     * Se genera un reporte actualizado con las ventas y su debido contacto con el agente
     * @param finicio
     * @param Ffinal 
     */
    public void reporteContactoyVentas(String finicio,String Ffinal){
        
    }

}
