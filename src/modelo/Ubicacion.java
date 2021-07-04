package modelo;

public class Ubicacion {
    private String provincia;
    private String ciudad;
    private String direccion;
    private String sector;
    
    public Ubicacion()
    {
        
    }

    public Ubicacion(String provincia, String ciudad, String direccion, String sector) {
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.sector = sector;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
    
    
}
