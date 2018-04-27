/*
 * Copyright 2017 daniel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http:www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cdi.produto.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.cdi.produto.model.Produto;
import javax.ejb.Stateless;

/**
 * @author daniel github:Daniel-Dos daniel.dias.analistati@gmail.com
 * twitter:@danieldiasjava
 */
@Stateless
public class ProdutoDAOImpl implements ProdutoDAO {

    @Inject
    private EntityManager manager;

    @Override
    public List<Produto> list() {
        return manager.createQuery("SELECT p FROM Produto p ORDER BY p.id ASC", Produto.class).getResultList();
    }

    @Override
    public void save(Produto produto) {
        try {
            manager.getTransaction().begin();
            manager.persist(produto);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Produto produto) {
        try {
            manager.getTransaction().begin();
            manager.merge(produto);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Produto produto) {
        try {
            manager.getTransaction().begin();
            manager.remove(produto);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        }
    }

    @Override
    public Produto getById(int id) {
        return manager.find(Produto.class, id);
    }
}
