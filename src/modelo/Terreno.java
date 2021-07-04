package modelo;

import tipos.Enum.tipoTerreno;

public class Terreno extends Propiedad
{
    private tipoTerreno tipoT;
    
    public Terreno()
    {
        
    }

    public Terreno(String codigoPropiedad, double precio, double metrosAncho, 
                   double profundidad, Ubicacion ubicacion, tipoTerreno tipoT) {
        super(codigoPropiedad, precio, metrosAncho, profundidad, ubicacion);
        this.tipoT = tipoT;
    }

    public tipoTerreno getTipoT() {
        return tipoT;
    }

    public void setTipoT(tipoTerreno tipoT) {
        this.tipoT = tipoT;
    }
    
    
    
}
