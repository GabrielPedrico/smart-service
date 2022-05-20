package com.smartservice.adapter.http.spring.dto.entrada.produto;

public class EditaProdutoRequest {

    private String id;

    private String categoria;

    private String nome;

    private String preco;

    private String descricao;

    private String estoque;

    public EditaProdutoRequest(String id,String categoria, String nome, String preco, String descricao, String estoque) {
        this.id = id;
        this.categoria = categoria;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.estoque = estoque;
    }

    @Deprecated
    public EditaProdutoRequest(){}

    public String getId() {
        return id;
    }

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
