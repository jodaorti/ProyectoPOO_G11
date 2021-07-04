
import java.util.Scanner;
import utils.MenuUtils;


public class Main {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);        
        int opcion = 0;
        opcion = MenuUtils.generarMenuPrincipal(sc);
    }
}
