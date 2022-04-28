package com.example.model;

public class Gomma extends Articolo {

    private Forma forma;

    public Gomma(String modello, String marca, double costo, double prezzo, Forma forma) {
        super(modello, marca, costo, prezzo);
        this.forma = forma;
    }

    public Forma getForma() {
        return forma;
    }

    public void setForma(Forma forma) {
        this.forma = forma;
    }
    
}
