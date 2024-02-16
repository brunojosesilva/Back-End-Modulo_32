package br.com.brunojs;

import br.com.brunojs.dao.CursoDao;
import br.com.brunojs.dao.ICursoDao;
import br.com.brunojs.domain.Curso;
import br.com.brunojs.domain.Matricula;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author bruno
 */
public class CursoTest {

    private ICursoDao cursoDao;

    //** Ao iniciar o teste cria instancia para acesso aos dados
    public CursoTest() {
        cursoDao = new CursoDao();
    }

    @Test
    public void Cadastrar() {

        //** Cria instancia da entidade curso
        Curso curso = new Curso();
        curso.setCodigo(1);
        curso.setNome("Curso de java");
        curso.setDescricao("Curso de java para aprendizado");

        //** Chama o acesso aos dados
        curso = cursoDao.cadastrar(curso);

        assertNotNull(curso);
        assertNotNull(curso.getId());

        Curso cursoExcluindo = cursoDao.excluir(curso);

    }

    @Test
    public void ConsultaTodos() {

        //** Cria instancia da entidade curso
        Curso curso = new Curso();
        curso.setCodigo(1);
        curso.setNome("Curso de java");
        curso.setDescricao("Curso de java para aprendizado");

        //** Chama o acesso aos dados
        curso = cursoDao.cadastrar(curso);

        assertNotNull(curso);
        assertNotNull(curso.getId());

        curso.setId(null);
        curso.setCodigo(2);
        curso.setNome("Curso de java 2222 ");
        curso.setDescricao("Curso de java para aprendizado 22222");

        //** Chama o acesso aos dados
        curso = cursoDao.cadastrar(curso);

        assertNotNull(curso);
        assertNotNull(curso.getId());

        List<Curso> cursoLista = cursoDao.consultaTodos();

        for (Curso cur : cursoLista) {
            System.out.println(" A lista de cursos e : " + cur.getId() + " " + cur.getCodigo() + " " + cur.getNome());
            Curso cursoExcluindo = cursoDao.excluir(cur);
        }

    }

    @Test
    public void BuscaPorId() {

        //** Cria instancia da entidade curso
        Curso curso = new Curso();
        curso.setCodigo(1);
        curso.setNome("Curso de java");
        curso.setDescricao("Curso de java para aprendizado");

        //** Chama o acesso aos dados
        curso = cursoDao.cadastrar(curso);

        assertNotNull(curso);
        assertNotNull(curso.getId());

        Curso cursoBusca = new Curso();
        cursoBusca = cursoDao.buscaPorId(curso.getId());

        Curso cursoExcluindo = cursoDao.excluir(curso);
    }
}
