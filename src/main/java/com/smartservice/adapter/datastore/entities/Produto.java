package com.smartservice.adapter.datastore.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Produto {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(unique = true,columnDefinition="VARCHAR(40)")
    private String id;

    @ManyToOne
    private Categoria categoria;

    private String nome;

    private BigDecimal preco;

    private String descricao;

    private Integer estoque;

    @Column
    @Lob
    private String imgUrl;

    @ManyToMany(mappedBy = "produtos")
    @JsonIgnore
    private List<Pedido> pedidos = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Mesa> mesas = new ArrayList<>();

    @Deprecated
    public Produto(){}

    public Produto(String id, Categoria categoria, String nome, BigDecimal preco, String descricao, Integer estoque, String imgUrl,List<Pedido> pedidos,List<Mesa> mesas) {
        this.id = id;
        this.categoria = categoria;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.estoque = estoque;
        this.imgUrl = imgUrl;
        this.pedidos = pedidos;
        this.mesas = mesas;
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

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(List<Mesa> mesas) {
        this.mesas = mesas;
    }
}
