package com.example.model.opera;

public class Statua extends Opera {

    private Materiale materiale;
    private double altezza;

    public Statua(int codice, String titolo, String autore, Materiale materiale, double altezza) {
        super(codice, titolo, autore);
        this.setMateriale(materiale);
        this.setAltezza(altezza);
    }

    public Materiale getMateriale() {
        return materiale;
    }

    public void setMateriale(Materiale materiale) {
        this.materiale = materiale;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    @Override
    public String toString() {
        return "Statua [" + super.toString() + "altezza=" + altezza + ", materiale=" + materiale + "]";
    }  
}
