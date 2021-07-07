package modelo;

import java.time.LocalDateTime;

public class Consulta {
    private LocalDateTime fechaConsulta;
    private Cliente cliente;
    private Propiedad propiedad;
    private String comentario;
    private boolean pregunta;
    private boolean respondida;
    
    public Consulta()
    {
        
    }

    public Consulta(Cliente cliente, Propiedad propiedad,String comentario) {
        this.fechaConsulta = LocalDateTime.now();
        this.cliente = cliente;
        this.propiedad = propiedad;
        this.comentario = comentario;
        this.pregunta = false;
        this.respondida = false;
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
    
    public boolean isPregunta() {
        return pregunta;
    }

    public void setPregunta(boolean pregunta) {
        this.pregunta = pregunta;
    }
    
    public boolean isRespondida() {
        return respondida;
    }

    public void setRepondida(boolean respondida) {
        this.respondida = respondida;
    }
    
    public String getComentario()
    {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
    
}
