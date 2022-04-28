package com.example.view;

import java.util.Scanner;

import com.example.controller.CartoleriaController;

public class MainView {
    private Scanner scanner = new Scanner(System.in);
    private CartoleriaController controller = new CartoleriaController();

    public void view() {
        Darshboard();
        scelta();
    }

    public void Darshboard() {
        System.out.println("0. per uscire");
        System.out.println("1. caricare un nuovo articolo in magazzino");
        System.out.println("2. per stampare articoli presenti al magazzino");
        System.out.println("3. per stampare i costi totali degli articoli presenti");
        System.out.println("4. per stampare i ricavi totali");
        System.out.println("5. per scaricare il magazzino");
    }

    public void scelta() {
        System.out.print("Inserisci scelta ->\t");
        int scelta = scanner.nextInt();
        while(controller.isContinuare()) {
            switch(scelta) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    controller.caricaNuovoArticolo();
                    break;
                case 2:
                    controller.stampaArticoli();
                    break;
                case 3:
                    controller.stampaCosti();
                    break;
                case 4:
                    controller.stampaRicavi();
                    break;
                case 5:
                    controller.scaricaMagazzino();
                    break;
            }
            controller.continuare();
        }   
    }
}
