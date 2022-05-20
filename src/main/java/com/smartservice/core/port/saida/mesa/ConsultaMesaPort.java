package com.smartservice.core.port.saida.mesa;

import com.smartservice.adapter.http.spring.dto.saida.mesa.ConsultaMesaResponse;

public interface ConsultaMesaPort {

    ConsultaMesaResponse consultaMesa(String id);
}
