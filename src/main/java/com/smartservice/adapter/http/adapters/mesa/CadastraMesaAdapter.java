package com.smartservice.adapter.http.adapters.mesa;

import com.smartservice.adapter.datastore.entities.Mesa;
import com.smartservice.adapter.datastore.repositories.MesaRepository;
import com.smartservice.config.general.Log4jConfig;
import com.smartservice.core.model.enums.StatusMesa;
import com.smartservice.core.port.saida.mesa.CadastraMesaPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraMesaAdapter implements CadastraMesaPort {

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    Log4jConfig log;

    @Override
    public void cadastra(int quantidadeMesas) {
        log.getLogger().info("[API] SMART-SERVICE [API] [ADAPTER] CADASTRANDO MESAS...[ADAPTER]");
        int quantidadeMesasIncrementado = quantidadeMesas + 1;
        for (int i = 1; i < quantidadeMesasIncrementado; i++) {
            Mesa mesa = new Mesa(i, StatusMesa.LIVRE);
            mesaRepository.save(mesa);
        }
        log.getLogger().info("[API] SMART-SERVICE [API] [ADAPTER] MESAS CADASTRADAS COM SUCESSO! [ADAPTER]");
    }
}
