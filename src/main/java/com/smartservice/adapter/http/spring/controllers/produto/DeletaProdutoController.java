package com.smartservice.adapter.http.spring.controllers.produto;

import com.smartservice.adapter.broker.delivery.ProdutoService;
import com.smartservice.adapter.http.spring.dto.DefaultResponse;
import com.smartservice.adapter.http.spring.dto.ResponseData;
import com.smartservice.adapter.http.spring.dto.entrada.produto.DeletaProdutosRequest;
import com.smartservice.core.model.produto.ProdutoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
public class DeletaProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @DeleteMapping(value = "/deleta/produto/{id}")
    @CrossOrigin
    ResponseEntity<?> deletaProdutoById(@PathVariable("id") String idProduto){
        produtoService.deletaProdutoPort().delete(idProduto);
        return getResponseData(buildResponseData(buildDefaultResponse()), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/deleta/produtos")
    @CrossOrigin
    ResponseEntity<?> deletaProdutosById(@RequestBody @Valid DeletaProdutosRequest produtos){
        List<ProdutoModel> produtosModel = produtoService.produtoMapper().converterParaListaDeProdutoModel(produtos);
        produtoService.deletaProdutoPort().deleteProdutos(produtosModel);
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
