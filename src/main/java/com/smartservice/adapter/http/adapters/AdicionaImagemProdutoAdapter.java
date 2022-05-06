package com.smartservice.adapter.http.adapters;

import com.smartservice.adapter.datastore.entities.Produto;
import com.smartservice.adapter.datastore.repositories.ProdutoRepository;
import com.smartservice.core.exceptions.ProdutoNaoExistenteException;
import com.smartservice.core.port.saida.AdicionaImagemProdutoPort;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Component
public class AdicionaImagemProdutoAdapter implements AdicionaImagemProdutoPort {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void adicionaImagemProduto(MultipartFile imgUrl,String id) throws IOException {
        byte[] image = Base64.encodeBase64(imgUrl.getBytes());
        String result = new String(image);
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isEmpty()) throw new ProdutoNaoExistenteException("Produto inexistente para id: " + id);
        produto.get().setImgUrl(result);
        produtoRepository.save(produto.get());

    }
}
