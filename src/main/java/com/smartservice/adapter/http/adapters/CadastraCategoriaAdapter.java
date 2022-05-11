package com.smartservice.adapter.http.adapters;

import com.smartservice.adapter.datastore.entities.Categoria;
import com.smartservice.adapter.datastore.repositories.CategoriaRepository;
import com.smartservice.core.exceptions.CategoriaExistenteException;
import com.smartservice.core.exceptions.CategoriaNaoExistenteException;
import com.smartservice.core.port.saida.CadastraCategoriaPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CadastraCategoriaAdapter implements CadastraCategoriaPort {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public void cadastraCategoriaCrud(String categoria) {
        Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(categoria.toUpperCase().replace(" ","_"));
        if(possivelCategoria.isPresent()) throw new CategoriaExistenteException("Falha ao cadastrar nova categoria, pois já existe essa categoria na nossa base de dados.");
        Categoria categoriaFinal = new Categoria(null,categoria.toUpperCase().replace(" ","_"));
        categoriaRepository.save(categoriaFinal);
    }
}
