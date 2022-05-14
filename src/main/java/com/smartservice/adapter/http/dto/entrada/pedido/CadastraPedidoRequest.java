package com.smartservice.adapter.http.dto.entrada.pedido;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class CadastraPedidoRequest {

    @NotBlank
    @JsonProperty("id_usuario")
    private String idUsuario;

    @NotEmpty
    private List<ProdutoRequest> produtos;

    @NotBlank
    @JsonProperty("forma_pagamento")
    private String formaPagamento;

    public CadastraPedidoRequest(String idUsuario, List<ProdutoRequest> produtos, String formaPagamento) {
        this.idUsuario = idUsuario;
        this.produtos = produtos;
        this.formaPagamento = formaPagamento;
    }

    @Deprecated
    public CadastraPedidoRequest() {
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public List<ProdutoRequest> getProdutos() {
        return produtos;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }
}
