package com.smartservice.core.model.pedido;


import java.util.List;

public class PedidoModel {

    private String idUsuario;

    private List<ProdutoModel> produtos;

    private String formaPagamento;

    public PedidoModel(String idUsuario, List<ProdutoModel> produtos, String formaPagamento) {
        this.idUsuario = idUsuario;
        this.produtos = produtos;
        this.formaPagamento = formaPagamento;
    }

    public PedidoModel(){}

    public String getIdUsuario() {
        return idUsuario;
    }

    public List<ProdutoModel> getProdutos() {
        return produtos;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }
}
