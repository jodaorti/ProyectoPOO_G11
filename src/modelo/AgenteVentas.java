package modelo;
import java.time.LocalDate;
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
    private ArrayList<Venta> ventas;

    public AgenteVentas() 
    {
        this.ventas = new ArrayList<>();
    }

    public AgenteVentas(String usuario, String contrasenia, String codigoAgente,
                        String nombre  ,String cedula,  String correo) {
        super(usuario, contrasenia,tipoUsuario.AGENTE);
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.codigoAgente = codigoAgente;
        this.ventas = new ArrayList<>();
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

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public void agregarVenta(Venta venta) {
        this.ventas.add(venta);
    }

    /** Obtener el agente de Ventas del listado.
     * @param agentes
     * @param us
     * @return 
    */
    public static AgenteVentas getAgenteVentas(ArrayList<AgenteVentas> agentes, Usuario us)
    {
        for(AgenteVentas agente : agentes)
        {
            if(us.getUsuario().trim().equalsIgnoreCase(agente.getUsuario().trim()) &&
               us.getContrasenia().trim().equalsIgnoreCase(agente.getContrasenia().trim()))
                return agente;
        }
        return null;
    }
    
    /** Crear una venta del agente con un cliente.
     * @param propiedad
     * @param cliente          
     * @return 
    */
    public static Venta registrarVenta(Propiedad propiedad, Cliente cliente)
    {               
        return new Venta(propiedad, cliente);        
    }
    
    
}
