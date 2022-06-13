package com.smartservice.adapter.http.adapters.produto.categoria;

import com.smartservice.adapter.datastore.entities.Categoria;
import com.smartservice.adapter.datastore.repositories.CategoriaRepository;
import com.smartservice.adapter.http.spring.dto.saida.produto.categoria.ConsultaCategoriasResponse;
import com.smartservice.config.annotations.AdapterUseCase;
import com.smartservice.config.general.Log4jConfig;
import com.smartservice.core.port.saida.categoria.ConsultaCategoriasPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@AdapterUseCase
public class ConsultaCategoriasAdapter implements ConsultaCategoriasPort {

    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    Log4jConfig log;
    @Override
    public ConsultaCategoriasResponse consultarCategoriasDB() {
        log.getLogger().info("[API] SMART-SERVICE [API] [ADAPTER] RESGATANDO CATEGORIAS...[ADAPTER]");
        List<Categoria> categorias = categoriaRepository.findAll();
        List<String> categoriasNomes = new ArrayList<>();
        for (Categoria categoria:categorias
             ) {
            categoriasNomes.add(categoria.getNome());
        }
        log.getLogger().info("[API] SMART-SERVICE [API] [ADAPTER] CATEGORIAS RESGATADAS COM SUCESSO! [ADAPTER]");
        return new ConsultaCategoriasResponse(categoriasNomes);
    }
}
