package com.smartservice.adapter.datastore.entities;

import com.smartservice.core.model.enums.Categoria;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Produto {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(unique = true,columnDefinition="VARCHAR(40)")
    private String id;

    private Categoria categoria;

    private String nome;

    private BigDecimal preco;

    private String descricao;

    private Integer estoque;

    @Column
    @Lob
    private String imgUrl;

    @Deprecated
    public Produto(){}

    public Produto(String id, Categoria categoria, String nome, BigDecimal preco, String descricao, Integer estoque, String imgUrl) {
        this.id = id;
        this.categoria = categoria;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.estoque = estoque;
        this.imgUrl = imgUrl;
    }

    public String getId() {
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

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
