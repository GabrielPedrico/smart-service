package com.smartservice.adapter.http.adapters.produto.categoria;

import com.smartservice.adapter.datastore.entities.Categoria;
import com.smartservice.adapter.datastore.repositories.CategoriaRepository;
import com.smartservice.adapter.http.spring.dto.saida.produto.categoria.ConsultaCategoriasResponse;
import com.smartservice.config.annotations.AdapterUseCase;
import com.smartservice.core.port.saida.categoria.ConsultaCategoriasPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@AdapterUseCase
public class ConsultaCategoriasAdapter implements ConsultaCategoriasPort {

    @Autowired
    CategoriaRepository categoriaRepository;
    @Override
    public ConsultaCategoriasResponse consultarCategoriasDB() {
        List<Categoria> categorias = categoriaRepository.findAll();
        List<String> categoriasNomes = new ArrayList<>();
        for (Categoria categoria:categorias
             ) {
            categoriasNomes.add(categoria.getNome());
        }
        return new ConsultaCategoriasResponse(categoriasNomes);
    }
}
