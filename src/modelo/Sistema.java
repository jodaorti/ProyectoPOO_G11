package modelo;

import java.util.ArrayList;

public class Sistema {
    ArrayList<AgenteVentas> listaAgentes;
    ArrayList<Cliente> listaClientes;
    ArrayList<Propiedad> listaPropiedades;
    
    public Sistema()
    {
        
    }

    public ArrayList<AgenteVentas> getListaAgentes() {
        return listaAgentes;
    }

    public void setListaAgentes(AgenteVentas agente) {
        this.listaAgentes.add(agente);
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(Cliente cliente) {
        this.listaClientes.add(cliente);
    }

    public ArrayList<Propiedad> getListaPropiedades() {
        return listaPropiedades;
    }

    public void setListaPropiedades(Propiedad propiedad) {
        this.listaPropiedades.add(propiedad);
    }            
}
