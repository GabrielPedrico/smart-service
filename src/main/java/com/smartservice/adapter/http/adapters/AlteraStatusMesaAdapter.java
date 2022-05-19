package com.smartservice.adapter.http.adapters;

import com.smartservice.adapter.datastore.entities.Mesa;
import com.smartservice.adapter.datastore.repositories.MesaRepository;
import com.smartservice.core.exceptions.MesaNaoExistenteException;
import com.smartservice.core.model.enums.StatusMesa;
import com.smartservice.core.port.entrada.AlteraStatusPedidoPresencialPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;

@Component
public class AlteraStatusMesaAdapter implements AlteraStatusPedidoPresencialPort {

    @Autowired
    MesaRepository mesaRepository;


    @Override
    public void alteraStatusMesa(String idMesa, String status) {

        Mesa mesa = mesaRepository.findById(Integer.valueOf(idMesa)).orElseThrow(()-> new MesaNaoExistenteException("Falho ao mudar status da mesa, mesa não existe na nossa base de dados."));
        StatusMesa statusMesa = StatusMesa.valueOf(status);
        if(statusMesa.equals(StatusMesa.LIVRE)){
            mesa.setValorTotal(BigDecimal.ZERO);
            mesa.setProdutos(new ArrayList<>());
        }

        mesa.setStatusMesa(statusMesa);
        mesaRepository.save(mesa);
    }
}
