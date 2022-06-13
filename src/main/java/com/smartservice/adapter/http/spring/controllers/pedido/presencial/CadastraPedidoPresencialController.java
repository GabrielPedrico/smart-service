package com.smartservice.adapter.http.spring.controllers.pedido.presencial;

import com.smartservice.adapter.broker.delivery.PedidoService;
import com.smartservice.adapter.http.spring.dto.ResponseData;
import com.smartservice.adapter.http.spring.dto.entrada.pedido.CadastraPedidoMesaRequest;
import com.smartservice.adapter.http.spring.dto.saida.pedido.CadastraPedidoResponse;
import com.smartservice.config.general.Log4jConfig;
import com.smartservice.core.model.pedido.PedidoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Collections;

@RestController
public class CadastraPedidoPresencialController {
    @Autowired
    private PedidoService pedidoService;
    @Autowired
    Log4jConfig log;

    @PostMapping(value = "/cadastra/pedido/presencial/mesa/{numeroMesa}")
    @CrossOrigin
    ResponseEntity<?> cadastrarPedido(@RequestBody @Valid CadastraPedidoMesaRequest request, @PathVariable("numeroMesa") String numeroMesa) throws MessagingException, URISyntaxException, UnsupportedEncodingException {
        log.getLogger().info("[API] SMART-SERVICE [API] INICIANDO OPERAÇÃO...");
        log.getLogger().info("[API] SMART-SERVICE [API] [END-POINT] /cadastra/pedido/presencial/mesa/"+numeroMesa+" [END-POINT]");
        log.getLogger().info("[API] SMART-SERVICE [API] PAYLOAD RECEBIDO = "+request.toString());
        PedidoModel pedidoModel = pedidoService.pedidoMapper().converterParaPedidoModel(request);
        CadastraPedidoResponse cadastraPedidoResponse = pedidoService.cadastraPedidoPort().cadastraPedidoPresencial(pedidoModel,numeroMesa);
        return getResponseData(buildResponseData(cadastraPedidoResponse), HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseData> getResponseData(ResponseData responseData, HttpStatus httpStatus){
        return new ResponseEntity<>(responseData,httpStatus);
    }

    private ResponseData buildResponseData(CadastraPedidoResponse cadastraProdutoResponse){
        return new ResponseData(Collections.singletonList(cadastraProdutoResponse));
    }

}
