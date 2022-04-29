package com.example.model.opera;

public class Quadro extends Opera{

    private Tecnica tecnica;

    public Quadro(int codice, String titolo, String autore, Tecnica tecnica) {
        super(codice, titolo, autore);
        this.setTecnica(tecnica);
    }
    
    public void setTecnica(Tecnica tecnica) {
        this.tecnica = tecnica;
    }

    public Tecnica getTecnica() {
        return tecnica;
    }



}
