package com.smartservice.adapter.http.adapters.usuario;

import com.smartservice.adapter.datastore.entities.Usuario;
import com.smartservice.adapter.datastore.repositories.UsuarioRepository;
import com.smartservice.adapter.http.spring.dto.saida.usuario.ListaUsuarioResponse;
import com.smartservice.core.exceptions.UsuarioNaoExistenteException;
import com.smartservice.core.port.saida.usuario.UsuarioListaPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioListaAdapter implements UsuarioListaPort {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public ListaUsuarioResponse resgataUsuarioDB(String id) {
        Usuario possivelUsuario = usuarioRepository.findById(id).orElseThrow(()-> new UsuarioNaoExistenteException("Usuário não encontrado na nossa base de dados."));
        return new ListaUsuarioResponse(possivelUsuario.getId(),possivelUsuario.getNome(),possivelUsuario.getEmail(),possivelUsuario.getTipo().toString(),possivelUsuario.getTelefone(),possivelUsuario.getLogradouro(), possivelUsuario.getNumero(), possivelUsuario.getComplemento(), possivelUsuario.getCep(), possivelUsuario.getBairro(), possivelUsuario.getCidade(), possivelUsuario.getEstado());
    }
}
