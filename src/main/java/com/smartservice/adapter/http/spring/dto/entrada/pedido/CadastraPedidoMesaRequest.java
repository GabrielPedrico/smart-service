package com.smartservice.adapter.http.spring.dto.entrada.pedido;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class CadastraPedidoMesaRequest {

    @NotEmpty
    private List<ProdutoRequest> produtos;

    @JsonProperty("observacao")
    private String obs;

    public CadastraPedidoMesaRequest(List<ProdutoRequest> produtos,String obs) {
        this.produtos = produtos;
        this.obs = obs;
    }

    @Deprecated
    public CadastraPedidoMesaRequest() {
    }



    public List<ProdutoRequest> getProdutos() {
        return produtos;
    }

    public String getObs() {
        return obs;
    }
}
