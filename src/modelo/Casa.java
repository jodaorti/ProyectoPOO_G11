package modelo;

public class Casa extends Propiedad
{
    private int numPisos;
    private int numHabitaciones;
    
    public Casa()
    {
        
    }

    public Casa(String codigoPropiedad, double precio, double metrosAncho, 
                double profundidad, Ubicacion ubicacion, int numPisos, int numHabitaciones) {
        super(codigoPropiedad, precio, metrosAncho, profundidad, ubicacion);
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
