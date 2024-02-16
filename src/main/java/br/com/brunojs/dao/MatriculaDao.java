package br.com.brunojs.dao;

import br.com.brunojs.domain.Curso;
import br.com.brunojs.domain.Matricula;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class MatriculaDao implements IMatriculaDao {
    @Override
    public Matricula cadastrar(Matricula matricula) {
        //** Conecta no banco de dados
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //** Abre a transacao
        entityManager.getTransaction().begin();
        //** Salva a entidade no banco
        entityManager.persist(matricula);
        //** Salva a transacao
        entityManager.getTransaction().commit();

        //** Fecha a conexao
        entityManager.close();
        entityManagerFactory.close();

        return matricula;
    }

    @Override
    public Matricula excluir(Matricula matricula) {
        //** Conecta no banco de dados
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //** Abre a transacao
        entityManager.getTransaction().begin();
        //** Exclui a entidade no banco
        matricula = entityManager.merge(matricula);
        entityManager.remove(matricula);
        //** Salva a transacao
        entityManager.getTransaction().commit();

        //** Fecha a conexao
        entityManager.close();
        entityManagerFactory.close();

        return matricula;
    }

    @Override
    public List<Matricula> consultaTodos() {
        //** Conecta no banco de dados
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //** Criterio para consulta
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Matricula> query = builder.createQuery(Matricula.class);
        Root<Matricula> root = query.from(Matricula.class);
        query.select(root);

        TypedQuery<Matricula> tpQuery =
                entityManager.createQuery(query);

        //** Pega o resultado
        List<Matricula> list = tpQuery.getResultList();
        //** Fecha a conexao
        entityManager.close();
        entityManagerFactory.close();

        return list;

    }

    @Override
    public Matricula buscaPorId(Long id) {
        //** Conecta no banco de dados
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //** Busca o curso pelo ID
        Matricula matricula = entityManager.find(Matricula.class, id);

        //** Fecha a conexao
        entityManager.close();
        entityManagerFactory.close();

        return matricula;
    }
}
