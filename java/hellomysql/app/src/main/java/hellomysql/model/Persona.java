package hellomysql.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Persona {
    private Integer id;
    private String cdf;
    private String nome;
    private String cognome;
    
    public Persona(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.cdf = resultSet.getString("cdf");
        this.nome = resultSet.getString("nome");
        this.cognome = resultSet.getString("cognome");
    }

    public Persona(int id, String cdf, String nome, String cognome) {
        this.id = id;
        this.cdf = cdf;
        this.nome = nome;
        this.cognome = cognome;
    }
    

    public Persona(String cdf, String nome, String cognome) {
        this.id = null;
        this.cdf = cdf;
        this.nome = nome;
        this.cognome = cognome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCdf() {
        return cdf;
    }

    public void setCdf(String cdf) {
        this.cdf = cdf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public String toString() {
        return "Persona [cdf=" + cdf + ", cognome=" + cognome + ", id=" + id + ", nome=" + nome + "]";
    }
}
