package com.smartservice.adapter.http.spring.pedido;

import com.smartservice.adapter.broker.delivery.PedidoService;
import com.smartservice.adapter.http.dto.ResponseData;
import com.smartservice.adapter.http.dto.entrada.pedido.CadastraPedidoRequest;
import com.smartservice.adapter.http.dto.saida.pedido.CadastraPedidoResponse;
import com.smartservice.core.model.pedido.PedidoModel;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Collections;

@RestController
public class CadastraPedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping(value = "/cadastra/delivery/pedido")
    @CrossOrigin
    ResponseEntity<?> cadastrarPedido(@RequestBody @Valid CadastraPedidoRequest request) throws MessagingException, URISyntaxException, UnsupportedEncodingException {
        PedidoModel pedidoModel = pedidoService.pedidoMapper().converterParaPedidoModel(request);
        CadastraPedidoResponse cadastraPedidoResponse = pedidoService.cadastraPedidoPort().cadastra(pedidoModel);
        return getResponseData(buildResponseData(cadastraPedidoResponse), HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseData> getResponseData(ResponseData responseData, HttpStatus httpStatus){
        return new ResponseEntity<>(responseData,httpStatus);
    }

    private ResponseData buildResponseData(CadastraPedidoResponse cadastraProdutoResponse){
        return new ResponseData(Collections.singletonList(cadastraProdutoResponse));
    }
}
