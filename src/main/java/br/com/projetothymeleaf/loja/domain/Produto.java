package br.com.projetothymeleaf.loja.domain;

import br.com.projetothymeleaf.loja.to.ProdutoTO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_CRIACAO")
    private Date dataCriacao = new Date();

    @Column(name = "VALOR")
    private String valor;

    public Produto() {
    }

    public Produto(ProdutoTO produtoTO) {
        this.id = produtoTO.getId();
        this.nome = produtoTO.getNome();
        this.valor = produtoTO.getValor();
    }

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

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }


}
