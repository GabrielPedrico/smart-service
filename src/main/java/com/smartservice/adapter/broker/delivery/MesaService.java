package com.smartservice.adapter.broker.delivery;


import com.smartservice.core.port.saida.mesa.CadastraMesaPort;
import com.smartservice.core.port.saida.mesa.ConsultaMesaPort;
import org.springframework.stereotype.Service;

@Service
public class MesaService {

    private final CadastraMesaPort cadastraMesaPort;

    private final ConsultaMesaPort consultaMesaPort;

    public MesaService(CadastraMesaPort cadastraMesaPort,ConsultaMesaPort consultaMesaPort) {
        this.cadastraMesaPort = cadastraMesaPort;
        this.consultaMesaPort = consultaMesaPort;
    }

    public CadastraMesaPort cadastraMesaPort() {
        return cadastraMesaPort;
    }

    public ConsultaMesaPort consultaMesaPort() {
        return consultaMesaPort;
    }
}
