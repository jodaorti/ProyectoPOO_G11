
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Cliente;
import modelo.Sistema;
import modelo.Usuario;
import tipos.Enum.tipoUsuario;
import utils.ClassUtils;
import utils.MenuUtils;


public class Main {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);        
        int opcion = 0;
        boolean salirSistema = false;
        Sistema sistema = new Sistema();
        sistema = ClassUtils.cargarInformacionDefecto();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario usuarioSistema = null;        
        Cliente clienteNuevo = new Cliente();
        
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
                        MenuUtils.mostrarMenuPorUsuario(usuarioSistema);                        
                        cargarOpcionesUsuario(usuarioSistema.getTipo(), sc);
                    
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
                
            case AGENTE:    
                do 
                {                    
                    op = sc.nextLine();             
                }
                while(!op.equalsIgnoreCase("1") && !op.equalsIgnoreCase("2") && !op.equalsIgnoreCase("3"));
            
            default:
                do 
                {                    
                    op = sc.nextLine();             
                }
                while(!op.equalsIgnoreCase("1") && !op.equalsIgnoreCase("2") && 
                      !op.equalsIgnoreCase("3") && !op.equalsIgnoreCase("4"));                        
        }
    }
}
