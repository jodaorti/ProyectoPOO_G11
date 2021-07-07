/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import tipos.Enum;
import tipos.Enum.tipoTerreno;
import tipos.Enum.tipoUsuario;
import utils.ClassUtils;
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
    
     /** Obtener el agente de Ventas del listado.
     * @param administradores
     * @param us
     * @return 
    */
    public static Administrador getAdministrador(ArrayList<Administrador> administradores, Usuario us)
    {
        for(Administrador administrador : administradores)
        {
            if(us.getUsuario().trim().equalsIgnoreCase(administrador.getUsuario().trim()) &&
               us.getContrasenia().trim().equalsIgnoreCase(administrador.getContrasenia().trim()))
                return administrador;
        }
        return null;
    }
    
    /**
     * Se registra la propiedad en el sistema.
     * @param agentes
     * @param sc
     * @return 
     */
    public static Propiedad registrarPropiedad(ArrayList<AgenteVentas> agentes, Scanner sc)
    {
        System.out.println("\n Registro de Propiedad");        
        String tipoP,tipoPropiedad,codigoPropiedad,descripcion, prc,mts,prf,provincia,
               ciudad,direccion,sector,numP,numH = "";
        
        double precio,metros,profundidad = 0;
        int numPisos,numHab = 0;
        
        do 
        {
            System.out.println("\nSeleccione Terreno(1) o Casa(2): ");
            tipoP = sc.nextLine();
        }
        while(!tipoP.equalsIgnoreCase("1") && !tipoP.equalsIgnoreCase("2"));
        do
        {
            System.out.println("Código de Propiedad: ");
            codigoPropiedad = sc.nextLine();
        }
        while(codigoPropiedad.trim().isEmpty());        
        System.out.println("Descripción: ");
        descripcion = sc.nextLine();        
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
        
        String agenteSeleccionado = "";
        if(agentes.isEmpty())
        {
            System.out.println("No hay agentes disponibles...");
            return null;
        }
        
        int i,agenteNumero;   
        String format = " %1$-2s %2$-4s\n"; 
        do
        {
            do 
            {
                System.out.println("\n Listado de Agentes");
                i = 1;
                for(AgenteVentas agente : agentes)  
                {                    
                    System.out.format(format,i,"Código: "+agente.getCodigoAgente(),
                                               "Nombre: "+agente.getNombre());
                                                                       
                    i++;
                }
                System.out.println("\nEscoger un agente: ");
                agenteSeleccionado = sc.nextLine();
            }
            while(!ValidatorUtils.validarNumero(agenteSeleccionado));
            agenteNumero = Integer.parseInt(agenteSeleccionado) - 1;
        }
        while(agenteNumero < 0 || agenteNumero > agentes.size());
        AgenteVentas agenteNuevo = agentes.get(agenteNumero);
                       
        //Terreno
        if(tipoP.equalsIgnoreCase("1"))
        {
            String tipoTer = "";
             do 
            {
                System.out.println("\nSeleccione tipo de Terreno COMERCIAL(1), VIVIENDA(2), EMPRESARIAL(3): ");
                tipoTer = sc.nextLine();
            }
            while(!tipoTer.equalsIgnoreCase("1") && !tipoTer.equalsIgnoreCase("2") && !tipoTer.equalsIgnoreCase("3"));            
            
             
            tipoTerreno tipoterreno;
            switch(tipoTer)
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
            System.out.println("El terreno se registró correctamente...\n");
            return new Terreno(codigoPropiedad,descripcion, precio,metros,profundidad,ubicacion,tipoterreno,agenteNuevo);                                        
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
            System.out.println("La casa se registró correctamente...\n");
            return new Casa(codigoPropiedad,descripcion, precio, metros, profundidad, ubicacion,numPisos,numHab,agenteNuevo);                                        
            
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
     * @param agentes     
     * @param sc     
     */
    public static boolean reporteContactoyVentas(ArrayList<AgenteVentas> agentes,Scanner sc){
        System.out.println("\n Reporte Contactos y Ventas ");        
        
        String rangoFecha = "";
        do
        {
            System.out.println("Ingrese Rango Fechas (dd/MM/YYYY-dd/MM/YYYY)");
            rangoFecha = sc.nextLine();
        }
        while(!ValidatorUtils.validarRangoFechas(rangoFecha));
        String[] fechaPart = rangoFecha.split("-");
        String fechaD = fechaPart[0];
        String fechaH = fechaPart[1];
        ArrayList<Venta> ventas = new ArrayList<>();
        for(AgenteVentas agente : agentes)     
            ventas.addAll(agente.getVentas());        
        
        LocalDateTime fechaDesde = ClassUtils.StringToDateTime(fechaD+" 00:00:00");
        LocalDateTime fechaHasta = ClassUtils.StringToDateTime(fechaH+" 23:59:59");
                    
        String format = " %1$-10s %2$-20s %3$-30s\n";
        System.out.format(format,"Agente","Numero Ventas","Numero de Respuestas");
        for(AgenteVentas agente : agentes)
        {
            int numVentas = Venta.getCantidadVentasAgenteFiltrada(agente.getVentas(), fechaDesde, fechaHasta);
            System.out.format(format,agente.getCodigoAgente(),numVentas,0);
        }    
        
        String op = "";
        
        System.out.println("Ingrese código del agente quiere mas detalles o vacio  para regresar:");
        op = sc.nextLine();
        if(op.equalsIgnoreCase(""))
            return true;
        else
        {
            ArrayList<Consulta> consultasPorAgente = new ArrayList<>();
            
            for(Consulta consulta : consultasPorAgente)
            {
                
            }
        }
        return false;
    }
   
}
