package com.example.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Cartoleria {
    private ArrayList<Articolo> articoli;

    public Cartoleria(ArrayList<Articolo> articoli) {
        this.articoli = articoli;
    }

    public Cartoleria() {
        this.articoli = new ArrayList<Articolo>();
    }

    public void addArticolo(Articolo articolo) {
        articoli.add(articolo);
    }

    public void printArticoli() {
       Iterator<Articolo> iterator = articoli.iterator();
       while(iterator.hasNext()) {
        Articolo articolo = iterator.next();
        System.out.println(articolo.toString());
       }
    }

    public void printCostiTotaliArticoli() {
        for(Articolo articolo : articoli) {
            System.out.println(articolo.getCosto());
        }
    }

    public double printRicaviTotaliArticoli() {
        double totale = 0;
        for(Articolo articolo : articoli) {
            totale += articolo.getCosto() - articolo.getPrezzo();
        }
        return totale;
    }

    public void cleanMagazino() {
        articoli.clear();
    }
}
