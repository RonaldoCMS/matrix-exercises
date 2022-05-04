package com.example.controller;

import com.example.model.Campionato;
import com.example.model.Squadra;

public class MainController {
    private Campionato campionato;
    
    MainController() {
        campionato = new Campionato();

        // aggiunta di una squadra al campionato
        // aggiunta di un giocatore a una squadra
        // trovare tutti i giocatori per un ruolo X
        // trovare tutte le squadre che giocano in stadi con capienza maggiore di Y

    }

    public void handleAddNewSquadra(Squadra squadra) {
       for(int i = 0; i < campionato.getSquadre().length; i++) {
           if(campionato.getSquadre()[i] == null) {
               campionato.getSquadre()[i] = squadra;
               return;
           }
       }
    }

    /* public void handleNewGiocatore(Squadra squadra, Giocatore giocatore) {
        for(Squadra mysquadra : campionato.getSquadre()) {
            if(squadra.getNome().equalsIgnoreCase(squadra.getNome()))  {
                mysquadra.set
            }
        }
    } */

}
