package com.smartservice.adapter.http.adapters;

import com.smartservice.adapter.datastore.entities.Mesa;
import com.smartservice.adapter.datastore.repositories.MesaRepository;
import com.smartservice.adapter.http.dto.saida.mesa.ConsultaMesaResponse;
import com.smartservice.adapter.http.dto.saida.mesa.MesaProdutoResponse;
import com.smartservice.core.exceptions.ConsultaMesaException;
import com.smartservice.core.port.saida.ConsultaMesaPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConsultaMesaAdapter implements ConsultaMesaPort {

    @Autowired
    MesaRepository mesaRepository;

    @Override
    public ConsultaMesaResponse consultaMesa(String id) {
        Mesa mesa = mesaRepository.findById(Integer.valueOf(id)).orElseThrow(()-> new ConsultaMesaException("Mesa não existe na nossa base de dados."));
        List<MesaProdutoResponse> produtos = new ArrayList<>();
        mesa.getProdutos().forEach(produto -> {
            produtos.add(new MesaProdutoResponse(produto.getNome()));
        });
        return new ConsultaMesaResponse(mesa.getId(),mesa.getStatusMesa().name(),produtos,mesa.getValorTotal().toString());
    }
}
