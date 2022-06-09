package com.smartservice.adapter.http.adapters.produto.categoria;

import com.smartservice.adapter.datastore.entities.Categoria;
import com.smartservice.adapter.datastore.repositories.CategoriaRepository;
import com.smartservice.config.general.Log4jConfig;
import com.smartservice.core.exceptions.CategoriaExistenteException;
import com.smartservice.core.port.saida.categoria.CadastraCategoriaPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Component
public class CadastraCategoriaAdapter implements CadastraCategoriaPort {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    Log4jConfig log;

    @Override
    public void cadastraCategoriaCrud(String categoria) {
        log.getLogger().info("[API] SMART-SERVICE [API] [ADAPTER] CADASTRANDO CATEGORIA...[ADAPTER]");
        log.getLogger().info("[API] SMART-SERVICE [API] [ADAPTER] VERIFICANDO SE CATEGORIA JÁ EXISTE...[ADAPTER]");
        Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(categoria.toUpperCase().replace(" ","_"));
        if(possivelCategoria.isPresent()) throw new CategoriaExistenteException("Falha ao cadastrar nova categoria, pois já existe essa categoria na nossa base de dados.");
        Categoria categoriaFinal = new Categoria(null, StringUtils.capitalize(categoria));
        categoriaRepository.save(categoriaFinal);
        log.getLogger().info("[API] SMART-SERVICE [API] [ADAPTER] CATEGORIA "+categoriaFinal+" CADASTRADA COM SUCESSO! [ADAPTER]");
    }
}
