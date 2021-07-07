package modelo;

import java.time.LocalDateTime;

public class Consulta {
    private LocalDateTime fechaConsulta;
    private Cliente cliente;
    private Propiedad propiedad;
    private String comentario;
    
    public Consulta()
    {
        
    }

    public Consulta(Cliente cliente, Propiedad propiedad,String comentario) {
        this.fechaConsulta = LocalDateTime.now();
        this.cliente = cliente;
        this.propiedad = propiedad;
        this.comentario = comentario;
    }

    public LocalDateTime getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(LocalDateTime fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }
    
    
    
}
