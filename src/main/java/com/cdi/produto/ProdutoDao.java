package com.cdi.produto;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author lucas
 */
public class ProdutoDao {

    @Inject
    private EntityManager manager;

    public List<Produto> list(){
        return manager.createQuery("SELECT id, name FROM Produto", Produto.class).getResultList();
    }
    
    public void save(Produto produto){
        manager.persist(produto);
    }
    
    public void update(Produto produto){
        manager.merge(produto);
    }
    
    public void delete(Produto produto){
        manager.remove(produto);
    }
    
    public Produto getById(long id){
        return manager.find(Produto.class, id);
    }
}
