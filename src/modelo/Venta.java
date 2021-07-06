package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import utils.ClassUtils;

public class Venta {
    
    private Propiedad propiedad;
    private Cliente cliente;
    private LocalDateTime fechaVenta;
    
    public Venta()
    {
        
    }

    public Venta(Propiedad propiedad, Cliente cliente) {
        this.propiedad = propiedad;
        this.cliente = cliente;
        this.fechaVenta = LocalDateTime.now();
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @Override
    public String toString() {
        return "Propiedad: "+propiedad.getCodigoPropiedad()+" Cliente: "+cliente.getNombre()+" Fecha: "+ClassUtils.dateTimeToString(fechaVenta);
    }
    
    
    
    /**
    * Cargar la información de las ventas y mostrarlas en un listado.     
     * @param ventas          
    */
    public static void mostrarListadoVentas(ArrayList<Venta> ventas)
    {                        
        String format = " %1$-2s %2$-4s %3$-10s %4$-10s\n";    
        int i;                
        System.out.println("\n Listado de Ventas");
        i = 1;
        for(Venta venta : ventas)  
        {                  
            System.out.format(format,i,"Código: "+venta.propiedad.getCodigoPropiedad(),
                                       "Cliente: "+venta.cliente.getNombre(),
                                       "Fecha: "+ClassUtils.dateTimeToString(venta.fechaVenta));                                               
            i++;
        }                
    }
}
