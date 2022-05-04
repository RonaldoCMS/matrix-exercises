package com.example.model;

public class Campionato {
    private int id;
    private String nome;
    private Squadra[] squadre;

    public Campionato() {
        Calciatore[] cNapoli = {
            new Calciatore("Napoli", "1", Ruolo.ATTACCANTE), 
            new Calciatore("Napoli", "2", Ruolo.CENTROCAMPISTA), 
            new Calciatore("Napoli", "3", Ruolo.CENTROCAMPISTA), 
            new Calciatore("Napoli", "4", Ruolo.ATTACCANTE), 
            new Calciatore("Napoli", "5", Ruolo.DIFENSORE), 
        };
        Stadio sNapoli = new Stadio("diego Armando Maradona", 60000);
        Squadra napoli = new Squadra("Napoli", cNapoli, sNapoli);

        Calciatore[] cMilan= {
            new Calciatore("Milan", "6", Ruolo.ATTACCANTE), 
            new Calciatore("Milan", "7", Ruolo.CENTROCAMPISTA), 
            new Calciatore("Milan", "8", Ruolo.ATTACCANTE), 
            new Calciatore("Milan", "9", Ruolo.DIFENSORE), 
            new Calciatore("Milan", "10", Ruolo.PORTIERE), 
        };
        Stadio sMilan = new Stadio("diego Armando Maradona", 80000);
        Squadra milan = new Squadra("Napoli", cNapoli, sNapoli);

        Calciatore[] cInter= {
            new Calciatore("Inter", "11", Ruolo.ATTACCANTE), 
            new Calciatore("Inter", "12", Ruolo.CENTROCAMPISTA), 
            new Calciatore("Inter", "13", Ruolo.ATTACCANTE), 
            new Calciatore("Inter", "14", Ruolo.DIFENSORE), 
            new Calciatore("Inter", "15", Ruolo.PORTIERE), 
        };
        Stadio sInter = new Stadio("diego Armando Maradona", 80000);
        Squadra inter = new Squadra("Napoli", cNapoli, sNapoli);

        squadre = new Squadra[20];
        squadre[0] = napoli;
        squadre[1] = milan;
        squadre[2] = inter;
    }

    public Squadra[] getSquadre() {
        return squadre;
    }
}
