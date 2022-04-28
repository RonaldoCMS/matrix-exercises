package com.example.model;

public class Articolo {
    private String modello;
    private String marca;
    private double costo;
    private double prezzo;


    public Articolo(String modello, String marca, double costo, double prezzo) {
        this.modello = modello;
        this.marca = marca;
        this.costo = costo;
        this.prezzo = prezzo;
    }


    public String getModello() {
        return modello;
    }


    public void setModello(String modello) {
        this.modello = modello;
    }


    public String getMarca() {
        return marca;
    }


    public void setMarca(String marca) {
        this.marca = marca;
    }


    public double getCosto() {
        return costo;
    }


    public void setCosto(double costo) {
        this.costo = costo;
    }


    public double getPrezzo() {
        return prezzo;
    }


    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "[Articolo]";
    }
    

    
}
