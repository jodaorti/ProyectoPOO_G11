package modelo;

public class CalculadoraPrestamoAleman extends CalculadoraPrestamo{
    
    @Override
    public void calcularPrestamo(double capital, double interes, double tiempo) {
        double i = interes / 100;
        
        double cuota,interesMonto,capitalAmortizado,capitalPendiente,amortizacion,anualidad;
        int numeroCuota;                        

        cuota = capital * (i/(1-Math.pow(1-i,tiempo)));                        
        String format = " %1$-10s %2$-10s %3$-15s %4$-10s %5$-20s %6$-15s\n";
        System.out.println("\n Tabla de Amortización Método Alemán");        
        System.out.format(format,"No. Cuota","Anualidad","Amortización","Interes","Capital Amortizado","Cap. Pendiente");
                        
        interesMonto = 0;
        capitalAmortizado = 0;
        capitalPendiente = 0;
        amortizacion = 0; 
        anualidad = 0;
        for(numeroCuota = 0; numeroCuota <= tiempo ; numeroCuota++)
        {
            if(numeroCuota == 0)
            {
                interesMonto = capital*i;
                anualidad = interesMonto;
                amortizacion = 0;
                capitalAmortizado = 0;
                capitalPendiente = capital;                
            }                                               
            else
            {
                anualidad = cuota;
                capitalPendiente = (capitalPendiente - anualidad)/(1-i);
                capitalAmortizado = capital - capitalPendiente;
                interesMonto = capitalPendiente * i;
                amortizacion = anualidad - interesMonto;                
            }
            System.out.format(format,numeroCuota,
                    String.format("%.2f",anualidad),
                    String.format("%.2f",amortizacion),
                    String.format("%.2f",interesMonto),
                    String.format("%.2f",capitalAmortizado),
                    String.format("%.2f",capitalPendiente));
        }  
    }
    
}
