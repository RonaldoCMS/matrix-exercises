package com.mazzo.model.gioco;

import com.mazzo.model.Giocatore;
import com.mazzo.model.carta.CartaAbs;
import com.mazzo.model.carta.CartaNapoletana;
import com.mazzo.model.mazzo.MazzoNapoletano;

public class CartaAlta extends Gioco{

    public CartaAlta() {
        super(new MazzoNapoletano());
    }

    public void estraeCartaGiocatoreFromUsername(String username) {
        getGiocatoreFromUsername(username).setCartaScelta(mazzo.estraiCartaEdElimina());
    }

    public Giocatore getVincitore() {




        int maxValue = -1;
        Giocatore[] giocatoriVittoria = new Giocatore[4];
        Giocatore[] giocatoriTemp = new Giocatore[4];
        int indexGiocatori = 0;
        int totGiocatori = 0;
        for(Giocatore giocatore : giocatori) {
           if(giocatore != null) { 
                int currentValue = giocatore.getCartaScelta().getValore();
                if (currentValue > maxValue) {
                    maxValue = currentValue;
                    if(giocatoriTemp[1] != null) {
                        giocatoriTemp = new Giocatore[4];
                        indexGiocatori = 0;
                    }
                    giocatoriTemp[indexGiocatori] = giocatore;
                    indexGiocatori++;
                    continue;
                }
                if(currentValue == maxValue) {
                    giocatoriTemp[indexGiocatori] = giocatore;
                    indexGiocatori++;
                    continue;
                }
            }
        }



        totGiocatori = indexGiocatori;
        if(giocatori[1] != null) {
            indexGiocatori = 0;
            int maxSeme = -1;
            for(Giocatore semeGiocatore : giocatoriTemp) {
                if(semeGiocatore != null) {
                    CartaNapoletana carta = (CartaNapoletana) semeGiocatore.getCartaScelta();
                    int currentValueSeme = carta.getSeme().getValue();
                    if(currentValueSeme > maxSeme) {
                        maxSeme = currentValueSeme;
                        giocatoriVittoria[0] = semeGiocatore;
                        
                        continue;
                    } 
                }
            }
        } else {
            giocatoriVittoria = giocatoriTemp;
        }
        totGiocatori = indexGiocatori;
        return giocatoriVittoria[0];
    }

   
    public String getConfrontaSemi(CartaAbs carta1, CartaAbs carta2) {
        carta1 = (CartaNapoletana) carta1;
        int valueSeme1 = ((CartaNapoletana) carta1).getSeme().getValue();
        int valueSeme2 = ((CartaNapoletana) carta2).getSeme().getValue();

        if(valueSeme1 > valueSeme2) {
            return "VINCE GIOCATORE 1 PER SEME";
        } else if(valueSeme1 == valueSeme2) {
            return "PAREGGIO";
        } else 
            return "VINCE GIOCATORE 2 PER SEME"; 
    }

    public String getAllCarte() {
        String str = "";

        for(Giocatore giocatore : giocatori) {
            str.concat(giocatori.toString()).concat("\n");
        }

        return str;

    }


} 
