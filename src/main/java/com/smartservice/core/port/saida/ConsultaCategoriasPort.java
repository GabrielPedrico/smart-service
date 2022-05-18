package com.smartservice.core.port.saida;

import com.smartservice.adapter.http.dto.saida.categoria.ConsultaCategoriasResponse;

public interface ConsultaCategoriasPort {

    ConsultaCategoriasResponse consultarCategoriasDB();
}
