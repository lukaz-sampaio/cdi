package com.cdi.cliente.dao;

import com.cdi.cliente.model.Cliente;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author lucas
 */
public class ClienteDAO {

    @Inject
    private EntityManager manager;

    public void adicionarCliente(Cliente c) {
        try {
            manager.getTransaction().begin();
            manager.persist(c);
            manager.getTransaction().commit();
        } catch (Exception e) {
            if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
        }
    }

    public void atualizarCliente(Cliente c) {
        try {
            manager.getTransaction().begin();
            manager.merge(c);
            manager.getTransaction().commit();
        } catch (Exception e) {
            if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
        }
    }
    
    public void deletarCliente(Cliente c) {
        try {
            manager.getTransaction().begin();
            manager.remove(c);
            manager.getTransaction().commit();
        } catch (Exception e) {
            if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
        }
    }

    public List<Cliente> listarCliente() {
        String query = "SELECT c.id, p.razaoSocial, c.nomeFantasia FROM Cliente c INNER JOIN Pessoa p ON c.id = p.id ORDER BY c.id ASC";
        return manager.createQuery(query, Cliente.class).getResultList();
//        return manager.createQuery("SELECT c.id, c.razaoSocial, c.nomeFantasia FROM Cliente c ORDER BY c.id ASC", Cliente.class).getResultList();
    }

    public Cliente getCliente(int id) {
        return manager.find(Cliente.class, id);
    }
}
