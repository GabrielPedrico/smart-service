package com.smartservice.adapter.http.spring.controllers.produto;

import com.smartservice.adapter.broker.delivery.ProdutoService;
import com.smartservice.adapter.http.spring.dto.ResponseData;
import com.smartservice.adapter.http.spring.dto.saida.produto.CadastraProdutoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;

@RestController
public class AdicionaImagemProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PutMapping(value = "/cadastra/imagem/produto/{id}",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE},
            headers = "content-type=multipart/*")
    @CrossOrigin
    ResponseEntity<?> adicionaImagemProduto(@RequestParam("file") MultipartFile file, @PathVariable String id) throws IOException {
        produtoService.adicionaImagemProdutoPort().adicionaImagemProduto(file,id);
        return getResponseData(buildResponseData(buildCadastraUsuarioResponse()), HttpStatus.ACCEPTED);
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
