package modelo;

import java.util.ArrayList;

public class Sistema {
    ArrayList<AgenteVentas> listaAgentes;
    ArrayList<Cliente> listaClientes;
    ArrayList<Propiedad> listaPropiedades;
    
    public Sistema()
    {
        this.listaAgentes  = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaPropiedades = new ArrayList<>();
    }

    public ArrayList<AgenteVentas> getListaAgentes() {
        return listaAgentes;
    }

    public void agregarAgente(AgenteVentas agente) {
        this.listaAgentes.add(agente);
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void agregarCliente(Cliente cliente) {
        this.listaClientes.add(cliente);
    }

    public ArrayList<Propiedad> getListaPropiedades() {
        return listaPropiedades;
    }

    public void setListaPropiedades(Propiedad propiedad) {
        this.listaPropiedades.add(propiedad);
    }            
}
