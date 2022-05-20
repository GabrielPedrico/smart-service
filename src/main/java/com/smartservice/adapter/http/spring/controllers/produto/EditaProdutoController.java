package com.smartservice.adapter.http.spring.controllers.produto;

import com.smartservice.adapter.broker.delivery.ProdutoService;
import com.smartservice.adapter.http.spring.dto.DefaultResponse;
import com.smartservice.adapter.http.spring.dto.ResponseData;
import com.smartservice.adapter.http.spring.dto.entrada.produto.EditaProdutoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;

@RestController
public class EditaProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PutMapping(value = "/edita/produto/{id}")
    @CrossOrigin
    ResponseEntity<?> editaProdutoById(@PathVariable("id") String id,@RequestBody @Valid EditaProdutoRequest produto){
        var produtosModel = produtoService.produtoMapper().converterParaProdutoModel(produto,id);
        produtoService.editaProdutoPort().editaProduto(produtosModel);
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
