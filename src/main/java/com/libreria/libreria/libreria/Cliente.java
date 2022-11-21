package com.libreria.libreria.libreria;

public class Cliente {
    private String nombreCliente, rutCliente, correoCliente;

    public Cliente(String nombreCliente, String rutCliente, String correoCliente){
        this.nombreCliente = nombreCliente;
        this.rutCliente = rutCliente;
        this.correoCliente = correoCliente;
    }

    public String getNombreCliente(){
        return nombreCliente;
    }
    public void setNombreCliente(){
        this.nombreCliente = nombreCliente;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }
}
