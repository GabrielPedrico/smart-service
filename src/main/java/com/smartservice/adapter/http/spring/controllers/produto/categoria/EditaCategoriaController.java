package com.smartservice.adapter.http.spring.controllers.produto.categoria;

import com.smartservice.adapter.broker.delivery.CategoriaService;
import com.smartservice.adapter.http.spring.dto.DefaultResponse;
import com.smartservice.adapter.http.spring.dto.ResponseData;
import com.smartservice.adapter.http.spring.dto.entrada.produto.categoria.EditaCategoriaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;

@RestController
public class EditaCategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PatchMapping(value = "/edita/categoria/{categoria}")
    @CrossOrigin
    ResponseEntity<?> cadastraCategoria(@PathVariable("categoria") String categoria, @RequestBody @Valid EditaCategoriaRequest categoriaEditada){
        categoriaService.editaCategoriaPort().edita(categoria,categoriaEditada.getNomeNovo());
        return getResponseData(buildResponseData(buildDefaultResponse()), HttpStatus.ACCEPTED);
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
