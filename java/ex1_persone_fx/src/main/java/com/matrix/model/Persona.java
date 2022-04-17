package com.matrix.model;
public class Persona {
    
    String nome;
    String cognome;
    String codiceFiscale;

    public Persona(String nome, String cognome, String codiceFiscale) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
    }
    
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

}
