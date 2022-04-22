package com.mazzo.view;

import java.util.Scanner;

import com.mazzo.controller.MainController;
import com.mazzo.model.Giocatore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MainController controller = new MainController();
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================== GIOCO CARTA ALTA! ========================");
        Thread.sleep(600);
        System.out.println("= è un gioco che prevede 2+ giocatori, ognuno pescherà una carta e");
        Thread.sleep(600);
        System.out.println("= chi avrà la carta più alta vince!\n");
        Thread.sleep(600);
        System.out.println("= Clicca qualsiasi tasto per iniziare. \t");
        Thread.sleep(600);
        scanner.nextLine();

        boolean continua = true;
       
        int numeroGiocatori = numeroGiocatori(scanner);
        for(int i = 0; i < numeroGiocatori; i++) {
            Thread.sleep(600);
            System.out.print("= inserisci username giocatore " + i + " ->\t");
            String username = scanner.next();
            System.out.println();
            controller.handleAddGiocatore(new Giocatore(username));
        }
        while(continua) {
            System.out.println("Ok ora estraiamo le carte...");
            Thread.sleep(600);
            for(Giocatore giocatore : controller.getGiocatori()) {
                if(giocatore != null) {

                    System.out.println(giocatore.getNome() + " ha estratto");
                    Thread.sleep(600);
                    controller.handleEstraiCarta(giocatore.getNome());
                }
            }

            System.out.println("Bene, ora scopriamo le carte...!");
            cmd_cls();
            Thread.sleep(600);
            System.out.println(controller.getAllCarte());

            System.out.println("HA VINTO -> " + controller.getVincitore().toString());
            Thread.sleep(600);

            System.out.print("Continuare? (y/n) -> \t");
            String scelta = scanner.next();
            System.out.println("scelta -> " + scelta);
            Thread.sleep(600);
        while(scelta.equalsIgnoreCase("n") && scelta.equalsIgnoreCase("y")) {
            System.out.println("Errore... Continuare? (y/n)");
            scelta = scanner.next();
        }
        if(scelta.equalsIgnoreCase("n")) {
            continua = false;
        }
        cmd_cls();
    }
        System.out.println("Arrivederci!");
    }

    private static void cmd_cls() {
        for(int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    private static int numeroGiocatori(Scanner scanner) {
        System.out.println("Quanti giocatori siete?");
        int numeroGiocatori;
        try {
             numeroGiocatori = scanner.nextInt();
             if(numeroGiocatori <= 0 || numeroGiocatori >= 5){
                 System.out.println("Attenzione! Massimo 4 giocatori!");
                 return numeroGiocatori(scanner);
             }
            return numeroGiocatori;
        } catch(Exception e) {
            System.out.println("attenzione! devi inserire un numero!");
            return numeroGiocatori(scanner);
        }
    }
}
