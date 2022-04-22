package com.mazzo.model.carta;

abstract public class CartaAbs {
      
    protected int valore;

    public CartaAbs(int valore) {
        this.valore = valore;
    }

    public int getValore() {
        return valore;
    }


    public void setValore(int valore) {
        this.valore = valore;
    }
    

    @Override
    public String toString() {
        return "[carta -> " + valore + "]";
    }


}
