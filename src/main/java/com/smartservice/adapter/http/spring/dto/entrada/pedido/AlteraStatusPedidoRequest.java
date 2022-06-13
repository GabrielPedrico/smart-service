package com.smartservice.adapter.http.spring.dto.entrada.pedido;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class AlteraStatusPedidoRequest {

    @NotBlank
    @JsonProperty("status")
    private String status;

    public AlteraStatusPedidoRequest(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Deprecated
    public AlteraStatusPedidoRequest() {
    }
}
