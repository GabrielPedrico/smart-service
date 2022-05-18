package com.smartservice.adapter.broker.delivery;


import com.smartservice.core.port.saida.CadastraMesaPort;
import org.springframework.stereotype.Service;

@Service
public class MesaService {

    private final CadastraMesaPort cadastraMesaPort;

    public MesaService(CadastraMesaPort cadastraMesaPort) {
        this.cadastraMesaPort = cadastraMesaPort;
    }

    public CadastraMesaPort cadastraMesaPort() {
        return cadastraMesaPort;
    }
}
