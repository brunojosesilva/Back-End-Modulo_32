package br.com.brunojs;

import br.com.brunojs.dao.IMatriculaDao;
import br.com.brunojs.dao.MatriculaDao;
import br.com.brunojs.domain.Curso;
import br.com.brunojs.domain.Matricula;
import org.junit.Test;

import java.time.Instant;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class MatriculaTest {

    IMatriculaDao matriculaDao;
    public MatriculaTest() {
        matriculaDao = new MatriculaDao();
    }

    @Test
    public void Cadastrar() {
        Matricula matricula = new Matricula();
        matricula.setCodigo(1);
        matricula.setDataMatricula(Instant.now());
        matricula.setValor(1550.0);
        matricula.setStatus("Matriculado");

        matricula = matriculaDao.cadastrar(matricula);
        assertNotNull(matricula);
        assertNotNull(matricula.getId());

        Matricula matriculaExcluir = matriculaDao.excluir(matricula);

    }

    @Test
    public void ConsultaTodos() {
        Matricula matricula = new Matricula();
        matricula.setCodigo(1);
        matricula.setDataMatricula(Instant.now());
        matricula.setValor(1550.0);
        matricula.setStatus("Matriculado");

        matricula = matriculaDao.cadastrar(matricula);
        assertNotNull(matricula);
        assertNotNull(matricula.getId());

        matricula.setId(null);
        matricula.setCodigo(2);
        matricula.setDataMatricula(Instant.now());
        matricula.setValor(550.20);
        matricula.setStatus("Matriculado");

        matricula = matriculaDao.cadastrar(matricula);
        assertNotNull(matricula);
        assertNotNull(matricula.getId());

        List<Matricula> matriculasLista = matriculaDao.consultaTodos();

        for (Matricula mat : matriculasLista) {
            System.out.println(" A lista de matricula e : " + mat.getId() + " " + mat.getCodigo() + " " + mat.getValor());
            Matricula matriculaExcluir = matriculaDao.excluir(mat);
        }

    }

    @Test
    public void BuscaPorId() {

        Matricula matricula = new Matricula();
        matricula.setCodigo(1);
        matricula.setDataMatricula(Instant.now());
        matricula.setValor(1550.0);
        matricula.setStatus("Matriculado");

        matricula = matriculaDao.cadastrar(matricula);
        assertNotNull(matricula);
        assertNotNull(matricula.getId());

        Matricula matriculaBusca = new Matricula();
        matriculaBusca = matriculaDao.buscaPorId(matricula.getId());

        Matricula matriculaExcluindo = matriculaDao.excluir(matricula);
    }
}
