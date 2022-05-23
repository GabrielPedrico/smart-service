package com.smartservice.adapter.http.spring.controllers.mesa;

import com.smartservice.adapter.broker.delivery.MesaService;
import com.smartservice.adapter.http.spring.dto.DefaultResponse;
import com.smartservice.adapter.http.spring.dto.ResponseData;
import com.smartservice.adapter.http.spring.dto.entrada.mesa.CadastraMesaRequest;
import com.smartservice.config.general.Log4jConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class CadastraMesasController {

    @Autowired
    MesaService mesaService;
    @Autowired
    private Log4jConfig log;

    @PostMapping("/cadastra/mesas")
    @CrossOrigin
    public ResponseEntity<?> cadastraMesas(@RequestBody CadastraMesaRequest cadastraMesaRequest){
        log.getLogger().info("[API] SMART-SERVICE [API] INICIANDO OPERAÇÃO...");
        log.getLogger().info("[END-POINT] /CADASTRA/MESAS [END-POINT] INICIANDO OPERAÇÃO...");
        log.getLogger().info("[API] SMART-SERVICE [API] PAYLOAD RECEBIDO = {quantidade_mesas:"+ cadastraMesaRequest.getQuantidadeMesas()+"}");
        mesaService.cadastraMesaPort().cadastra(cadastraMesaRequest.getQuantidadeMesas());
        return getResponseData(buildResponseData(buildDefaultResponse()), HttpStatus.CREATED);
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
