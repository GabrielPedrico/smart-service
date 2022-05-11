package com.smartservice.adapter.http.adapters;

import com.smartservice.adapter.datastore.entities.Categoria;
import com.smartservice.adapter.datastore.repositories.CategoriaRepository;
import com.smartservice.core.exceptions.CategoriaExistenteException;
import com.smartservice.core.exceptions.CategoriaNaoExistenteException;
import com.smartservice.core.port.saida.EditaCategoriaPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EditaCategoriaAdapter implements EditaCategoriaPort {


    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void editaCategoriaCrud(String categoria, String categoriaNova) {

        Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(categoria);
        if(possivelCategoria.isEmpty()) throw new CategoriaNaoExistenteException("Categoria inexistente, falha ao editar categoria.");
        Optional<Categoria> possivelCategoria2 = categoriaRepository.findByNome(categoriaNova);
        if (possivelCategoria2.isPresent()) throw new CategoriaExistenteException("Falha ao editar categoria, a categoria "+categoriaNova+" já existe em nossa base de dados.");

        possivelCategoria.get().setNome(categoriaNova.toUpperCase().replace(" ","_"));

        categoriaRepository.save(possivelCategoria.get());
    }
}
