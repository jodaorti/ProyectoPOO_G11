package modelo;

import tipos.Enum.tipoPropiedad;
import tipos.Enum.tipoTerreno;

public class Terreno extends Propiedad
{
    private tipoTerreno tipoT;
    
    public Terreno()
    {
        
    }

    public Terreno(String codigoPropiedad,String descripcion, double precio, double metrosAncho, 
                   double profundidad, Ubicacion ubicacion, tipoTerreno tipoT) {
        super(codigoPropiedad,descripcion, precio, metrosAncho, profundidad, ubicacion,tipoPropiedad.TERRENO);
        this.tipoT = tipoT;
    }

    public tipoTerreno getTipoT() {
        return tipoT;
    }

    public void setTipoT(tipoTerreno tipoT) {
        this.tipoT = tipoT;
    }
    
    
    
}
