package br.com.brunojs.dao;

import br.com.brunojs.domain.Curso;

import java.util.List;

public interface ICursoDao {

    public Curso cadastrar(Curso curso);

    public Curso excluir(Curso curso);

    public List<Curso> consultaTodos();

    public Curso buscaPorId(Long id);
}
