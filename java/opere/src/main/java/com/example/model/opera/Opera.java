package com.example.model.opera;

import java.util.Comparator;

abstract public class Opera implements Comparator<Opera> {
    private int codice;
    private String titolo;
    private String autore;
    private boolean esposta;

    public Opera(int codice, String titolo, String autore) {
        this.setAutore(autore);
        this.setCodice(codice);
        this.setTitolo(titolo);
        this.setEsposta(false);
    }

    public void setEsposta(boolean esposta) {
        this.esposta = esposta;
    }

    public boolean isEsposta() {
        return esposta;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public String toString() {
        return "Opera [codice=" + codice + ", titolo=" + titolo + "]";
    }

    @Override
    public int compare(Opera o1, Opera o2) {
        return o1.codice - o2.codice;
    }

}
