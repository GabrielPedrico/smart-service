package com.smartservice.adapter.datastore.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartservice.core.model.enums.StatusPedido;
import com.smartservice.core.model.enums.TipoPagamento;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(unique = true,columnDefinition="VARCHAR(40)")
    private String id;

    private String codigoPedido;

    @OneToOne
    private Usuario usuario;

    @ManyToMany
    private List<Produto> produtos = new ArrayList<Produto>();

    @Column(columnDefinition="VARCHAR(300)")
    private String obs;

    @Enumerated(EnumType.STRING)
    private TipoPagamento formaPagamento;

    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;

    private BigDecimal valorTotal;

    @CreationTimestamp
    @PastOrPresent
    private LocalDateTime dataCriacaoPedido;

    private LocalDateTime dataFinalizacaoPedido;


    public Pedido(String id, Usuario usuario, List<Produto> produtos, TipoPagamento formaPagamento, StatusPedido statusPedido, BigDecimal valorTotal, LocalDateTime dataCriacaoPedido, LocalDateTime dataFinalizacaoPedido,String obs) {
        this.id = id;
        this.usuario = usuario;
        this.produtos = produtos;
        this.formaPagamento = formaPagamento;
        this.statusPedido = statusPedido;
        this.valorTotal = valorTotal;
        this.dataCriacaoPedido = dataCriacaoPedido;
        this.dataFinalizacaoPedido = dataFinalizacaoPedido;
        this.codigoPedido = id.substring(0,3).toUpperCase();
        this.obs = obs;
    }

    @Deprecated
    public Pedido(){}

    public String getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public TipoPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void setFormaPagamento(TipoPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataCriacaoPedido() {
        return dataCriacaoPedido;
    }

    public void setDataCriacaoPedido(LocalDateTime dataCriacaoPedido) {
        this.dataCriacaoPedido = dataCriacaoPedido;
    }

    public LocalDateTime getDataFinalizacaoPedido() {
        return dataFinalizacaoPedido;
    }

    public void setDataFinalizacaoPedido(LocalDateTime dataFinalizacaoPedido) {
        this.dataFinalizacaoPedido = dataFinalizacaoPedido;
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
