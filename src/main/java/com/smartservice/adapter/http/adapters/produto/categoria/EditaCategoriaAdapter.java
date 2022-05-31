package com.smartservice.adapter.http.adapters.produto.categoria;

import com.smartservice.adapter.datastore.entities.Categoria;
import com.smartservice.adapter.datastore.repositories.CategoriaRepository;
import com.smartservice.config.general.Log4jConfig;
import com.smartservice.core.exceptions.CategoriaExistenteException;
import com.smartservice.core.exceptions.CategoriaNaoExistenteException;
import com.smartservice.core.port.saida.categoria.EditaCategoriaPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EditaCategoriaAdapter implements EditaCategoriaPort {


    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private Log4jConfig log;

    @Override
    public void editaCategoriaCrud(String categoria, String categoriaNova) {
        log.getLogger().info("[API] SMART-SERVICE [API] [ADAPTER] EDITANDO CATEGORIA...[ADAPTER]");
        log.getLogger().info("[API] SMART-SERVICE [API] [ADAPTER] VERIFICANDO SE CATEGORIA P/ EDICAO EXISTE...[ADAPTER]");
        Categoria possivelCategoria = categoriaRepository.findByNome(categoria).orElseThrow(()-> new CategoriaNaoExistenteException("Categoria inexistente, falha ao editar categoria."));
        log.getLogger().info("[API] SMART-SERVICE [API] [ADAPTER] CATEGORIA ENCONTRADA, VERIFICANDO SE JÁ EXISTE CATEGORIA COM O NOVO NOME PRETENDIDO NA EDICAO...[ADAPTER]");
        Optional<Categoria> possivelCategoria2 = categoriaRepository.findByNome(categoriaNova);
        if (possivelCategoria2.isPresent()) throw new CategoriaExistenteException("Falha ao editar categoria, a categoria "+categoriaNova+" já existe em nossa base de dados.");
        log.getLogger().info("[API] SMART-SERVICE [API] [ADAPTER] CATEGORIA NOVA VALIDA PARA CADASTRO, EDITANDO CATEGORIA...[ADAPTER]");
        possivelCategoria.setNome(categoriaNova.toUpperCase().replace(" ","_"));

        categoriaRepository.save(possivelCategoria);
        log.getLogger().info("[API] SMART-SERVICE [API] [ADAPTER] CATEGORIA EDITADA COM SUCESSO! [ADAPTER]");
    }
}
