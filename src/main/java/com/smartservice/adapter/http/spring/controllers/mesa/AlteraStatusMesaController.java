package com.smartservice.adapter.http.spring.controllers.mesa;

import com.smartservice.adapter.broker.delivery.PedidoService;
import com.smartservice.adapter.http.spring.dto.DefaultResponse;
import com.smartservice.adapter.http.spring.dto.ResponseData;
import com.smartservice.adapter.http.spring.dto.entrada.pedido.AlteraStatusPedidoRequest;
import com.smartservice.config.general.Log4jConfig;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;

@RestController
public class AlteraStatusMesaController {

    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private Log4jConfig log;

    @PatchMapping(value = "/presencial/alterar/status/mesa/{id}")
    @CrossOrigin
    ResponseEntity<?> alteraStatusPedido(@RequestBody @Valid AlteraStatusPedidoRequest request, @PathVariable("id") String idProduto) {
        log.getLogger().info("[API] SMART-SERVICE [API] INICIANDO OPERAÇÃO...");
        log.getLogger().info("[API] SMART-SERVICE [API] [END-POINT] /presencial/alterar/status/mesa/"+idProduto+" [END-POINT]");
        log.getLogger().info("[API] SMART-SERVICE [API] PAYLOAD RECEBIDO = {status:"+ request.getStatus()+"}");
        pedidoService.alteraStatusPedidoPresencialPort().alteraStatusMesa(idProduto,request.getStatus());
        log.getLogger().info("[API] SMART-SERVICE [API] ALTERAÇÃO REALIZADA COM SUCESSO PARA MESA DE ID "+idProduto);
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
