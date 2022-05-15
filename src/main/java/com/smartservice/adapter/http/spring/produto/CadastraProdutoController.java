package com.smartservice.adapter.http.spring.produto;

import com.smartservice.adapter.broker.delivery.ProdutoService;
import com.smartservice.adapter.http.dto.ResponseData;
import com.smartservice.adapter.http.dto.entrada.produto.CadastraProdutoRequest;
import com.smartservice.adapter.http.dto.saida.produto.CadastraProdutoResponse;
import com.smartservice.core.model.produto.ProdutoModel;
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
public class CadastraProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping(value = "/cadastra/produto")
    @CrossOrigin
    ResponseEntity<?> cadastrarProduto(@RequestBody @Valid CadastraProdutoRequest request){
            ProdutoModel produtoModel = produtoService.produtoMapper().converterParaProdutoModel(request);
            var cadastroProdutoResponse =produtoService.cadastroProdutoPort().processaCadastro(produtoModel);
            return getResponseData(buildResponseData(cadastroProdutoResponse), HttpStatus.CREATED);
    }
    public ResponseEntity<ResponseData> getResponseData(ResponseData responseData, HttpStatus httpStatus){
        return new ResponseEntity<>(responseData,httpStatus);
    }

    private ResponseData buildResponseData(CadastraProdutoResponse cadastraProdutoResponse){
        return new ResponseData(Collections.singletonList(cadastraProdutoResponse));
    }
}
