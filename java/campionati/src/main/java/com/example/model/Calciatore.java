package com.example.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Calciatore {
    private Integer id;
    private Ruolo ruolo;
    private String nome;
    private String cognome;
    private Integer id_squadra;

    public Calciatore(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.nome = resultSet.getString("nome");
        this.cognome = resultSet.getString("cognome");
        switch(resultSet.getInt("ruolo")) {
            case 1: this.ruolo = Ruolo.ATTACCANTE; break;
            case 2: this.ruolo = Ruolo.CENTROCAMPISTA; break;
            case 3: this.ruolo = Ruolo.DIFENSORE; break;
            case 4: this.ruolo = Ruolo.PORTIERE; break;
        }
        this.id_squadra = resultSet.getInt("id_squadra");
    }

    public Calciatore(String nome, String cognome, Ruolo ruolo, Integer squadra) {
        this.nome = nome;
        this.cognome = cognome;
        this.ruolo = ruolo;
        this.id_squadra = squadra;
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

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "[CALCIATORE: " + nome + "\t" + cognome + "\t" + ruolo +" ]";
    }

}
