package modelo;
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

    public Usuario()
    {
        
    }
    
    public Usuario(String usuario, String contrasenia) {
        this.usuario = usuario;
        //this.contrasenia = contrasenia;
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
}
