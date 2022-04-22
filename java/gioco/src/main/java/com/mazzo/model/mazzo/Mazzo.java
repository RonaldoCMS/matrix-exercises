package com.mazzo.model.mazzo;

import java.util.Random;

import com.mazzo.model.carta.CartaAbs;

abstract public class Mazzo {
    final private int MAX_CARTE;
    protected CartaAbs[] carte;

    public Mazzo(CartaAbs[] carte, int MAX) {
        this.carte = carte;
       
        carte = mescola();
        MAX_CARTE = MAX;
    }

    public void stampaMazzo() {
        for(CartaAbs carta : carte) {
            System.out.println(carta.toString());
        }
    }

    public CartaAbs estraiCartaEdElimina() {
        
    Random random = new Random();
    int value = random.nextInt(MAX_CARTE);
    CartaAbs cartaEstratta = carte[value];
    if(cartaEstratta == null) return estraiCartaEdElimina();
    else {
        carte[value] = null;
    }
    return cartaEstratta;
}
    
        // Random random = new Random();
        // int value = random.nextInt(MAX_CARTE);
        // CartaAbs cartaEstratta = carte[value];
        // if(cartaEstratta == null) return estraiCartaEdElimina();
        // else {
        //     carte[value] = null;
        // }
        // return cartaEstratta;
    

    public CartaAbs estraiCarta() {
        return carte[new Random().nextInt(MAX_CARTE)];
    }


    
    abstract public CartaAbs[] mescola();

    /*private CartaAbs generaCarta(int valore, Seme seme) {
        return new Carta(valore);
    } */

}
