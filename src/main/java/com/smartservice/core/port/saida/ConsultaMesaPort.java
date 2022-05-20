package com.smartservice.core.port.saida;

import com.smartservice.adapter.http.dto.saida.mesa.ConsultaMesaResponse;

public interface ConsultaMesaPort {

    ConsultaMesaResponse consultaMesa(String id);
}
