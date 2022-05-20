package com.smartservice.adapter.http.spring.produto.categoria;

import com.smartservice.adapter.broker.delivery.CategoriaService;
import com.smartservice.adapter.http.dto.DefaultResponse;
import com.smartservice.adapter.http.dto.ResponseData;
import com.smartservice.adapter.http.dto.saida.categoria.ConsultaCategoriasResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class ConsultaCategoriasController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/categorias")
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
