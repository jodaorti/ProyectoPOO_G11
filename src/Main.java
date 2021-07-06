
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Administrador;
import modelo.AgenteVentas;
import modelo.Cliente;
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
    
    static Cliente clienteActual;
    static AgenteVentas agenteActual;
    static Administrador administradorActual;
    static Propiedad propiedadActual;
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);        
        int opcion = 0;
        boolean salirSistema = false;
        sistema = new Sistema();
        sistema = ClassUtils.cargarInformacionDefecto();
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario usuarioSistema = null;        
        
        clienteNuevo        = new Cliente();        
        agenteNuevo         = new AgenteVentas();
        propiedadNueva      = new Propiedad();
        agenteActual        = new AgenteVentas();
        administradorActual = new Administrador();
        clienteActual       = new Cliente();
        propiedadActual     = new Propiedad();
        
        do 
        {   
            usuarios.clear();
            usuarios.addAll(sistema.getListaAgentes());
            usuarios.addAll(sistema.getListaClientes());
            usuarios.addAll(sistema.getListaAdministradores());
            opcion = MenuUtils.generarMenuPrincipal(sc);
            
            switch(opcion)
            {
                case 1:
                    usuarioSistema = MenuUtils.verificarEIngresarUsuario(usuarios, sc);
                    if(usuarioSistema == null)                  
                        System.out.println("El usuario no esta registrado\n\n");   
                    else
                    {
                        MenuUtils.mostrarMenuPorUsuario(usuarioSistema);                        
                        cargarOpcionesUsuario(usuarioSistema, sc);
                    }
                    break;

                case 2:
                    clienteNuevo = Cliente.registrarCliente(sc);
                    sistema.agregarCliente(clienteNuevo);
                        
                    break;
                case 3:
                    salirSistema = true;
                    break;
            }
            
            
        }
        while(!salirSistema);
        
        
    }
    
    public static void cargarOpcionesUsuario(Usuario usuario, Scanner sc)
    {               
        String op = "";  
        tipoUsuario tipo = usuario.getTipo();
        switch(tipo)
        {
            case CLIENTE:  
                do
                {
                    op = sc.nextLine();
                }
                while(!op.equalsIgnoreCase("1") && !op.equalsIgnoreCase("2") && 
                      !op.equalsIgnoreCase("3") && !op.equalsIgnoreCase("4") && !op.equalsIgnoreCase("5"));
                clienteActual = Cliente.getCliente(sistema.getListaClientes(), usuario);
                
                switch(op)
                {
                    case "1":
                        
                        
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "4":
                        break;
                    case "5":
                        System.out.println("Regresar a menu principal");
                        break;                        
                }
                                                
            case AGENTE:    
                do 
                {                    
                    op = sc.nextLine();             
                }
                while(!op.equalsIgnoreCase("1") && !op.equalsIgnoreCase("2") && !op.equalsIgnoreCase("3"));
                agenteActual = AgenteVentas.getAgenteVentas(sistema.getListaAgentes(), usuario);                
                switch(op)
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
                        break;
                        
                    case "3":
                        System.out.println("Regresar a menu principal");
                        break;                                          
                }
                
            
            //Administrador
            default:
                do 
                {                    
                    op = sc.nextLine();             
                }
                while(!op.equalsIgnoreCase("1") && !op.equalsIgnoreCase("2") && 
                      !op.equalsIgnoreCase("3") && !op.equalsIgnoreCase("4")); 
                administradorActual = Administrador.getAdministrador(sistema.getListaAdministradores(), usuario);
                switch(op)
                {
                    case "1":
                        propiedadNueva = Administrador.registrarPropiedad(sc);
                        sistema.agregarPropiedad(propiedadNueva);                        
                        break;
                        
                    case "2":
                        agenteNuevo = Administrador.registrarAgente(sc);
                        sistema.agregarAgente(agenteNuevo);                                                
                        break;
                        
                    case "3":
                        
                        break;
                    case "4":
                        System.out.println("Regresar a menu principal");
                        break;                    
                }
        }
    }
}
