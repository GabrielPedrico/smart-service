package com.smartservice.adapter.http.dto.saida.categoria;

import java.util.List;

public class ConsultaCategoriasResponse {

    private List<String> categorias;

    public ConsultaCategoriasResponse(List<String> categorias) {
        this.categorias = categorias;
    }
    @Deprecated
    public ConsultaCategoriasResponse() {
    }

    public List<String> getCategorias() {
        return categorias;
    }
}
