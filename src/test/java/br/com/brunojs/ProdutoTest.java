package br.com.brunojs;

import br.com.brunojs.domain.Produto;
import br.com.brunojs.dao.IProdutoDao;
import br.com.brunojs.dao.ProdutoDao;
import org.junit.Test;

import javax.transaction.TransactionScoped;

import static org.junit.Assert.assertNotNull;

public class ProdutoTest {

    private IProdutoDao produtoDao;

    public ProdutoTest(){
        produtoDao = new ProdutoDao();
    }

    @Test
    public void cadastrar() {
        Produto prod = new Produto();
        prod.setNome("Mouse");
        prod.setValor(75.99d);
        produtoDao.cadastrar(prod);

        assertNotNull(prod);
        assertNotNull(prod.getId());
    }


}
