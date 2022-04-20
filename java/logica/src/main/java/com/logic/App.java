package com.logic;

import java.security.Provider;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        int[] array = new int[] {-2,3,-4,5,-2,3,-4,3,4,502,-203,4,304,304,59304,30495,4593,21,21,12,-2,-5,-4};
        es10();
    }

    //Scrivere un programma che stampi a video i primi dieci numeri interi
    public static void es1() {
        final int NUMERO = 10;
        for(int i=1; i <=NUMERO; i++) {
            System.out.println(i);
        }
    }

    // 10
    // 9
    // 8
    // 7
    // 6
    // 5
    // 4
    // 3
    // 2
    // 1
    // 0

    public static void es2() {
        final int NUMERO = 10;
        for(int i=NUMERO; i >= 0; i--) {
            System.out.println(i);
        }
    }

    //Scrivere un programma che stampi a video i primi dieci
    // interi pari compresi fra 20 e 0, partendo da 20.
    public static void es3() {
        final int NUMERO = 20;
        //0 - 20 -> 10
        for(int i = NUMERO; i>=0; i--) {
            if(i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    //Scrivere un programma che stampi le tabellina del numero dato come argomento
    public static void es4() {
        int tabellina = 93874739;
        for(int i = 0; i <= 10; i++) {
            System.out.println(tabellina + " x " + i + " = " + tabellina * i);
        }
    }

    //Stampare a video la seguente figura:
    public static void es5() {
        for(int i = 6; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void es6() {
        for(int i = 1; i <= 6; i+=1) {
            for(int j = 0; j < i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
    /*
    1      654321
    12      54321
    123      4321
    1234      321
    12345      21
    123456      1 
    */
    public static void es7() {
        for(int i = 1; i <= 6; i++) {

            for(int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            System.out.print("\t");
            
            for(int j = 7 - i; j >= 1; j--) {
                System.out.print(j);
            }

            System.out.println();
        }
    }
    //Scrivere un programma che stampi i primi 100 elementi della successione di Fibonacci.
    //
    public static void es8() {
        long valore = 0;
        long lastValore = 0;
        long nextValore = 1;

        for (int i = 0; i < 10; i++) {
            valore = nextValore + lastValore;
            System.out.println(valore);
            lastValore = nextValore;
            nextValore = valore;
        }

    }

    public static void es9() {
        Esame esame = new Esame(24, 8);
        Studente studente = new Studente("Pippo", "Baudo", "5 A INF", esame);
        String promozione = studente.getEsame().promozione();
        System.out.println(promozione);
        System.out.println("E stato fatto " + studente.getEsame().giorno);

    }

    public static void es10() {
        String giocatore1 = "sasso";
        String giocatore2 = "carta";

        if(haVinto(giocatore1, giocatore2) == Risultato.VITTORIA) {
            System.out.println(giocatore1 + " ha vinto!");
        } else if(haVinto(giocatore1, giocatore2) == Risultato.SCONFITTA) {
            System.out.println(giocatore1 + " ha perso!");
        } else {
            System.out.println(giocatore1 + " pareggio!");
        }

    }

    public static Risultato haVinto(String g1, String g2) {
        if(g1.equalsIgnoreCase("carta") && g2.equalsIgnoreCase("forbice")) 
            return Risultato.SCONFITTA;
        
        if(g1.equalsIgnoreCase("forbice") && g2.equalsIgnoreCase("sasso")) 
            return Risultato.SCONFITTA;

        if(g1.equalsIgnoreCase("sasso") && g2.equalsIgnoreCase("carta")) 
            return Risultato.SCONFITTA;
        
        if(g1.equalsIgnoreCase(g2)) 
            return Risultato.PAREGGIO;

        return Risultato.VITTORIA;
    }
    public enum Risultato {
        VITTORIA, PAREGGIO, SCONFITTA
    }

    public enum Stato {
        ITALIA, GERMANIA, FRANCIA, BELGIO
    }

    public enum Giorno {
        LUNEDI, MARTEDI, MERCOLEDI
    }

}
