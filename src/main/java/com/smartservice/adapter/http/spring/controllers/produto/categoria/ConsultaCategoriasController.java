package com.smartservice.adapter.http.spring.controllers.produto.categoria;

import com.smartservice.adapter.broker.delivery.CategoriaService;
import com.smartservice.adapter.http.spring.dto.ResponseData;
import com.smartservice.adapter.http.spring.dto.saida.produto.categoria.ConsultaCategoriasResponse;
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

    @GetMapping("/categorias")
    @CrossOrigin
    public ResponseEntity<?> consultaCategorias(){
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
