package com.smartservice.adapter.http.spring.controllers.produto.categoria;

import com.smartservice.adapter.broker.delivery.CategoriaService;
import com.smartservice.adapter.http.spring.dto.DefaultResponse;
import com.smartservice.adapter.http.spring.dto.ResponseData;
import com.smartservice.adapter.http.spring.dto.entrada.produto.categoria.CadastraCategoriaRequest;
import com.smartservice.config.general.Log4jConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;

@RestController
public class CadastraCategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private Log4jConfig log;

    @PostMapping(value = "/cadastra/categoria")
    @CrossOrigin
    ResponseEntity<?> cadastraCategoria(@RequestBody @Valid CadastraCategoriaRequest categoria) {
        log.getLogger().info("[API] SMART-SERVICE [API] INICIANDO OPERAÇÃO...");
        log.getLogger().info("[API] SMART-SERVICE [API] [END-POINT] /cadastra/categoria [END-POINT]");
        log.getLogger().info("[API] SMART-SERVICE [API] PAYLOAD RECEBIDO = "+ categoria.toString());
        categoriaService.cadastraCategoriaPort().cadastra(categoria.getNome());
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
