package com.smartservice.adapter.http.spring.dto.entrada.produto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class CadastraProdutoRequest {

    @NotBlank
    private String categoria;

    @NotBlank
    private String nome;

    @PositiveOrZero
    private String preco;

    private String descricao;

    @Override
    public String toString() {
        return "CadastraProdutoRequest{" +
                "categoria='" + categoria + '\'' +
                ", nome='" + nome + '\'' +
                ", preco='" + preco + '\'' +
                ", descricao='" + descricao + '\'' +
                ", estoque='" + estoque + '\'' +
                '}';
    }

    @PositiveOrZero
    private String estoque;

    public CadastraProdutoRequest(String categoria, String nome, String preco, String descricao, String estoque) {
        this.categoria = categoria;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.estoque = estoque;
    }

    @Deprecated
    public CadastraProdutoRequest(){}

    public String getCategoria() {
        return categoria;
    }

    public String getNome() {
        return nome;
    }

    public String getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEstoque() {
        return estoque;
    }
}
