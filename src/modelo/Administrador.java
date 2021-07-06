/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.Scanner;
import tipos.Enum;
import tipos.Enum.tipoTerreno;
import tipos.Enum.tipoUsuario;
import utils.ValidatorUtils;

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
     * Se registra la propiedad del cliente.
     * @param sc
     * @return 
     */
    public static Propiedad registrarPropiedad(Scanner sc){
        System.out.println("\n Registro de Propiedad");        
        String op,tipoPropiedad,codigoPropiedad,prc,mts,prf,provincia,
               ciudad,direccion,sector,numP,numH = "";
        
        double precio,metros,profundidad = 0;
        int numPisos,numHab = 0;
        
        do 
        {
            System.out.println("\nSeleccione Terreno(1) o Casa(2): ");
            op = sc.nextLine();
        }
        while(!op.equalsIgnoreCase("1") && !op.equalsIgnoreCase("2"));
        do
        {
            System.out.println("Código de Propiedad: ");
            codigoPropiedad = sc.nextLine();
        }
        while(codigoPropiedad.trim().isEmpty());        
        do
        {
            System.out.println("Precio: ");
            prc = sc.nextLine();
        }
        while(!ValidatorUtils.validarNumero(prc));
        precio = Double.parseDouble(prc);
        do
        {
            System.out.println("Metros de ancho: ");
            mts = sc.nextLine();
        }
        while(!ValidatorUtils.validarNumero(mts));
        metros = Double.parseDouble(mts);
        do
        {
            System.out.println("Profundidad: ");
            prf = sc.nextLine();
        }
        while(!ValidatorUtils.validarNumero(prf));
        profundidad = Double.parseDouble(prf);
        
        System.out.println("Provincia: ");
        provincia = sc.nextLine();
        System.out.println("Ciudad: ");
        ciudad = sc.nextLine();
        System.out.println("Dirección: ");        
        direccion = sc.nextLine();
        System.out.println("Sector: ");
        sector = sc.nextLine();
        Ubicacion ubicacion = new Ubicacion(provincia, ciudad, direccion, sector);
        
        //Terreno
        if(op.equalsIgnoreCase("1"))
        {
            do 
            {
                System.out.println("\nSeleccione tipo de Terreno COMERCIAL(1), VIVIENDA(2), EMPRESARIAL(3): ");
                op = sc.nextLine();
            }
            while(!op.equalsIgnoreCase("1") && !op.equalsIgnoreCase("2") && !op.equalsIgnoreCase("3"));
            tipoTerreno tipoterreno;
            switch(op)
            {
                case "1":
                    tipoterreno = tipoTerreno.COMERCIAL;
                    break;
                
                case "2":
                    tipoterreno = tipoTerreno.VIVIENDA;
                    break;
                
                default:
                    tipoterreno = tipoTerreno.EMPRESARIAL;
                    break;                                       
            }
            return new Terreno(codigoPropiedad,precio,metros,profundidad,ubicacion,tipoterreno);                                        
        }                            
        //Casa
        else
        {
            do
            {
                System.out.println("Número de Pisos: ");
                numP = sc.nextLine();
            }
            while(!ValidatorUtils.validarNumero(numP));
            numPisos = Integer.parseInt(numP);
            
            do
            {
                System.out.println("Número de Habitaciones: ");
                numH = sc.nextLine();
            }
            while(!ValidatorUtils.validarNumero(numH));
            numHab = Integer.parseInt(numH);
            return new Casa(codigoPropiedad, precio, metros, profundidad, ubicacion,numPisos,numHab);                                        
        }         
    }
    
    /**
     * Se registra el agente con el cual se hará la venta
     * @param sc     
     * @return  
     */        
    public static AgenteVentas registrarAgente(Scanner sc)
    {
        System.out.println("\n Registro de Agente");
                          
        String usuario,contrasenia,codigoAgente,nombre,cedula,correo = "";  
        
        System.out.println("\nUsuario: ");
        usuario = sc.nextLine();
        System.out.println("Contraseña: ");
        contrasenia = sc.nextLine();
        System.out.println("Codigo Agente: ");
        codigoAgente = sc.nextLine();
        System.out.println("Nombre: ");
        nombre = sc.nextLine();
        System.out.println("Cedula: ");
        cedula = sc.nextLine();
        System.out.println("Correo: ");
        correo = sc.nextLine();                        
        return new AgenteVentas(usuario, contrasenia,codigoAgente, nombre, cedula, correo);
    }
    
    /**
     * Se genera un reporte actualizado con las ventas y su debido contacto con el agente
     * @param finicio
     * @param Ffinal 
     */
    public void reporteContactoyVentas(String finicio,String Ffinal){
        
    }

}
