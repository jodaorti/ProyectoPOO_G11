package modelo;

import java.util.ArrayList;

public class Sistema {
    private ArrayList<AgenteVentas> listaAgentes;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Propiedad> listaPropiedades;
    private ArrayList<Administrador> listaAdministradores;
    private ArrayList<Consulta> listaConsultas;
    private ArrayList<Alerta> listaAlertas;
    
    public Sistema()
    {
        this.listaAgentes  = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaAdministradores = new ArrayList<>();
        this.listaPropiedades = new ArrayList<>();     
        this.listaConsultas = new ArrayList<>();   
        this.listaAlertas = new ArrayList<>();
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
    
    public ArrayList<Administrador> getListaAdministradores() {
        return listaAdministradores;
    }

    public void agregarAdministrador(Administrador administrador) {
        this.listaAdministradores.add(administrador);
    }

    public ArrayList<Propiedad> getListaPropiedades() {
        return listaPropiedades;
    }

    public void agregarPropiedad(Propiedad propiedad) {
        this.listaPropiedades.add(propiedad);
    }           
    
    public ArrayList<Consulta> getListaConsultas() {
        return listaConsultas;
    }

    public void agregarConsulta(Consulta consulta) {
        this.listaConsultas.add(consulta);
    }
    
    public ArrayList<Alerta> getListaAlertas() {
        return listaAlertas;
    }

    public void agregarAlerta(Alerta alerta) {
        this.listaAlertas.add(alerta);
    }
}
