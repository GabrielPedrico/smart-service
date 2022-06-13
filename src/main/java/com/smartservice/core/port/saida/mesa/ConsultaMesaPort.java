package com.smartservice.core.port.saida.mesa;

import com.smartservice.adapter.http.spring.dto.saida.mesa.ConsultaMesaResponse;

import java.util.List;

public interface ConsultaMesaPort {

    ConsultaMesaResponse consultaMesa(String id);

    List<ConsultaMesaResponse> consultaMesas();
}
