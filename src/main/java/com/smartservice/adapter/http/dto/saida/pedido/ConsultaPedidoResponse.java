package com.smartservice.adapter.http.dto.saida.pedido;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"codigo_pedido","nome_cliente","email_cliente","endereco"})
public class ConsultaPedidoResponse {

    @JsonProperty("codigo_pedido")
    private String codigoPedido;

    @JsonProperty("nome_cliente")
    private String nomeCliente;

    @JsonProperty("email_cliente")
    private String emailCliente;

    @JsonProperty("endereco")
    private EnderecoResponse endereco;

    @JsonProperty("produtos")
    private List<ProdutoResponse> produtos;

    @JsonProperty("observacao")
    private String obs;

    @JsonProperty("forma_pagamento")
    private String formaPagamento;

    @JsonProperty("valor_total")
    private String valorTotal;

    @JsonProperty("data_pedido")
    private String dataPedido;

    public ConsultaPedidoResponse(String codigoPedido, String nomeCliente, String emailCliente, EnderecoResponse endereco, List<ProdutoResponse> produtos, String obs, String formaPagamento, String valorTotal,String dataPedido) {
        this.codigoPedido = codigoPedido;
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.endereco = endereco;
        this.produtos = produtos;
        this.obs = obs;
        this.formaPagamento = formaPagamento;
        this.valorTotal = valorTotal;
        this.dataPedido = dataPedido;
    }

    public String getCodigoPedido() {
        return codigoPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public EnderecoResponse getEndereco() {
        return endereco;
    }

    public List<ProdutoResponse> getProdutos() {
        return produtos;
    }

    public String getObs() {
        return obs;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public String getDataPedido() {
        return dataPedido;
    }
}
