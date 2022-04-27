package com.example.model;

public class Stadio {
    String nome;
    int capienza;

    public Stadio(String nome, int capienza) {
        this.nome = nome;
        this.capienza = capienza;
    }

    public int getCapienza() {
        return capienza;
    }

    public String getNome() {
        return nome;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "[STADIO -> " + nome + "\t" + capienza + " posti" +"]";
    }

}
