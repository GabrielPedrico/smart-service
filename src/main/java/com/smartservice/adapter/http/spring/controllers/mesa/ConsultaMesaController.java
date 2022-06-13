package com.smartservice.adapter.http.spring.controllers.mesa;

import com.smartservice.adapter.broker.delivery.MesaService;
import com.smartservice.adapter.http.spring.dto.ResponseData;
import com.smartservice.adapter.http.spring.dto.saida.mesa.ConsultaMesaResponse;
import com.smartservice.config.general.Log4jConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class ConsultaMesaController {

    @Autowired
    MesaService mesaService;

    @Autowired
    Log4jConfig log;

    @GetMapping("/mesa/{id}")
    @CrossOrigin
    public ResponseEntity<?> consultaMesa(@PathVariable("id") String id){
        log.getLogger().info("[API] SMART-SERVICE [API] INICIANDO OPERAÇÃO...");
        log.getLogger().info("[API] SMART-SERVICE [API] [END-POINT] /mesa/"+id+" [END-POINT]");
        log.getLogger().info("[API] SMART-SERVICE [API] PAYLOAD RECEBIDO = {id:"+ id+"}");
        ConsultaMesaResponse response = mesaService.consultaMesaPort().consultaMesa(id);
        return getResponseData(buildResponseData(response), HttpStatus.OK);
    }

    @GetMapping("/mesas")
    @CrossOrigin
    public ResponseEntity<?> consultaMesas(){
        log.getLogger().info("[API] SMART-SERVICE [API] INICIANDO OPERAÇÃO...");
        log.getLogger().info("[API] SMART-SERVICE [API] [END-POINT] /mesas [END-POINT]");
        List<ConsultaMesaResponse> responses = mesaService.consultaMesaPort().consultaMesas();
        return getResponseData(buildListResponseData(responses), HttpStatus.OK);
    }

    public ResponseEntity<ResponseData> getResponseData(ResponseData responseData, HttpStatus httpStatus){
        return new ResponseEntity<>(responseData,httpStatus);
    }

    private ResponseData buildResponseData(ConsultaMesaResponse defaultResponse){
        return new ResponseData(Collections.singletonList(defaultResponse));
    }
    private ResponseData buildListResponseData(List<ConsultaMesaResponse> defaultResponse){
        return new ResponseData(Collections.singletonList(defaultResponse));
    }
}
