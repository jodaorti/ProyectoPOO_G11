package modelo;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 59399
 */
public class Cliente extends Usuario {
    String nombre;
    String cedula;
    String correo;
    String fechaNacimiento;
    /*
    Muestra al cliente las propiedades en venta con o sin filtros de precio,tipo,ciudad o sector aplicados
    */
    public void consultrarPropiedades(){
        
    }
    public void buzonConsultas(){
        
    }
    public void crearAlerta(){
        
    }
    public ArrayList simularPrestamo(double costo,double i,int n,String sistema){
        ArrayList<Double> cuotas= new ArrayList<>();
        return cuotas;  
    }
    
    
}
