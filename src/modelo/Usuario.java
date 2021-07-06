package modelo;

import tipos.Enum.tipoUsuario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Henry Arauz
 */

public class Usuario 
{       
    private String usuario;
    private String contrasenia;    
    private tipoUsuario tipo;
    
    public Usuario()
    {
        
    }
    
    public Usuario(String usuario, String contrasenia,tipoUsuario tipo) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
    }
    
    public Usuario(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;        
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }        

    public tipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(tipoUsuario tipo) {
        this.tipo = tipo;
    }
    
    
}
