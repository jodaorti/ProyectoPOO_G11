
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Administrador;
import modelo.AgenteVentas;
import modelo.Alerta;
import modelo.Cliente;
import modelo.Consulta;
import modelo.Propiedad;
import modelo.Sistema;
import modelo.Usuario;
import modelo.Venta;
import tipos.Enum.tipoUsuario;
import utils.ClassUtils;
import utils.MenuUtils;


public class Main 
{
    static Sistema sistema;
    static Cliente clienteNuevo;
    static AgenteVentas agenteNuevo;
    static Propiedad propiedadNueva;
    static Consulta consultaNueva;
    static Alerta alertaNueva;
    
    static Cliente clienteActual;
    static AgenteVentas agenteActual;
    static Administrador administradorActual;
    static Propiedad propiedadActual;
    static Alerta alertaActual;
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);   
        
        int opcion = 0;        
        boolean salirSistema = false;
        boolean salirMenuCliente = false;
        boolean salirMenuAgente = false;
        boolean salirMenuAdministrador = false;
        
        sistema = new Sistema();
        sistema = ClassUtils.cargarInformacionDefecto();
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        Usuario usuarioSistema = new Usuario();
        clienteNuevo           = new Cliente();        
        agenteNuevo            = new AgenteVentas();
        propiedadNueva         = new Propiedad();
        consultaNueva          = new Consulta();
        alertaNueva            = new Alerta();
        
        agenteActual           = new AgenteVentas();
        administradorActual    = new Administrador();
        clienteActual          = new Cliente();
        propiedadActual        = new Propiedad();        
        alertaActual           = new Alerta();
        
        while(!salirSistema)
        {
            salirMenuCliente = false;
            salirMenuAgente = false;
            salirMenuAdministrador = false;
            
            usuarios.clear();
            usuarios.addAll(sistema.getListaAgentes());
            usuarios.addAll(sistema.getListaClientes());
            usuarios.addAll(sistema.getListaAdministradores());
            opcion = MenuUtils.generarMenuPrincipal(sc);
            
            switch(opcion)
            {
                //Verificar Credenciales
                case 1:
                    usuarioSistema = MenuUtils.verificarEIngresarUsuario(usuarios, sc);
                    if(usuarioSistema == null)                  
                        System.out.println("El usuario no esta registrado\n\n");   
                    else                                                                  
                        cargarOpcionesUsuario(salirMenuCliente,salirMenuAgente,salirMenuAdministrador, usuarioSistema, sc);                    
                    break;

                //Crear Cliente nuevo
                case 2:
                    clienteNuevo = Cliente.registrarCliente(sc);
                    sistema.agregarCliente(clienteNuevo);                        
                    break;
                
                //salir de Sistema 
                case 3:
                    salirSistema = true;
                    break;
            }
        }
    }
    
    public static void cargarOpcionesUsuario(boolean salirCliente,boolean salirAgente, boolean salirAdministrador, Usuario usuario, Scanner sc)
    {               
        String opcion = "";  
        tipoUsuario tipo = usuario.getTipo();
        switch(tipo)
        {
            case CLIENTE: 
                while(!salirCliente)
                {                      
                    MenuUtils.mostrarMenuPorUsuario(usuario); 
                    opcion = sc.nextLine();
                    if(!opcion.equalsIgnoreCase("1") && !opcion.equalsIgnoreCase("2") && 
                       !opcion.equalsIgnoreCase("3") && !opcion.equalsIgnoreCase("4") && 
                       !opcion.equalsIgnoreCase("5"))
                        System.out.println("La opción escogida es incorrecta.");                                                        
                    
                    clienteActual = Cliente.getCliente(sistema.getListaClientes(), usuario);                
                    switch(opcion)
                    {
                        case "1":
                            consultaNueva = Cliente.consultaPropiedades(clienteActual,sistema.getListaPropiedades(), sc);
                            if(consultaNueva != null)
                            {
                                int i = Propiedad.getPropiedadIndice(sistema.getListaPropiedades(),consultaNueva.getPropiedad().getCodigoPropiedad());
                                if(i != -1)
                                {
                                    consultaNueva.setPregunta(true);
                                    sistema.getListaPropiedades().get(i).setConsultada(true);                                    
                                    sistema.agregarConsulta(consultaNueva);
                                }
                                
                            }                            
                            break;
                            
                        case "2":
                            consultaNueva = Cliente.buzonDeConsultas(clienteActual,sistema.getListaConsultas(),sistema.getListaPropiedades(), sc);
                            if(consultaNueva != null)
                            {
                                int i = Propiedad.getPropiedadIndice(sistema.getListaPropiedades(),consultaNueva.getPropiedad().getCodigoPropiedad());
                                if(i != -1)
                                {
                                    consultaNueva.setPregunta(true);
                                    sistema.getListaPropiedades().get(i).setConsultada(true);
                                    sistema.agregarConsulta(consultaNueva);
                                }
                                
                            }                            
                            break;                                                        
                        
                        case "3":                            
                            alertaNueva = Cliente.crearAlerta(clienteActual, sc);
                            if(alertaNueva != null)
                            {
                                sistema.agregarAlerta(alertaNueva);
                                System.out.println("Alerta agregada correctamente.");
                            }
                            break;
                        
                        case "4":
                            Cliente.simularPrestamo(sistema.getListaPropiedades(), sc);
                            break;
                                                
                        case "5":
                            System.out.println("\nRegresando...\n");
                            salirCliente = true;                            
                            break;                        
                    }
                }
                break;
            
            case AGENTE:    
                while(!salirAgente)
                {
                    MenuUtils.mostrarMenuPorUsuario(usuario); 
                    System.out.println("Escoger una opción :" );
                    opcion = sc.nextLine();
                    if(!opcion.equalsIgnoreCase("1") && !opcion.equalsIgnoreCase("2") && 
                       !opcion.equalsIgnoreCase("3"))
                        System.out.println("La opción escogida es incorrecta."); 
                    
                    agenteActual = AgenteVentas.getAgenteVentas(sistema.getListaAgentes(), usuario);                      
                    
                    switch(opcion)
                    {
                        case "1":
                            
                            break;
                    
                        case "2":
                            propiedadActual = Propiedad.mostrarListadoPropiedades(sistema.getListaPropiedades(),sc);                        
                            clienteActual = Cliente.mostrarListadoClientes(sistema.getListaClientes(),sc); 
                            propiedadActual.setVendida(true);
                            agenteActual.agregarVenta(new Venta(propiedadActual, clienteActual));                        
                            System.out.println("Venta agregada correctamente.");
                            Venta.mostrarListadoVentas(agenteActual.getVentas());
                            System.out.println("\nRegresando...\n");
                            break;
                        
                        case "3":
                            System.out.println("\nRegresando...\n");
                            salirAgente = true;
                            break;                                        
                    }                    
                }
                break;
                
            //Administrador
            default:
                while(!salirAdministrador)
                {
                    MenuUtils.mostrarMenuPorUsuario(usuario); 
                    System.out.println("Escoger una opción :" );
                    opcion = sc.nextLine(); 
                    if(!opcion.equalsIgnoreCase("1") && !opcion.equalsIgnoreCase("2") && 
                       !opcion.equalsIgnoreCase("3") && !opcion.equalsIgnoreCase("4"))
                        System.out.println("La opción escogida es incorrecta.");
                    
                    administradorActual = Administrador.getAdministrador(sistema.getListaAdministradores(), usuario);
                    
                    switch(opcion)
                    {
                        //Registrar Propiedad
                        case "1":
                            propiedadNueva = Administrador.registrarPropiedad(sistema.getListaAgentes(), sc);
                            Alerta.verificarAlertasPorEnviar(sistema.getListaAlertas(), propiedadNueva);
                            sistema.agregarPropiedad(propiedadNueva);                        
                            break;

                        //Registrar Agente
                        case "2":
                            agenteNuevo = Administrador.registrarAgente(sc);
                            sistema.agregarAgente(agenteNuevo);                                                
                            break;

                        //Reporte Contactos y Ventas
                        case "3":
                            Administrador.reporteContactoyVentas(sistema.getListaAgentes(), sc);
                            break;
                            
                        case "4":
                            System.out.println("\nRegresando...\n");
                            salirAdministrador = true;
                            break;
                    }
                }
                break;
        }
    }
}
