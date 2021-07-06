package modelo;
import java.util.ArrayList;
import tipos.Enum.tipoUsuario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dell
 */

public class AgenteVentas extends Usuario{
    private String nombre;
    private String cedula;
    private String correo;
    private String codigoAgente;

    public AgenteVentas() {        
    }

    public AgenteVentas(String usuario, String contrasenia, String codigoAgente,
                        String nombre  ,String cedula,  String correo) {
        super(usuario, contrasenia,tipoUsuario.AGENTE);
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.codigoAgente = codigoAgente;
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

    public String getCodigoAgente() {
        return codigoAgente;
    }

    public void setCodigoAgente(String codigoAgente) {
        this.codigoAgente = codigoAgente;
    }

    
}
