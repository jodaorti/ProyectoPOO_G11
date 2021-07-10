package modelo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import tipos.Enum.tipoPropiedad;
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

    @Override
    public String toString() {
        return "Nombre: " + nombre ;
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
    
    /**
    * Cargar la información de los clientes y mostrarlas en un listado.     
     * @param clientes
     * @param sc
     * @return 
    */
    public static Cliente mostrarListadoClientes(ArrayList<Cliente> clientes, Scanner sc)
    {                        
        String op = "";
        int opcion = 0;
        int i;        
        do
        {
            do 
            {
                System.out.println("\n Listado de Clientes");
                i = 1;
                for(Cliente cli : clientes)  
                {
                    System.out.println(i+". "+cli);        
                    i++;
                }
                System.out.println("Escoger un cliente: ");
                op = sc.nextLine();
            }
            while(!ValidatorUtils.validarNumero(op));
            opcion = Integer.parseInt(op) - 1;
        }
        while(opcion < 0 || opcion > clientes.size());
        return clientes.get(opcion);        
    }
    
     /**
     * Se genera un reporte con las propiedades a la venta mediante filtros     
     * @param cliente
     * @param propiedades
     * @param sc
     * @return 
     */
    public static Consulta consultaPropiedades(Cliente cliente,ArrayList<Propiedad> propiedades,Scanner sc)
    {
        System.out.println("\n Consulta de Propiedades ");        
        String tipo,rangoPrecio,ciudad,sector;
        tipoPropiedad tipoP;
        do
        {
            System.out.println("Tipo (1)Terreno, (2)Casa: ");
            tipo = sc.nextLine();            
        }
        while(!tipo.equalsIgnoreCase("1") && !tipo.equalsIgnoreCase("2") && !tipo.equalsIgnoreCase(""));                                
        do
        {
            System.out.println("Rango Precio (xxxxx-xxxxx)");
            rangoPrecio = sc.nextLine();
        }
        while(!ValidatorUtils.validarRangoPrecios(rangoPrecio));        
        String[] precioPart = rangoPrecio.split("-");
        String precioD = precioPart[0];
        String precioH = precioPart[1];
        
        System.out.println("Ciudad: ");
        ciudad = sc.nextLine();
        
        System.out.println("Sector: ");
        sector = sc.nextLine();
        
        if(tipo.equalsIgnoreCase("1"))
            tipoP = tipoPropiedad.TERRENO;
        else
            tipoP = tipoPropiedad.CASA;
        
        ArrayList<Propiedad> propiedadesFiltradas = Propiedad.getListaPropiedadesFiltradas(
                                                    propiedades,tipoP,Double.parseDouble(precioD),
                                                    Double.parseDouble(precioH),ciudad, sector);
        
        if(propiedadesFiltradas.isEmpty())
        {
            System.out.println("No exsten datos que mostrar\n");
            return null;
        }
        
        System.out.println("Lista de Propiedades Consultadas");
        String format = " %1$-10s %2$-20s %3$-10s %4$-10s %5$-50s %6$-5s\n";
        System.out.format(format,"código","descripción","precio","Tamaño","ubicación","consultada");
        
        for(Propiedad propiedad : propiedadesFiltradas)
        {
            System.out.format(format,propiedad.getCodigoPropiedad(),
                                     propiedad.getDescripcion(),
                                     propiedad.getPrecio(),
                                     propiedad.getMetrosAncho()*propiedad.getProfundidad()+"M2",
                                     propiedad.getUbicacion().toString(),
                                     propiedad.isConsultada() ? "SI" :"NO");
        }
        
        String codigo = "";        
        System.out.println("\nIngrese el código de la propiedad desea mas detalle (o vacío para regresar):");
        codigo = sc.nextLine();    
        
        if(!codigo.trim().isEmpty())
        {
            Propiedad propConsulta = Propiedad.getPropiedadPorListado(propiedadesFiltradas, codigo);
            if(propConsulta == null)
                System.out.println("No existe propiedad con ese código");
            else
            {
                System.out.println("Detalles de la propiedad:");
                System.out.println(propConsulta);
            }
            
            String consultaSolicitada = "";                
            do
            {
                System.out.println("\nDesea realizar consulta (si/no):");
                consultaSolicitada = sc.nextLine();
            }
            while(!consultaSolicitada.equalsIgnoreCase("SI") && !consultaSolicitada.equalsIgnoreCase("NO"));
            if(consultaSolicitada.equalsIgnoreCase("SI"))
            {
                String comentario = "";
                System.out.println("\nIngrese su consulta:");                
                comentario = sc.nextLine();
                if(!comentario.trim().isEmpty())                
                    return new Consulta(cliente, propConsulta,comentario);                
            }
            return null;
        }
        return null;
    }
    
    /**
     * Se muestran las consultas que ha realizado el cliente sobre las propiedades         
     * @param cliente
     * @param consultas
     * @param propiedades
     * @param sc
     * @return 
     */       
    public static Consulta buzonDeConsultas(Cliente cliente, ArrayList<Consulta> consultas,ArrayList<Propiedad> propiedades, Scanner sc)
    {
        System.out.println("\n Buzón de Consultas ");  
        String tipo,rangoPrecio,ciudad,sector;
        String format = " %1$-20s %2$-20s %3$-20s %4$-30s %5$-10s\n";
        System.out.format(format,"Fecha","Código Propiedad","Nombre Agente","Pregunta","Estado");
        consultas.sort(new OrdenadorFechaConsultas());
        for(Consulta consulta : consultas)
        {
            if(consulta.isPregunta())
            {
             System.out.format(format,ClassUtils.dateTimeToString(consulta.getFechaConsulta()),
                                     consulta.getPropiedad().getCodigoPropiedad(),
                                     consulta.getPropiedad().getAgenteVentas().getNombre(),
                                     consulta.getComentario(),
                                     consulta.isRespondida() ? "Respondido" : "Esperando");
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
                Propiedad propConsulta = Propiedad.getPropiedadPorListado(propiedades, codigoPropiedad);
                String comentario = "";
                System.out.println("\nIngrese la pregunta:");                
                comentario = sc.nextLine();
                if(!comentario.trim().isEmpty())                
                    return new Consulta(cliente, propConsulta,comentario);                
            }
            return null;
                        
        }
        return null;
    }        
    
    /**
     * Se crean las alertas cuando se registre una propiedad con esos parametros
     * @param cliente          
     * @param sc
     * @return 
     */
    public static Alerta crearAlerta(Cliente cliente,Scanner sc)
    {
        System.out.println("\n Registro de Alerta");        
        String tipoP,codigoPropiedad,descripcion, prc,mts,prf,provincia,
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
        System.out.println("Sector: ");
        sector = sc.nextLine();  
        tipoPropiedad t;
        if(tipoP.equalsIgnoreCase("1"))                        
           t = tipoPropiedad.TERRENO;
        else            
            t = tipoPropiedad.CASA;
            
        return new Alerta(precio, metros, profundidad, provincia, ciudad, sector,t,cliente);                   
           
    }
    
    /**
     * Se realiza la simulación de prestamos por cualquiera de los dos metodos
     * @param propiedades
     * @param sc     
     */
    public static void simularPrestamo(ArrayList<Propiedad> propiedades, Scanner sc)
    {                
        String format = " %1$-2s %2$-4s %3$-10s %4$-10s %5$-10s %6$-10s %7$-10s %8$-10s\n";        
        String op = "";
        int opcion = 0;
        int i;        
        do
        {
            do 
            {
                System.out.println("\n Listado de Propiedades");
                i = 1;
                for(Propiedad prop : propiedades)  
                {
                    if(!prop.isVendida())
                    {
                        System.out.format(format,i,"Código: "+prop.getCodigoPropiedad(),
                                                   "Descripcion: "+prop.getDescripcion(),
                                                   "Precio: "+prop.getPrecio(),
                                                   "Metros Ancho: "+prop.getMetrosAncho(),
                                                   "Profundidad: "+prop.getProfundidad(),
                                                   "Tipo: "+prop.getTipo(),
                                                   "Vendida: NO");                                                
                    }
                    i++;
                }
                System.out.println("\nEscoger una propiedad: ");
                op = sc.nextLine();
            }
            while(!ValidatorUtils.validarNumero(op));
            opcion = Integer.parseInt(op) - 1;
        }
        while(opcion < 0 || opcion > propiedades.size());
        Propiedad propiedadSeleccionada =  propiedades.get(opcion); 
        String metodoCalculo,interes,anios = "";
        double interesMetodo,anioMetodo = 0;
        do 
        {
            System.out.println("\nSeleccione método de calculo FRANCES(1) o ALEMAN(2): ");
            metodoCalculo = sc.nextLine();
        }
        while(!metodoCalculo.equalsIgnoreCase("1") && !metodoCalculo.equalsIgnoreCase("2"));  
        do
        {
            System.out.println("Interes: ");
            interes = sc.nextLine();
        }
        while(!ValidatorUtils.validarNumero(interes));
        interesMetodo = Double.parseDouble(interes);
        do
        {
            System.out.println("Años: ");
            anios = sc.nextLine();
        }
        while(!ValidatorUtils.validarNumero(anios));
        anioMetodo = Double.parseDouble(anios);
        
        if(metodoCalculo.equalsIgnoreCase("1"))
        {
            CalculadoraPrestamoFrances prestamoFrances = new CalculadoraPrestamoFrances();
            prestamoFrances.calcularPrestamo(propiedadSeleccionada.getPrecio(),interesMetodo,anioMetodo);
        }                                        
        else
        {
            CalculadoraPrestamoAleman prestamoAleman = new CalculadoraPrestamoAleman();
            prestamoAleman.calcularPrestamo(propiedadSeleccionada.getPrecio(),interesMetodo,anioMetodo);
        }
    }
        
}
