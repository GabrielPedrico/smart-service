package com.smartservice.adapter.http.spring.controllers.mesa;

import com.smartservice.adapter.broker.delivery.MesaService;
import com.smartservice.adapter.http.spring.dto.DefaultResponse;
import com.smartservice.adapter.http.spring.dto.ResponseData;
import com.smartservice.adapter.http.spring.dto.entrada.mesa.CadastraMesaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class CadastraMesasController {

    @Autowired
    MesaService mesaService;

    @PostMapping("/cadastra/mesas")
    public ResponseEntity<?> cadastraMesas(@RequestBody CadastraMesaRequest cadastraMesaRequest){
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
