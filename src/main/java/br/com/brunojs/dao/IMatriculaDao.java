package br.com.brunojs.dao;

import br.com.brunojs.domain.Curso;
import br.com.brunojs.domain.Matricula;

import java.util.List;

public interface IMatriculaDao {

    public Matricula cadastrar(Matricula matricula);
    public Matricula excluir(Matricula matricula);

    public List<Matricula> consultaTodos();

    public Matricula buscaPorId(Long id);
}
