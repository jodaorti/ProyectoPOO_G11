
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Cliente;
import modelo.Sistema;
import modelo.Usuario;
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
        usuarios.addAll(sistema.getListaAgentes());
        usuarios.addAll(sistema.getListaClientes());
        
        Cliente clienteNuevo = new Cliente();
        
        do 
        {   
            usuarios.clear();
            usuarios.addAll(sistema.getListaAgentes());
            usuarios.addAll(sistema.getListaClientes());
            
            opcion = MenuUtils.generarMenuPrincipal(sc);
            
            switch(opcion)
            {
                case 1:
                    usuarioSistema = MenuUtils.verificarEIngresarUsuario(usuarios, sc);
                    if(usuarioSistema == null)
                        System.out.println("El usuario no esta registrado\n\n");
                    else
                        
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
}
