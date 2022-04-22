package com.mazzo.model.mazzo;

import java.util.Random;

import com.mazzo.model.carta.CartaAbs;
import com.mazzo.model.carta.CartaNapoletana;
import com.mazzo.model.seme.SemeNapoletano;

public class MazzoNapoletano extends Mazzo {

    private static int MAX_CARTE = 40;

    public MazzoNapoletano() {
        super(new CartaNapoletana[MAX_CARTE], MAX_CARTE);
    }

    @Override
    public CartaAbs[] mescola() {
        this.carte = new CartaAbs[MAX_CARTE];
        for(int i = 0; i < SemeNapoletano.values().length; i++) {
            for(int j = 0; j < 10; j++) {
                carte[i * 10 + j] = new CartaNapoletana(j+1, SemeNapoletano.values()[i]);
            }
        }
        return carte;
    }
    
}
