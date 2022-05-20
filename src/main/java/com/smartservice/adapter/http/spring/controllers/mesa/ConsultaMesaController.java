package com.smartservice.adapter.http.spring.controllers.mesa;

import com.smartservice.adapter.broker.delivery.MesaService;
import com.smartservice.adapter.http.spring.dto.ResponseData;
import com.smartservice.adapter.http.spring.dto.saida.mesa.ConsultaMesaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class ConsultaMesaController {

    @Autowired
    MesaService mesaService;

    @GetMapping("/mesa/{id}")
    public ResponseEntity<?> consultaMesa(@PathVariable("id") String id){
        ConsultaMesaResponse response = mesaService.consultaMesaPort().consultaMesa(id);
        return getResponseData(buildResponseData(response), HttpStatus.OK);
    }

    public ResponseEntity<ResponseData> getResponseData(ResponseData responseData, HttpStatus httpStatus){
        return new ResponseEntity<>(responseData,httpStatus);
    }

    private ResponseData buildResponseData(ConsultaMesaResponse defaultResponse){
        return new ResponseData(Collections.singletonList(defaultResponse));
    }
}
