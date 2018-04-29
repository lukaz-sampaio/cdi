package com.cdi.cliente.dao;

import com.cdi.cliente.model.Cliente;
import java.util.ArrayList;
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
            manager.getTransaction().rollback();
        }
    }

    public void atualizarCliente(Cliente c) {
        try {
            manager.getTransaction().begin();
            manager.merge(c);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        }
    }

    public void deletarCliente(Cliente c) {
        try {
            manager.getTransaction().begin();
            manager.remove(c);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        }
    }

    /**
     * Retorna apenas os dados que serão mostrado na lista da tela inicial.
     * Recuperar todos é mais pra um caso de get pra update ou show more
     * details;
     *
     * @return
     */
    public List<Cliente> listarCliente() {
        /**
         * Aqui foi feito um arrodeio grande porque TypedQuery retorna apenas
         * uma linha e o método `getResultList()` devolve um array de Object. O
         * array de Object foi percorrido e seus respectivos índices foram
         * distribuidos nos atributos do objeto Cliente que foi adicionado em
         * uma lista de Clientes (List<Cliente>). Aqui está como se fosse usando
         * PreparedStatement, mas pra não precisar abrir outra conexão só pra
         * usar no PrparedStatement foi preferível fazer desta forma.
         *
         * Tem que ver como vai se portar caso tenha que mostrar dados de outras
         * entidades, no caso, Contato.java e Endereco.java.
         */

        /* Ordenar pelo último cadastrado (dataCadastro)*/
        String query = "SELECT c.id, c.razaoSocial, c.nomeFantasia FROM Cliente c ORDER BY c.id DESC";
        List<Object[]> resultList = manager.createQuery(query).getResultList();
        List<Cliente> list = new ArrayList<>();
        Cliente c;
        for (Object[] objects : resultList) {
            c = new Cliente();
            c.setId((int) objects[0]);
            c.setRazaoSocial((String) objects[1]);
            c.setNomeFantasia((String) objects[2]);
            list.add(c);
        }
        return list;
    }

    public Cliente getCliente(int id) {
        return manager.find(Cliente.class, id);
    }
}
