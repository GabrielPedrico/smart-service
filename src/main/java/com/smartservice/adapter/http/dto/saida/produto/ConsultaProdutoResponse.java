package com.smartservice.adapter.http.dto.saida.produto;

import java.math.BigDecimal;

public class ConsultaProdutoResponse {

    private String id;

    private String categoria;

    private String nome;

    private BigDecimal preco;

    private String descricao;

    private Integer estoque;

    private String imgUrl;

    public ConsultaProdutoResponse(String id, String categoria, String nome, BigDecimal preco, String descricao, Integer estoque, String imgUrl) {
        this.id = id;
        this.categoria = categoria;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.estoque = estoque;
        this.imgUrl = imgUrl;
    }

    @Deprecated
    public ConsultaProdutoResponse() {
    }


    public String getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
