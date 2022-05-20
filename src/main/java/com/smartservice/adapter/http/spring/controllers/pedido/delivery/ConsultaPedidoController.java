package com.smartservice.adapter.http.spring.controllers.pedido.delivery;

import com.smartservice.adapter.broker.delivery.PedidoService;
import com.smartservice.adapter.http.spring.dto.ResponseData;
import com.smartservice.adapter.http.spring.dto.saida.pedido.ConsultaPedidoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class ConsultaPedidoController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping(value = "/pedidos")
    @CrossOrigin
    ResponseEntity<?> consultaPedidosPorStatus(@RequestParam("status") String status){
        List<ConsultaPedidoResponse> pedidos = pedidoService.consultaPedidosPort().consultaPedidosPorStatus(status);
        return getResponseData(buildResponseDatas(pedidos), HttpStatus.OK);
    }

    @GetMapping(value = "/pedido/{id}")
    @CrossOrigin
    ResponseEntity<?> consultaPedidoPorId(@PathVariable("id") String id){
        ConsultaPedidoResponse response = pedidoService.consultaPedidosPort().consultaPedidoPorId(id);
        return getResponseData(buildResponseData(response), HttpStatus.OK);
    }

    @GetMapping(value = "/pedidos/{idUsuario}")
    @CrossOrigin
    ResponseEntity<?> consultaPedidosPorUsuario(@PathVariable("idUsuario") String id){
        List<ConsultaPedidoResponse> pedidos = pedidoService.consultaPedidosPort().consultaPedidosPorUsuario(id);
        return getResponseData(buildResponseDatas(pedidos), HttpStatus.OK);
    }

    public ResponseEntity<ResponseData> getResponseData(ResponseData responseData, HttpStatus httpStatus){
        return new ResponseEntity<>(responseData,httpStatus);
    }

    private ResponseData buildResponseData(ConsultaPedidoResponse consultaProdutoResponse){
        return new ResponseData(Collections.singletonList(consultaProdutoResponse));
    }

    private ResponseData buildResponseDatas(List<ConsultaPedidoResponse> consultaProdutoResponse){
        return new ResponseData(Collections.singletonList(consultaProdutoResponse));
    }
}
