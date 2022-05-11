package com.smartservice.adapter.http.spring.produto.categoria;

import com.smartservice.adapter.broker.delivery.CategoriaService;
import com.smartservice.adapter.http.dto.DefaultResponse;
import com.smartservice.adapter.http.dto.ResponseData;
import com.smartservice.adapter.http.dto.entrada.produto.categoria.CadastraCategoriaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Collections;

@RestController
public class CadastraCategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping(value = "/cadastra/categoria")
    @CrossOrigin
    ResponseEntity<?> cadastraCategoria(@RequestBody @Valid CadastraCategoriaRequest categoria) throws IOException {
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
