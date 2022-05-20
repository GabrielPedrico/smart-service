package com.smartservice.core.port.saida.categoria;

import com.smartservice.adapter.http.spring.dto.saida.produto.categoria.ConsultaCategoriasResponse;

public interface ConsultaCategoriasPort {

    ConsultaCategoriasResponse consultarCategoriasDB();
}
