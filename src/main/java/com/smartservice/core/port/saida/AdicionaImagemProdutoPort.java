package com.smartservice.core.port.saida;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AdicionaImagemProdutoPort {

    void adicionaImagemProduto(MultipartFile imgUrl,String id) throws IOException;
}
