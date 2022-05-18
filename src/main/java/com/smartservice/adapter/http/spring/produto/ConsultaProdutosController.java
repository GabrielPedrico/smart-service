package com.smartservice.adapter.http.spring.produto;

import com.smartservice.adapter.broker.delivery.ProdutoService;
import com.smartservice.adapter.datastore.entities.Produto;
import com.smartservice.adapter.http.dto.ResponseData;
import com.smartservice.adapter.http.dto.saida.produto.ConsultaProdutoResponse;
import com.smartservice.adapter.http.dto.saida.produto.ConsultaProdutosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class ConsultaProdutosController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "/produtos")
    @CrossOrigin
    ResponseEntity<?> consultaProdutos() throws IOException {
        var produtos = produtoService.consultaProdutosPort().consultaProdutos();
        return getResponseData(buildResponseData(produtos), HttpStatus.OK);
        }

    @GetMapping(value = "/produtos/categoria/{categoria}")
    @CrossOrigin
    ResponseEntity<?> consultaProdutosPorCategoria(@PathVariable("categoria") String categoria) throws IOException {
        var produtos = produtoService.consultaProdutosPort().consultaPorCategoria(categoria);
        return getResponseData(buildResponseData(produtos), HttpStatus.OK);
    }

    @GetMapping(value = "/produto/{id}")
    @CrossOrigin
    ResponseEntity<?> consultaProdutoPorId(@PathVariable("id") String id) throws IOException {
        ConsultaProdutoResponse produto = produtoService.consultaProdutosPort().consultaPorId(id);
        return getResponseData(buildResponseData(buildConsultaProdutosResponse(produto)), HttpStatus.OK);
    }

        public ConsultaProdutosResponse buildConsultaProdutosResponse(ConsultaProdutoResponse produto){
            ConsultaProdutosResponse consultaProdutosResponse = new ConsultaProdutosResponse();
            consultaProdutosResponse.getProdutos().add(produto);
            return consultaProdutosResponse;
        }

        public ResponseEntity<ResponseData> getResponseData(ResponseData responseData, HttpStatus httpStatus){
            return new ResponseEntity<>(responseData,httpStatus);
        }

        private ResponseData buildResponseData(ConsultaProdutosResponse consultaProdutosResponse){
            return new ResponseData(Collections.singletonList(consultaProdutosResponse));
        }

}
