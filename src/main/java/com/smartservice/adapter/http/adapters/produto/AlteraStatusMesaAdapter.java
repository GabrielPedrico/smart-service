package com.smartservice.adapter.http.adapters.produto;

import com.smartservice.adapter.datastore.entities.Mesa;
import com.smartservice.adapter.datastore.repositories.MesaRepository;
import com.smartservice.config.general.Log4jConfig;
import com.smartservice.core.exceptions.MesaNaoExistenteException;
import com.smartservice.core.model.enums.StatusMesa;
import com.smartservice.core.port.entrada.pedido.AlteraStatusPedidoPresencialPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;

@Component
public class AlteraStatusMesaAdapter implements AlteraStatusPedidoPresencialPort {

    @Autowired
    MesaRepository mesaRepository;

    @Autowired
    private Log4jConfig log;


    @Override
    public void alteraStatusMesa(String idMesa, String status) {
        log.getLogger().info("[API] SMART-SERVICE [API] [ADAPTER] VERIFICANDO SE MESA EXISTE... [ADAPTER]");
        Mesa mesa = mesaRepository.findById(Integer.valueOf(idMesa)).orElseThrow(()-> new MesaNaoExistenteException("Falho ao mudar status da mesa, mesa não existe na nossa base de dados."));
        log.getLogger().info("[API] SMART-SERVICE [API] [ADAPTER] MESA ENCONTRADA! [ADAPTER]");
        log.getLogger().info("[API] SMART-SERVICE [API] [ADAPTER] VERIFICANDO SE STATUS EXISTE... [ADAPTER]");
        StatusMesa statusMesa = StatusMesa.valueOf(status);
        log.getLogger().info("[API] SMART-SERVICE [API] [ADAPTER] STATUS ENCONTRADO! [ADAPTER]");
        log.getLogger().info("[API] SMART-SERVICE [API] [ADAPTER] VERIFICANDO SE STATUS SOLICITADO É LIVRE/OCUPADA... [ADAPTER]");
        if(statusMesa.equals(StatusMesa.LIVRE)){
            log.getLogger().info("[API] SMART-SERVICE [API] [ADAPTER] STATUS É LIVRE, LIMPANDO VALOR TOTAL E PRODUTOS DA MESA [ADAPTER]");
            mesa.setValorTotal(BigDecimal.ZERO);
            mesa.setProdutos(new ArrayList<>());
        }
        log.getLogger().info("[API] SMART-SERVICE [API] [ADAPTER] STATUS É "+statusMesa.name()+", REALIZANDO UPDATE... [ADAPTER]");
        mesa.setStatusMesa(statusMesa);
        mesaRepository.save(mesa);
        log.getLogger().info("[API] SMART-SERVICE [API] [ADAPTER] UPDATE REALIZADO COM SUCESSO PARA ALTERAÇÃO STATUS MESA! NOVO STATUS: "+statusMesa.name()+" [ADAPTER]");
        log.getLogger().info("[API] SMART-SERVICE [API] [ADAPTER] PROCESSAMENTO CONCLUIDO! [ADAPTER]");
    }
}
