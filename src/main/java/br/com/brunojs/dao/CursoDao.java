package br.com.brunojs.dao;

import br.com.brunojs.domain.Curso;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CursoDao implements ICursoDao{
    @Override
    public Curso cadastrar(Curso curso) {
        //** Conecta no banco de dados
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //** Abre a transacao
        entityManager.getTransaction().begin();
        //** Salva a entidade no banco
        entityManager.persist(curso);
        //** Salva a transacao
        entityManager.getTransaction().commit();

        //** Fecha a conexao
        entityManager.close();
        entityManagerFactory.close();

        return curso;
    }

    @Override
    public Curso excluir(Curso curso) {
        //** Conecta no banco de dados
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //** Abre a transacao
        entityManager.getTransaction().begin();
        //** Exclui a entidade no banco
        curso = entityManager.merge(curso);
        entityManager.remove(curso);
        //** Salva a transacao
        entityManager.getTransaction().commit();

        //** Fecha a conexao
        entityManager.close();
        entityManagerFactory.close();

        return curso;
    }

    @Override
    public List<Curso> consultaTodos() {
        //** Conecta no banco de dados
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //** Criterio para consulta
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Curso> query = builder.createQuery(Curso.class);
        Root<Curso> root = query.from(Curso.class);
        query.select(root);

        TypedQuery<Curso> tpQuery =
                entityManager.createQuery(query);

        //** Pega o resultado
        List<Curso> list = tpQuery.getResultList();
        //** Fecha a conexao
        entityManager.close();
        entityManagerFactory.close();

        return list;
    }

    @Override
    public Curso buscaPorId(Long id) {
        //** Conecta no banco de dados
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //** Busca o curso pelo ID
        Curso curso = entityManager.find(Curso.class, id);

        //** Fecha a conexao
        entityManager.close();
        entityManagerFactory.close();

        return curso;
    }
}
