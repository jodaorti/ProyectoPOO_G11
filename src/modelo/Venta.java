package modelo;

import java.time.LocalDate;

public class Venta {
    
    private Propiedad propiedad;
    private Cliente cliente;
    private LocalDate fechaVenta;
    
    public Venta()
    {
        
    }

    public Venta(Propiedad propiedad, Cliente cliente, LocalDate fechaVenta) {
        this.propiedad = propiedad;
        this.cliente = cliente;
        this.fechaVenta = fechaVenta;
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

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    
    
}
