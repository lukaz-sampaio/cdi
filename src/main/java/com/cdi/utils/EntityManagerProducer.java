package com.cdi.utils;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author lucas
 */
@ApplicationScoped
public class EntityManagerProducer {

//    @PersistenceUnit(unitName = "cdi")
//    private EntityManagerFactory factory;
    
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("cdi");

    @Produces
    @RequestScoped
    public EntityManager createEntityManager() {
        return factory.createEntityManager();
    }

    public void closeEntityManager(@Disposes EntityManager em) {
        if (em.isOpen()) {
            em.close();
        }
    }
}
