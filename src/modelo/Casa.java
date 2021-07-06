package modelo;

import tipos.Enum.tipoPropiedad;

public class Casa extends Propiedad
{
    private int numPisos;
    private int numHabitaciones;
    
    public Casa()
    {
        
    }

    public Casa(String codigoPropiedad,String descripcion, double precio, double metrosAncho, 
                double profundidad, Ubicacion ubicacion, int numPisos, int numHabitaciones) {
        super(codigoPropiedad,descripcion, precio, metrosAncho, profundidad, ubicacion,tipoPropiedad.CASA);
        this.numPisos = numPisos;
        this.numHabitaciones = numHabitaciones;
    }

    public int getNumPisos() {
        return numPisos;
    }

    public void setNumPisos(int numPisos) {
        this.numPisos = numPisos;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }
    
    
    
}
