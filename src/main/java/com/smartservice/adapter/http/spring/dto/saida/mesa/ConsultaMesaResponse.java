package com.smartservice.adapter.http.spring.dto.saida.mesa;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ConsultaMesaResponse {

    @JsonProperty("numero_mesa")
    private Integer numeroMesa;
    @JsonProperty("status_mesa")
    private String statusMesa;
    @JsonProperty("produtos")
    private List<MesaProdutoResponse> produtos;
    @JsonProperty("valor_total")
    private String valorTotal;

    public ConsultaMesaResponse(Integer numeroMesa, String statusMesa, List<MesaProdutoResponse> produtos, String valorTotal) {
        this.numeroMesa = numeroMesa;
        this.statusMesa = statusMesa;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
    }

    @Deprecated
    public ConsultaMesaResponse() {
    }

    public Integer getNumeroMesa() {
        return numeroMesa;
    }

    public String getStatusMesa() {
        return statusMesa;
    }

    public List<MesaProdutoResponse> getProdutos() {
        return produtos;
    }

    public String getValorTotal() {
        return valorTotal;
    }
}
