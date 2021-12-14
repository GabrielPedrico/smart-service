package com.smartservice.adapter.http.adapters;

import com.smartservice.adapter.broker.mapper.UsuarioMapper;
import com.smartservice.adapter.datastore.entities.Usuario;
import com.smartservice.adapter.datastore.repositories.UsuarioRepository;
import com.smartservice.adapter.http.dto.entrada.CadastraAdministradorRequest;
import com.smartservice.adapter.http.dto.entrada.CadastraClienteRequest;
import com.smartservice.core.port.saida.UsuarioCadastroPort;
import org.springframework.stereotype.Component;

@Component
public class UsuarioCadastroAdapter implements UsuarioCadastroPort {

    public final UsuarioRepository repository;
    public final UsuarioMapper usuarioMapper;

    public UsuarioCadastroAdapter(UsuarioRepository repository, UsuarioMapper usuarioMapper) {
        this.repository = repository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public void cadastraCliente(CadastraClienteRequest request){

        Usuario cliente = usuarioMapper.converterParaUsuario(request);
        repository.save(cliente);
    }

    @Override
    public void cadastraAdministrador(CadastraAdministradorRequest request){
        Usuario administrador = usuarioMapper.converterParaUsuario(request);
        repository.save(administrador);
    }
}
