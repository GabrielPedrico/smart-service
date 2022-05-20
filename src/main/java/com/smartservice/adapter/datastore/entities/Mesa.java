package com.smartservice.adapter.datastore.entities;

import com.smartservice.core.model.enums.StatusMesa;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Mesa {

    @Id
    private int id;

    @Column(unique = true,columnDefinition="VARCHAR(300)")
    @Lob
    private String qrCode;

    @Enumerated(EnumType.STRING)
    private StatusMesa statusMesa;

    @OneToMany
    private List<Pedido> pedidos = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<Produto> produtos = new ArrayList<>();

    private BigDecimal valorTotal;

    public Mesa(int id, String qrCode, StatusMesa statusMesa, List<Pedido> pedidos, BigDecimal valorTotal) {
        this.id = id;
        this.qrCode = qrCode;
        this.statusMesa = statusMesa;
        this.pedidos = pedidos;
        this.valorTotal = valorTotal;
    }

    public Mesa(int id,StatusMesa statusMesa) {
        this.id = id;
        this.statusMesa = statusMesa;
        this.valorTotal = BigDecimal.valueOf(0);
    }

    @Deprecated
    public Mesa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public StatusMesa getStatusMesa() {
        return statusMesa;
    }

    public void setStatusMesa(StatusMesa statusMesa) {
        this.statusMesa = statusMesa;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
