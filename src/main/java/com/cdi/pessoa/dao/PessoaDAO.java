package com.cdi.pessoa.dao;

import com.cdi.pessoa.model.Pessoa;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author lucas
 */
public class PessoaDAO {

    @Inject
    private EntityManager manager;

    public int insertPessoa(Pessoa p) {
        try {
            manager.getTransaction().begin();
            manager.merge(p);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return p.getId();
    }

    // possivel problema: duas transações abertas
    public int atualizarPessoa(Pessoa p) {
        manager.getTransaction().begin();
        manager.merge(p);
        manager.getTransaction().commit();
        return p.getId();
    }

    // possivel problema: duas transações abertas
    public void deletarPessoa(Pessoa p) {
        manager.getTransaction().begin();
        manager.merge(p);
        manager.getTransaction().commit();
    }
}
