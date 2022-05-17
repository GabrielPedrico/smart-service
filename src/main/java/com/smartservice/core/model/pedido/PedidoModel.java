package com.smartservice.core.model.pedido;


import java.util.List;

public class PedidoModel {

    private String idUsuario;

    private List<ProdutoModel> produtos;

    private String formaPagamento;

    private String obs;

    public PedidoModel(String idUsuario, List<ProdutoModel> produtos, String formaPagamento,String obs) {
        this.idUsuario = idUsuario;
        this.produtos = produtos;
        this.formaPagamento = formaPagamento;
        this.obs = obs;
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

    public String getObs() {
        return obs;
    }
}
