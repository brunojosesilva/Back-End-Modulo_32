package br.com.brunojs.dao;

import br.com.brunojs.domain.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProdutoDao implements IProdutoDao{
    @Override
    public Produto cadastrar(Produto prod) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(prod);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return prod;

    }
}
