package com.smartservice.adapter.http.adapters.mesa;

import com.smartservice.adapter.datastore.entities.Mesa;
import com.smartservice.adapter.datastore.repositories.MesaRepository;
import com.smartservice.adapter.http.spring.dto.saida.mesa.ConsultaMesaResponse;
import com.smartservice.adapter.http.spring.dto.saida.mesa.MesaProdutoResponse;
import com.smartservice.config.general.Log4jConfig;
import com.smartservice.core.exceptions.ConsultaMesaException;
import com.smartservice.core.port.saida.mesa.ConsultaMesaPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConsultaMesaAdapter implements ConsultaMesaPort {

    @Autowired
    MesaRepository mesaRepository;

    @Autowired
    Log4jConfig log;

    @Override
    public ConsultaMesaResponse consultaMesa(String id) {
        log.getLogger().info("[API] SMART-SERVICE [API] [ADAPTER] VERIFICANDO SE MESA EXISTE...[ADAPTER]");
        Mesa mesa = mesaRepository.findById(Integer.valueOf(id)).orElseThrow(()-> new ConsultaMesaException("Mesa não existe na nossa base de dados."));
        log.getLogger().info("[API] SMART-SERVICE [API] [ADAPTER] MESA "+id+" ENCONTRADA COM SUCESSO! ");
        List<MesaProdutoResponse> produtos = new ArrayList<>();
        mesa.getProdutos().forEach(produto ->
            produtos.add(new MesaProdutoResponse(produto.getNome()))
        );

        return new ConsultaMesaResponse(mesa.getId(),mesa.getStatusMesa().name(),produtos,mesa.getValorTotal().toString());
    }

    @Override
    public List<ConsultaMesaResponse> consultaMesas() {
        log.getLogger().info("[API] SMART-SERVICE [API] [ADAPTER] RESGATANDO MESAS...[ADAPTER]");
        List<Mesa> mesas = mesaRepository.findAll();
        List<ConsultaMesaResponse> mesasResponses = new ArrayList<>();
        mesas.forEach(mesa -> {
            List<MesaProdutoResponse> produtos = new ArrayList<>();
            mesa.getProdutos().forEach(produto ->
                    produtos.add(new MesaProdutoResponse(produto.getNome()))
            );
            ConsultaMesaResponse consultaMesaResponse =  new ConsultaMesaResponse(mesa.getId(),mesa.getStatusMesa().name(),produtos,mesa.getValorTotal().toString());
            mesasResponses.add(consultaMesaResponse);
        });

        return mesasResponses;
    }
}
