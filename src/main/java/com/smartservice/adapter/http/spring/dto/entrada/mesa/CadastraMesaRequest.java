package com.smartservice.adapter.http.spring.dto.entrada.mesa;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CadastraMesaRequest {

    @JsonProperty("quantidade_mesas")
    private int quantidadeMesas;

    public CadastraMesaRequest(int quantidadeMesas) {
        this.quantidadeMesas = quantidadeMesas;
    }

    @Deprecated
    public CadastraMesaRequest(){}

    public int getQuantidadeMesas() {
        return quantidadeMesas;
    }
}
