package com.smartservice.adapter.http.spring.controllers.pedido.delivery;

import com.smartservice.adapter.broker.delivery.PedidoService;
import com.smartservice.adapter.http.spring.dto.DefaultResponse;
import com.smartservice.adapter.http.spring.dto.ResponseData;
import com.smartservice.adapter.http.spring.dto.entrada.pedido.AlteraStatusPedidoRequest;
import com.smartservice.config.general.Log4jConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.Collections;

@RestController
public class AlteraStatusPedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    Log4jConfig log;

    @PatchMapping(value = "/alterar/status/pedido/{id}")
    @CrossOrigin
    ResponseEntity<?> alteraStatusPedido(@RequestBody @Valid AlteraStatusPedidoRequest request, @PathVariable("id") String idPedido) throws MessagingException {
        log.getLogger().info("[API] SMART-SERVICE [API] INICIANDO OPERAÇÃO...");
        log.getLogger().info("[API] SMART-SERVICE [API] [END-POINT] /alterar/status/pedido/"+idPedido+" [END-POINT]");
        log.getLogger().info("[API] SMART-SERVICE [API] PAYLOAD RECEBIDO = "+request.toString());
        pedidoService.alteraStatusPedidoPort().alteraStatus(idPedido,request.getStatus());
        return getResponseData(buildResponseData(buildDefaultResponse()), HttpStatus.ACCEPTED);
    }

    public DefaultResponse buildDefaultResponse(){
        return new DefaultResponse("PROCESSAMENTO OK");
    }

    public ResponseEntity<ResponseData> getResponseData(ResponseData responseData, HttpStatus httpStatus){
        return new ResponseEntity<>(responseData,httpStatus);
    }

    private ResponseData buildResponseData(DefaultResponse defaultResponse){
        return new ResponseData(Collections.singletonList(defaultResponse));
    }


}
