package com.smartservice.adapter.http.spring.controllers.pedido.delivery;

import com.smartservice.adapter.broker.delivery.PedidoService;
import com.smartservice.adapter.http.spring.dto.ResponseData;
import com.smartservice.adapter.http.spring.dto.saida.pedido.ConsultaPedidoResponse;
import com.smartservice.config.general.Log4jConfig;
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

    @Autowired
    Log4jConfig log;

    @GetMapping(value = "/pedidos")
    @CrossOrigin
    ResponseEntity<?> consultaPedidosPorStatus(@RequestParam("status") String status){
        log.getLogger().info("[API] SMART-SERVICE [API] INICIANDO OPERAÇÃO...");
        log.getLogger().info("[API] SMART-SERVICE [API] [END-POINT] /pedidos [END-POINT]");
        log.getLogger().info("[API] SMART-SERVICE [API] PAYLOAD RECEBIDO = STATUS:"+status);
        List<ConsultaPedidoResponse> pedidos = pedidoService.consultaPedidosPort().consultaPedidosPorStatus(status);
        return getResponseData(buildResponseDatas(pedidos), HttpStatus.OK);
    }

    @GetMapping(value = "/pedido/{id}")
    @CrossOrigin
    ResponseEntity<?> consultaPedidoPorId(@PathVariable("id") String id){
        log.getLogger().info("[API] SMART-SERVICE [API] INICIANDO OPERAÇÃO...");
        log.getLogger().info("[API] SMART-SERVICE [API] [END-POINT] /pedido/"+id+" [END-POINT]");
        log.getLogger().info("[API] SMART-SERVICE [API] PAYLOAD RECEBIDO = ID:"+id);
        ConsultaPedidoResponse response = pedidoService.consultaPedidosPort().consultaPedidoPorId(id);
        return getResponseData(buildResponseData(response), HttpStatus.OK);
    }

    @GetMapping(value = "/pedidos/{idUsuario}")
    @CrossOrigin
    ResponseEntity<?> consultaPedidosPorUsuario(@PathVariable("idUsuario") String id){
        log.getLogger().info("[API] SMART-SERVICE [API] INICIANDO OPERAÇÃO...");
        log.getLogger().info("[API] SMART-SERVICE [API] [END-POINT] /pedidos/"+id+" [END-POINT]");
        log.getLogger().info("[API] SMART-SERVICE [API] PAYLOAD RECEBIDO = id_usuario:"+id);
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
