package modelo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import tipos.Enum.tipoUsuario;
import utils.ClassUtils;
import utils.ValidatorUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 59399
 */
public class Cliente extends Usuario 
{
    private String nombre;
    private String cedula;
    private String correo;
    private LocalDate  fechaNacimiento;
    
    public Cliente()
    {
        
    }

    public Cliente(String usuario, String contrasenia,String nombre,
                   String cedula, String correo, LocalDate fechaNacimiento) {
        super(usuario, contrasenia,tipoUsuario.CLIENTE);
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
     /** Obtener el cliente del listado.
     * @param clientes
     * @param us
     * @return 
    */
    public static Cliente getCliente(ArrayList<Cliente> clientes, Usuario us)
    {
        for(Cliente cliente : clientes)
        {
            if(us.getUsuario().trim().equalsIgnoreCase(cliente.getUsuario().trim()) &&
               us.getContrasenia().trim().equalsIgnoreCase(cliente.getContrasenia().trim()))
                return cliente;
        }
        return null;
    }
    
    
    
    /*
    Muestra al cliente las propiedades en venta con o sin filtros de precio,tipo,ciudad o sector aplicados
    */
    public void consultrarPropiedades(){
        
    }
    public void buzonConsultas(){
        
    }
    public void crearAlerta(){
        
    }
    public ArrayList simularPrestamo(double costo,double i,int n,String sistema){
        ArrayList<Double> cuotas= new ArrayList<>();
        return cuotas;  
    }
    
    /**
    * Registra el cliente a ingresar      
     * @param sc
     * @return 
    */
    public static Cliente registrarCliente(Scanner sc)
    {
        System.out.println("\n Registro de Cliente");
                          
        String usuario,contrasenia,nombre,cedula,correo,fechaNacimiento = "";  
        LocalDate fechaNac;
        
        System.out.println("\nUsuario: ");
        usuario = sc.nextLine();
        System.out.println("Contraseña: ");
        contrasenia = sc.nextLine();
        System.out.println("Nombre: ");
        nombre = sc.nextLine();
        System.out.println("Cedula: ");
        cedula = sc.nextLine();
        System.out.println("Correo: ");
        correo = sc.nextLine();
        
        do            
        {
            System.out.println("Fecha Nacimiento: ");
            fechaNacimiento = sc.nextLine();                                 
        }
        while(!ValidatorUtils.validarFecha(fechaNacimiento));
        
        fechaNac = ClassUtils.StringToDate(fechaNacimiento);   
        if(!ValidatorUtils.edadValidaRegistro(fechaNac))
        {
            System.out.println("La edad no es válida para registrar el cliente");
            return null;
        }        
        return new Cliente(usuario,contrasenia, nombre, cedula, correo, fechaNac);
    }
}
