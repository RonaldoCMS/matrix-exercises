package com.example.model;

public class Calciatore {
    private Ruolo ruolo;
    private String nome;
    private String cognome;

    public Calciatore(String nome, String cognome, Ruolo ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.ruolo = ruolo;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    @Override
    public String toString() {
        return "[CALCIATORE: " + nome + "\t" + cognome + "\t" + ruolo +" ]";
    }

}
