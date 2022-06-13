package com.smartservice.adapter.http.spring.dto.saida.pedido;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CadastraPedidoResponse {

    @JsonProperty("id_pedido")
    private String idPedido;

    @JsonProperty("status_pedido")
    private String statusDoPedido;

    @JsonProperty("message")
    private String message;

    public CadastraPedidoResponse(String idPedido, String statusDoPedido, String message) {
        this.idPedido = idPedido;
        this.statusDoPedido = statusDoPedido;
        this.message = message;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public String getStatusDoPedido() {
        return statusDoPedido;
    }

    public String getMessage() {
        return message;
    }
}
