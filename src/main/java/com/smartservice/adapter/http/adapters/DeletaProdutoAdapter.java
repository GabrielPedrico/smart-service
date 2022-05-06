package com.smartservice.adapter.http.adapters;

import com.smartservice.adapter.datastore.repositories.ProdutoRepository;
import com.smartservice.core.exceptions.DeleteProdutoNaoExistenteException;
import com.smartservice.core.exceptions.ProdutoNaoExistenteException;
import com.smartservice.core.model.produto.ProdutoModel;
import com.smartservice.core.port.saida.DeletaProdutoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Override
    public void deleteProdutosCrud(List<ProdutoModel> produtos) {
        for (ProdutoModel produtoModel:produtos
             ) {
            var possivelProduto = produtoRepository.findById(produtoModel.getId());
            if (possivelProduto.isEmpty()) throw new DeleteProdutoNaoExistenteException("O produto com id:"+ produtoModel.getId()+ " não existe");
        }

        for (ProdutoModel produtoModel:produtos
        ) {
            produtoRepository.deleteById(produtoModel.getId());
        }


    }
}
