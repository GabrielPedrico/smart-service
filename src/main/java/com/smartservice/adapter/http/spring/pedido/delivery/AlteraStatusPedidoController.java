package com.smartservice.adapter.http.spring.pedido.delivery;

import com.smartservice.adapter.broker.delivery.PedidoService;
import com.smartservice.adapter.http.dto.DefaultResponse;
import com.smartservice.adapter.http.dto.ResponseData;
import com.smartservice.adapter.http.dto.entrada.pedido.AlteraStatusPedidoRequest;
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
public class AlteraStatusPedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PatchMapping(value = "/alterar/status/pedido/{id}")
    @CrossOrigin
    ResponseEntity<?> alteraStatusPedido(@RequestBody @Valid AlteraStatusPedidoRequest request, @PathVariable("id") String idProduto) throws MessagingException, URISyntaxException, UnsupportedEncodingException {
        pedidoService.alteraStatusPedidoPort().alteraStatus(idProduto,request.getStatus());
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
