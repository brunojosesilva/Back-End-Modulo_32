package br.com.brunojs.domain;

import javax.persistence.*;

@Entity
@Table (name = "TB_PRODUTO")
public class Produto {
    //TODO
    // Criar classe produto, criar 3 propriedades e mapear JPA (testar se esta criado no BD)
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="produto_seq")
    @SequenceGenerator(name="prod_seq", sequenceName="sq_produto", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column(name = "NOME", length = 50, nullable = false, unique = true)
    private String nome;

    @Column(name = "VALOR", length = 10, nullable = false)
    private double valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


}
