package com.mazzo.model.gioco;

import java.util.ArrayList;
import java.util.List;

import com.mazzo.model.Giocatore;
import com.mazzo.model.mazzo.Mazzo;

abstract public class Gioco {
    protected Mazzo mazzo;
    protected Giocatore[] giocatori;
    protected int currentGiocatori = 0;

    public Gioco(Mazzo mazzo) {
        giocatori = new Giocatore[4];
        this.mazzo = mazzo;
    }

    public void addGiocatore(Giocatore giocatore){
        giocatori[currentGiocatori] = giocatore;
        currentGiocatori++;
    }

    public void setMazzo(Mazzo mazzo) {
        this.mazzo = mazzo;
    }

    public Giocatore getGiocatoreFromUsername(String username) {
        for(Giocatore giocatore : giocatori) {
            if(giocatore.getNome() == username) {
                return giocatore;
            }
        }
        return null;
    }
    

    public Giocatore[] getGiocatori() {
        return giocatori;
    }

    public Mazzo getMazzo() {
        return mazzo;
    }

} 
