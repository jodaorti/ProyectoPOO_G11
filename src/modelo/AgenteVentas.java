package modelo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import tipos.Enum.tipoUsuario;
import utils.ClassUtils;
import utils.OrdenadorFechaConsultas;
import utils.ValidatorUtils;

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
    
    /**
     * Se muestran las consultas que ha realizado el cliente sobre las propiedades         
     * @param agente
     * @param cliente
     * @param consultas
     * @param propiedades
     * @param sc
     * @return 
     */       
    public static Consulta revisarBuzonConsultas(AgenteVentas agente, ArrayList<Consulta> consultas,ArrayList<Propiedad> propiedades, Scanner sc)
    {
        System.out.println("\n Revisar Buzón ");  
        String tipo,rangoPrecio,ciudad,sector;
        String format = " %1$-10s %2$-20s %3$-10s %4$-10s %5$-50s\n";
        System.out.format(format,"Fecha","Código Propiedad","Nombre Cliente","Pregunta","Estado");
        consultas.sort(new OrdenadorFechaConsultas());
        ArrayList<Cliente> clientes = new ArrayList<>();
        Cliente cliente;
        for(Consulta consulta : consultas)
        {
            if(consulta.isPregunta() && 
               consulta.getPropiedad().getAgenteVentas().getCodigoAgente().
                       equalsIgnoreCase(agente.getCodigoAgente()))
            {
             System.out.format(format,ClassUtils.dateTimeToString(consulta.getFechaConsulta()),
                                     consulta.getPropiedad().getCodigoPropiedad(),
                                     consulta.getCliente().getNombre(),
                                     consulta.getComentario(),
                                     consulta.isRespondida() ? "Respondido" : "Esperando");
             
             cliente = consulta.getCliente();
             if(!clientes.contains(cliente))
                clientes.add(cliente);             
            }
        }
        
        String codigoPropiedad = "";        
        System.out.println("\nIngrese el código de la propiedad (o vacío para regresar):");
        codigoPropiedad = sc.nextLine();            
        String persona;
        if(!codigoPropiedad.trim().isEmpty())
        {
            String fecha;
            for(Consulta consulta : consultas)
            {
                if(consulta.getPropiedad().getCodigoPropiedad().equalsIgnoreCase(codigoPropiedad))  
                {
                    fecha = ClassUtils.dateTimeToString(consulta.getFechaConsulta());
                    System.out.println(fecha+":"+(consulta.isPregunta() ? "Cliente:" : "Agente:")+consulta.getComentario());               
                }                                      
            }
            
            String pregunta = "";
            do
            {
                System.out.println("\nDesea realizar agregar un pregunta o regresar (si/no)");
                pregunta = sc.nextLine();
            }
            while(!pregunta.equalsIgnoreCase("SI") && !pregunta.equalsIgnoreCase("NO"));
            if(pregunta.equalsIgnoreCase("SI"))
            {
                int i,clienteNumero;  
                String clienteSeleccionado = "";
                do
                {
                    do 
                    {
                        System.out.println("\n Listado de Clientes");
                        i = 1;
                        for(Cliente c : clientes)  
                        {                    
                            System.out.format(format,i,"Código: "+c.getNombre());                                                                       
                            i++;
                        }
                        System.out.println("\nEscoger un cliente: ");
                        clienteSeleccionado = sc.nextLine();
                    }
                    while(!ValidatorUtils.validarNumero(clienteSeleccionado));
                    clienteNumero = Integer.parseInt(clienteSeleccionado) - 1;
                }
                while(clienteNumero < 0 || clienteNumero > clientes.size());
                Cliente clienteNuevo = clientes.get(clienteNumero);
                
                
                Propiedad propConsulta = Propiedad.getPropiedadPorListado(propiedades, codigoPropiedad);
                String comentario = "";
                System.out.println("\nIngrese la respuesta:");                
                comentario = sc.nextLine();
                if(!comentario.trim().isEmpty())                
                    return new Consulta(clienteNuevo, propConsulta,comentario);                
            }
            return null;
                        
        }
        return null;
    } 
    
}
