package com.example.controller;

import java.util.Scanner;

import com.example.model.Articolo;
import com.example.model.Cartoleria;
import com.example.model.Colore;
import com.example.model.Forma;
import com.example.model.Gomma;
import com.example.model.Penna;

public class CartoleriaController {
    private Scanner scanner = new Scanner(System.in);
    private boolean continuare = true;
    private Cartoleria cartoleria = new Cartoleria();

    public void scaricaMagazzino() {
        cartoleria.cleanMagazino();
        System.out.println("Magazzino pulito");
    }

    public void stampaRicavi() {
        cartoleria.printRicaviTotaliArticoli();
    }

    public void stampaArticoli() {
        cartoleria.printArticoli();
    }

    public void stampaCosti() {
        cartoleria.printCostiTotaliArticoli();
    }

    public void caricaNuovoArticolo() {
        System.out.println("1. Penna");
        System.out.println("2. Gomma");
        int tipo = scanner.nextInt();
        
        System.out.print("Inserisci modello -> \t");
        String modello = scanner.nextLine();

        System.out.print("Inserisci marca -> \t");
        String marca = scanner.nextLine();

        System.out.print("Inserisci costo -> \t");
        double costo = scanner.nextDouble();

        System.out.print("Inserisci prezzo -> \t");
        double prezzo = scanner.nextDouble();

        Articolo newArticolo;
        if(tipo == 1) {
            System.out.println("1. BLU");
            System.out.println("2. NERO");
            System.out.println("3. ROSSO");
            int tipoval = scanner.nextInt();
            newArticolo = new Penna(modello, marca, costo, prezzo, Colore.values()[tipoval-1]);
        } else {
            System.out.println("1. Rettangolare");
            System.out.println("2. Quadrata");
            int tipoval = scanner.nextInt();
            newArticolo = new Gomma(modello, marca, costo, prezzo, Forma.values()[tipoval-1]);
        }
        cartoleria.addArticolo(newArticolo);
    }

    public boolean continuare() {
        System.out.println("continuare? [y/n]");
        String value = scanner.next();

        if(value.equals("y")) return true;
        return false;
    }

    public boolean isContinuare() {
        return continuare;
    }

    public void setContinuare(boolean continuare) {
        this.continuare = continuare;
    }
}
