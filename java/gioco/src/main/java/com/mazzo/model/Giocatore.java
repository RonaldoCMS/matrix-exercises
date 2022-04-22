package com.mazzo.model;

import com.mazzo.model.carta.CartaAbs;

public class Giocatore {
    private String username;
    private int punteggio;
    private CartaAbs cartaScelta;

    public Giocatore(String nome) {
        this.punteggio = 0;
        this.username = nome;
        cartaScelta = null;
    }

    public String getNome() {
        return username;
    }

    public void incrementPunteggio() {
        this.punteggio++;
    }

    public void setCartaScelta(CartaAbs cartaScelta) {
        this.cartaScelta = cartaScelta;
    }

    public CartaAbs getCartaScelta() {
        return cartaScelta;
    }

    @Override
    public String toString() {
        return username + "\t" + cartaScelta.toString();
    }

}
