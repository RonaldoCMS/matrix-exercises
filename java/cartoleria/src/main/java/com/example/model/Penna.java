package com.example.model;

public class Penna extends Articolo{

    private Colore colore;

    public Penna(String modello, String marca, double costo, double prezzo, Colore colore) {
        super(modello, marca, costo, prezzo);
        this.colore = colore;
    }

    public Colore getColore() {
        return colore;
    }

    public void setColore(Colore colore) {
        this.colore = colore;
    }
    
}
