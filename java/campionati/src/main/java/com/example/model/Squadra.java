package com.example.model;

public class Squadra {
    private String nome;
    private Calciatore[] calciatori;
    private Stadio stadio;

    public Squadra(String nome, Calciatore[] calciatori, Stadio stadio) {
        this.nome = nome;
        this.setCalciatori(calciatori);
        this.setStadio(stadio);
    }

    public Stadio getStadio() {
        return stadio;
    }

    public void setStadio(Stadio stadio) {
        this.stadio = stadio;
    }

    public Calciatore[] getCalciatori() {
        return calciatori;
    }

    public void setCalciatori(Calciatore[] calciatori) {
        this.calciatori = calciatori;
    }

    public String getNome() {
        return nome;
    }

    

    @Override
    public String toString() {
        String listCalciatori = "";

        for(Calciatore calciatore : calciatori) {
            listCalciatori += (calciatore.toString() + "\n");
        }
        return "[" + nome + "\n" + listCalciatori + "\n" + stadio.toString()  + "]";
    }


}
