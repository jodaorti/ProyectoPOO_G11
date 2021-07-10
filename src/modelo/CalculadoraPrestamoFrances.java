package modelo;

public class CalculadoraPrestamoFrances extends CalculadoraPrestamo{
    
    
    /**
    * Genera la simulación de la tabla de amortización de un préstamo por 
    * el método frances.          
     * @param capital
     * @param interes
     * @param tiempo
    */
    @Override
    public void calcularPrestamo(double capital, double interes, double tiempo) {
        double i = interes / 100;
        
        double cuota,interesMonto,reduccionCapital = 0;
        int numeroCuota;                        

        cuota = capital * (i/(1-Math.pow(1+i,-tiempo)));                        
        String format = " %1$-10s %2$-10s %3$-10s %4$-15s %5$-10s\n";
        System.out.println("\n Tabla de Amortización Método Frances");        
        System.out.format(format,"No. Cuota","Cuota","Interes","Red. Capital","Cap. Adeudado");
                        
        for(numeroCuota = 1; numeroCuota <= tiempo ; numeroCuota++)
        {
            interesMonto = capital * i;
            reduccionCapital = cuota - interesMonto;
            capital = capital - reduccionCapital;
            System.out.format(format,numeroCuota,String.format("%.2f",cuota),String.format("%.2f",interesMonto),String.format("%.2f",reduccionCapital) ,String.format("%.2f",capital));
        }               
    }    
}
