package model.dao;

import model.entities.Cliente;
import java.util.List;

public interface ClienteDao {
    List<Cliente> findAll();
    List<Cliente> findByCriteria(String nombre, String apellido1, String apellido2);
    Cliente findById(String nif);
    Cliente save(Cliente cliente);
    void update(Cliente cliente);
    void delete(Cliente cliente);
}
