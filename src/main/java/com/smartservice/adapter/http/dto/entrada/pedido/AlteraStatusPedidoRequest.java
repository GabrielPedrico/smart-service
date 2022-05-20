package com.smartservice.adapter.http.dto.entrada.pedido;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

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
