package com.smartservice.adapter.http.spring.produto;

import com.smartservice.adapter.broker.delivery.ProdutoService;
import com.smartservice.adapter.datastore.entities.Produto;
import com.smartservice.adapter.http.dto.ResponseData;
import com.smartservice.adapter.http.dto.saida.produto.ConsultaProdutoResponse;
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
        return getResponseData(buildResponseData(buildConsultaProdutosResponse(produtos)), HttpStatus.OK);
        }

    @GetMapping(value = "/produtos/categoria/{categoria}")
    @CrossOrigin
    ResponseEntity<?> consultaProdutosPorCategoria(@PathVariable("categoria") String categoria) throws IOException {
        var produtos = produtoService.consultaProdutosPort().consultaPorCategoria(categoria);
        return getResponseData(buildResponseData(buildConsultaProdutosResponse(produtos)), HttpStatus.OK);
    }

    @GetMapping(value = "/produto/{id}")
    @CrossOrigin
    ResponseEntity<?> consultaProdutosPorId(@PathVariable("id") String id) throws IOException {
        var produtos = produtoService.consultaProdutosPort().consultaPorId(id);
        List<Produto> produto = new ArrayList<>();
        produto.add(produtos);
        return getResponseData(buildResponseData(buildConsultaProdutosResponse(produto)), HttpStatus.OK);
    }

        public ConsultaProdutoResponse buildConsultaProdutosResponse(List<Produto> produtos){
            return new ConsultaProdutoResponse(produtos);
        }

        public ResponseEntity<ResponseData> getResponseData(ResponseData responseData, HttpStatus httpStatus){
            return new ResponseEntity<>(responseData,httpStatus);
        }

        private ResponseData buildResponseData(ConsultaProdutoResponse consultaProdutoResponse){
            return new ResponseData(Collections.singletonList(consultaProdutoResponse));
        }

}