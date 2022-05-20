package com.smartservice.adapter.http.spring.dto.entrada.produto;

import javax.validation.constraints.NotBlank;

public class DeletaProdutoRequest {

   @NotBlank
   String idProduto;

    public DeletaProdutoRequest(String idProduto) {
        this.idProduto = idProduto;
    }

    @Deprecated
    public DeletaProdutoRequest(){}

    public String getIdProduto() {
        return idProduto;
    }
}
