
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Administrador;
import modelo.AgenteVentas;
import modelo.Cliente;
import modelo.Propiedad;
import modelo.Sistema;
import modelo.Usuario;
import tipos.Enum.tipoUsuario;
import utils.ClassUtils;
import utils.MenuUtils;


public class Main 
{
    static Sistema sistema;
    static Cliente clienteNuevo;
    static AgenteVentas agenteNuevo;
    static Propiedad propiedadNueva;
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);        
        int opcion = 0;
        boolean salirSistema = false;
        sistema = new Sistema();
        sistema = ClassUtils.cargarInformacionDefecto();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario usuarioSistema = null;        
        clienteNuevo = new Cliente();        
        agenteNuevo = new AgenteVentas();
        propiedadNueva = new Propiedad();
        
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
                        cargarOpcionesUsuario(usuarioSistema.getTipo(), sc);
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
    
    public static void cargarOpcionesUsuario(tipoUsuario tipo, Scanner sc)
    {               
        String op = "";  
        switch(tipo)
        {
            case CLIENTE:  
                do
                {
                    op = sc.nextLine();
                }
                while(!op.equalsIgnoreCase("1") && !op.equalsIgnoreCase("2") && 
                      !op.equalsIgnoreCase("3") && !op.equalsIgnoreCase("4") && !op.equalsIgnoreCase("5"));
                
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
                switch(op)
                {
                    case "1":
                        break;
                    case "2":
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
