package com.smartservice.adapter.http.spring.dto.entrada.pedido;

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

    @JsonProperty("observacao")
    private String obs;

    @Override
    public String toString() {
        return "CadastraPedidoRequest{" +
                "idUsuario='" + idUsuario + '\'' +
                ", produtos=" + produtos +
                ", obs='" + obs + '\'' +
                ", formaPagamento='" + formaPagamento + '\'' +
                '}';
    }

    @NotBlank
    @JsonProperty("forma_pagamento")
    private String formaPagamento;

    public CadastraPedidoRequest(String idUsuario, List<ProdutoRequest> produtos, String formaPagamento,String obs) {
        this.idUsuario = idUsuario;
        this.produtos = produtos;
        this.formaPagamento = formaPagamento;
        this.obs = obs;
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

    public String getObs() {
        return obs;
    }
}
