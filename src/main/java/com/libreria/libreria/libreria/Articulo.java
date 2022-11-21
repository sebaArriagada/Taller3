package com.libreria.libreria.libreria;

public class Articulo {
    private String nombreArticulo, tipoArticulo;
    private double pesoArticulo;
    private int precioArticulo;

    public Articulo(String nombreArticulo, String tipoArticulo, double pesoArticulo, int precioArticulo) {
        this.nombreArticulo = nombreArticulo;
        this.tipoArticulo = tipoArticulo;
        this.pesoArticulo = pesoArticulo;
        this.precioArticulo = precioArticulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public String getTipoArticulo() {
        return tipoArticulo;
    }

    public void setTipoArticulo(String tipoArticulo) {
        this.tipoArticulo = tipoArticulo;
    }

    public double getPesoArticulo() {
        return pesoArticulo;
    }

    public void setPesoArticulo(double pesoArticulo) {
        this.pesoArticulo = pesoArticulo;
    }

    public int getPrecioArticulo() {
        return precioArticulo;
    }

    public void setPrecioArticulo(int precioArticulo) {
        this.precioArticulo = precioArticulo;
    }
}
