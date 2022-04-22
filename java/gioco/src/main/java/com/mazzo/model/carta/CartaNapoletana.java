package com.mazzo.model.carta;

import com.mazzo.model.seme.SemeNapoletano;

public class CartaNapoletana extends CartaAbs {
    private SemeNapoletano seme;

    public CartaNapoletana(int valore, SemeNapoletano seme) {
        super(valore);
        this.seme = seme;
    }

    public SemeNapoletano getSeme() {
        return seme;
    }

    @Override
    public String toString() {
        return "[CARTA " +  super.valore + "\t" + seme + "]";
    }
    
}
