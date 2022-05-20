package com.smartservice.adapter.http.adapters;

import com.smartservice.adapter.datastore.entities.Mesa;
import com.smartservice.adapter.datastore.repositories.MesaRepository;
import com.smartservice.core.model.enums.StatusMesa;
import com.smartservice.core.port.saida.CadastraMesaPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraMesaAdapter implements CadastraMesaPort {

    @Autowired
    private MesaRepository mesaRepository;

    @Override
    public void cadastra(int quantidadeMesas) {
        int quantidadeMesasIncrementado = quantidadeMesas + 1;
        for (int i = 1; i < quantidadeMesasIncrementado; i++) {
            Mesa mesa = new Mesa(i, StatusMesa.LIVRE);
            mesaRepository.save(mesa);
        }
    }
}
