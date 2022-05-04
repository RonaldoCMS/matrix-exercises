package hellomysql.repositories;

import java.util.List;

import hellomysql.model.Persona;

public interface PersonaDAO extends DAO<Persona> {
    public List<Persona> findByName(String name);
    public List<Persona> findByCognome(String cognome);
    public Persona findByCdf(String cdf);
}
