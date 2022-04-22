package com.mazzo.controller;

import com.mazzo.model.Giocatore;
import com.mazzo.model.gioco.CartaAlta;

public class MainController {
    private CartaAlta gioco;

    public MainController() {
        gioco = new CartaAlta();
    }

    public void handleAddGiocatore(Giocatore giocatore) {
        gioco.addGiocatore(giocatore);
    }

    public void handleEstraiCarta(String username) {
        gioco.estraeCartaGiocatoreFromUsername(username);
    }

    public Giocatore[] getGiocatori() {
        return gioco.getGiocatori();
    }


    public void handleMescolaCarte() {
        gioco.getMazzo().estraiCartaEdElimina();
    }



    public Giocatore getGiocatoreFromUsername(String username) {
        return gioco.getGiocatoreFromUsername(username);
    }


    public Giocatore getVincitore() {
        return gioco.getVincitore();
    }

    public String getAllCarte() {
        return gioco.getAllCarte();
    }

}
