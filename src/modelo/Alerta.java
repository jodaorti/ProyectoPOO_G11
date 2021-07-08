package modelo;

import java.util.ArrayList;
import tipos.Enum.tipoPropiedad;
import utils.ClassUtils;

public class Alerta {
            
    private double precio;
    private double metrosAncho;
    private double profundidad;
    private String provincia;
    private String ciudad;
    private String sector;
    private tipoPropiedad tipoP;    
    private Cliente cliente;
    
    public Alerta()
    {
        
    }
    
    public Alerta(double precio, double metrosAncho, double profundidad, String provincia, String ciudad, String sector, tipoPropiedad tipoP,Cliente cliente) {
        this.precio = precio;
        this.metrosAncho = metrosAncho;
        this.profundidad = profundidad;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.sector = sector;
        this.tipoP = tipoP;
        this.cliente = cliente;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getMetrosAncho() {
        return metrosAncho;
    }

    public void setMetrosAncho(double metrosAncho) {
        this.metrosAncho = metrosAncho;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public tipoPropiedad getTipoP() {
        return tipoP;
    }

    public void setTipoP(tipoPropiedad tipoP) {
        this.tipoP = tipoP;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setClente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
    * Cargar el indice de la propiedad Cargada
     * @param alertas
     * @param propiedad          
    */
    public static void verificarAlertasPorEnviar(ArrayList<Alerta> alertas, Propiedad propiedad)
    {
        ArrayList<Alerta> alertFiltroTipo = new ArrayList<>();
        for(Alerta alerta : alertas)
        {
            if(alerta.getTipoP() == propiedad.getTipo())
                alertFiltroTipo.add(alerta);
        }
        
        if(alertFiltroTipo.isEmpty())
            return;
                        
        ArrayList<Alerta> alertFiltroPrecio = new ArrayList<>();
        for(Alerta alerta : alertFiltroTipo)
        {
            if(alerta.getPrecio() > 0 && alerta.getPrecio() == propiedad.getPrecio())
                alertFiltroPrecio.add(alerta);
        }
        
        if(alertFiltroPrecio.isEmpty())
            alertFiltroPrecio = alertFiltroTipo;            
        
        ArrayList<Alerta> alertFiltroMetros = new ArrayList<>();
        for(Alerta alerta : alertFiltroPrecio)
        {
            if(alerta.getMetrosAncho()> 0 && alerta.getMetrosAncho()== propiedad.getMetrosAncho())
                alertFiltroMetros.add(alerta);
        }
        
        if(alertFiltroMetros.isEmpty())
            alertFiltroMetros = alertFiltroPrecio;
        
        ArrayList<Alerta> alertFiltroProfundidad = new ArrayList<>();
        for(Alerta alerta : alertFiltroMetros)
        {
            if(alerta.getProfundidad()> 0 && alerta.getProfundidad()== propiedad.getProfundidad())
                alertFiltroProfundidad.add(alerta);
        }
        
        if(alertFiltroProfundidad.isEmpty())
            alertFiltroProfundidad = alertFiltroMetros;
        
        ArrayList<Alerta> alertFiltroProvincia = new ArrayList<>();
        for(Alerta alerta : alertFiltroProfundidad)
        {
            if(alerta.getProvincia().trim().isEmpty() && 
                    alerta.getProvincia().equalsIgnoreCase(propiedad.getUbicacion().getProvincia()))
                alertFiltroProvincia.add(alerta);
        }
        
        if(alertFiltroProvincia.isEmpty())
            alertFiltroProvincia = alertFiltroProfundidad;
        
        ArrayList<Alerta> alertFiltroCiudad = new ArrayList<>();
        for(Alerta alerta : alertFiltroProvincia)
        {
            if(alerta.getCiudad().trim().isEmpty() && 
                    alerta.getCiudad().equalsIgnoreCase(propiedad.getUbicacion().getCiudad()))
                alertFiltroCiudad.add(alerta);
        }
        
        if(alertFiltroCiudad.isEmpty())
            alertFiltroCiudad = alertFiltroProvincia;
        
        ArrayList<Alerta> alertFiltroSector = new ArrayList<>();
        for(Alerta alerta : alertFiltroProvincia)
        {
            if(alerta.getSector().trim().isEmpty() && 
                    alerta.getSector().equalsIgnoreCase(propiedad.getUbicacion().getSector()))
                alertFiltroSector.add(alerta);
        }
        
        if(alertFiltroSector.isEmpty())
            alertFiltroSector = alertFiltroCiudad;
        
        Alerta alerta = alertFiltroSector.get(0);
        try{
            ClassUtils.enviarMail(alerta.getCliente().getCorreo(),"Alerta de Propiedad registrada","Se ha generado una alerta sobre la  propiedad creada");
        }
        catch(Exception ex)
        {
            
        }
        
    }
    
}
