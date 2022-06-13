package com.smartservice.adapter.http.spring.controllers.produto.categoria;

import com.smartservice.adapter.broker.delivery.CategoriaService;
import com.smartservice.adapter.http.spring.dto.ResponseData;
import com.smartservice.adapter.http.spring.dto.saida.produto.categoria.ConsultaCategoriasResponse;
import com.smartservice.config.general.Log4jConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class ConsultaCategoriasController {

    @Autowired
    CategoriaService categoriaService;

    @Autowired
    Log4jConfig log;

    @GetMapping("/categorias")
    @CrossOrigin
    public ResponseEntity<?> consultaCategorias(){
        log.getLogger().info("[API] SMART-SERVICE [API] INICIANDO OPERAÇÃO...");
        log.getLogger().info("[API] SMART-SERVICE [API] [END-POINT] /categorias [END-POINT]");
        ConsultaCategoriasResponse categoriasResponse = categoriaService.consultaCategoriasPort().consultarCategoriasDB();
        return getResponseData(buildResponseData(categoriasResponse), HttpStatus.ACCEPTED);
    }

    public ResponseEntity<ResponseData> getResponseData(ResponseData responseData, HttpStatus httpStatus){
        return new ResponseEntity<>(responseData,httpStatus);
    }

    private ResponseData buildResponseData(ConsultaCategoriasResponse defaultResponse){
        return new ResponseData(Collections.singletonList(defaultResponse));
    }
}
