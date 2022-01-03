package com.smartservice.core.model.usuario;

import com.smartservice.core.model.enums.Categoria;

import java.math.BigDecimal;
import java.util.UUID;

public class ProdutoModel {

    private UUID id;

    private Categoria categoria;

    private String nome;

    private BigDecimal preco;

    private String descricao;

    private Integer estoque;

    private String imgUrl;

    public ProdutoModel(UUID id, Categoria categoria, String nome, BigDecimal preco, String descricao, Integer estoque, String imgUrl) {
        this.id = id;
        this.categoria = categoria;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.estoque = estoque;
        this.imgUrl = imgUrl;
    }

    public ProdutoModel(){}

    public UUID getId() {
        return id;
    }

    public Categoria getCategoria() {
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
