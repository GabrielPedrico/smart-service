package com.smartservice.adapter.http.adapters.produto;

import com.smartservice.adapter.datastore.repositories.MesaRepository;
import com.smartservice.adapter.datastore.repositories.PedidoRepository;
import com.smartservice.adapter.datastore.repositories.ProdutoRepository;
import com.smartservice.core.exceptions.DeleteProdutoNaoExistenteException;
import com.smartservice.core.exceptions.ProdutoNaoExistenteException;
import com.smartservice.core.model.produto.ProdutoModel;
import com.smartservice.core.port.saida.produto.DeletaProdutoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeletaProdutoAdapter implements DeletaProdutoPort {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    MesaRepository mesaRepository;

    @Override
    @Transactional
    public void deleteCrud(String idProduto) {
        var produto = produtoRepository.findById(idProduto).orElseThrow(()-> new ProdutoNaoExistenteException("Produto inexistente."));
        produto.getPedidos().forEach(pedido -> {
            pedido.setProdutos(new ArrayList<>());
            pedidoRepository.save(pedido);
        });
        produto.getMesas().forEach(mesa -> {
            mesa.setProdutos(new ArrayList<>());
            mesaRepository.save(mesa);
        });
        produtoRepository.deleteById(idProduto);
    }

    @Override
    public void deleteProdutosCrud(List<ProdutoModel> produtos) {
        for (ProdutoModel produtoModel:produtos
             ) {
            var produto = produtoRepository.findById(produtoModel.getId()).orElseThrow(()-> new DeleteProdutoNaoExistenteException("O produto com id:"+ produtoModel.getId()+ " não existe"));
            produto.getPedidos().forEach(pedido -> {
                pedido.setProdutos(new ArrayList<>());
                pedidoRepository.save(pedido);
            });
            produto.getMesas().forEach(mesa -> {
                mesa.setProdutos(new ArrayList<>());
                mesaRepository.save(mesa);
            });
            produtoRepository.deleteById(produtoModel.getId());
        }

    }
}
