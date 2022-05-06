package com.smartservice.adapter.http.adapters;

import com.smartservice.adapter.datastore.repositories.ProdutoRepository;
import com.smartservice.core.exceptions.ProdutoNaoExistenteException;
import com.smartservice.core.port.saida.DeletaProdutoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletaProdutoAdapter implements DeletaProdutoPort {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public void deleteCrud(String idProduto) {
        var possivelProduto = produtoRepository.findById(idProduto);
        if(possivelProduto.isEmpty()) throw new ProdutoNaoExistenteException("Produto inexistente.");
        produtoRepository.deleteById(idProduto);
    }
}
