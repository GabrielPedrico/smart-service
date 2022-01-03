package com.smartservice.adapter.http.spring;

import com.smartservice.adapter.broker.mapper.ProdutoMapper;
import com.smartservice.adapter.http.dto.ResponseData;
import com.smartservice.adapter.http.dto.entrada.CadastraProdutoRequest;
import com.smartservice.adapter.http.dto.saida.produto.CadastraProdutoResponse;
import com.smartservice.core.model.usuario.ProdutoModel;
import com.smartservice.core.port.entrada.CadastroProdutoPort;
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
    private CadastroProdutoPort cadastroProdutoPort;

    @Autowired
    private ProdutoMapper produtoMapper;

    @PostMapping(value = "/cadastra/produto")
    @CrossOrigin
    ResponseEntity<?> cadastrarProduto(@RequestBody @Valid CadastraProdutoRequest request){
            ProdutoModel produtoModel = produtoMapper.converterParaProdutoModel(request);
            cadastroProdutoPort.processaCadastro(produtoModel);
            return getResponseData(buildResponseData(buildCadastraUsuarioResponse()), HttpStatus.CREATED);
    }

    public CadastraProdutoResponse buildCadastraUsuarioResponse(){
        return new CadastraProdutoResponse("PROCESSAMENTO OK");
    }

    public ResponseEntity<ResponseData> getResponseData(ResponseData responseData, HttpStatus httpStatus){
        return new ResponseEntity<>(responseData,httpStatus);
    }

    private ResponseData buildResponseData(CadastraProdutoResponse cadastraProdutoResponse){
        return new ResponseData(Collections.singletonList(cadastraProdutoResponse));
    }
}
