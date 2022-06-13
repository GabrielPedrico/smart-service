package com.smartservice.core.biz.usuario;

import com.smartservice.adapter.broker.mapper.UsuarioMapper;
import com.smartservice.adapter.datastore.repositories.UsuarioRepository;
import com.smartservice.adapter.http.spring.dto.saida.usuario.AutenticaUsuarioResponse;
import com.smartservice.config.annotations.AdapterUseCase;
import com.smartservice.core.exceptions.UsuarioNaoAutorizadoException;
import com.smartservice.core.exceptions.UsuarioNaoExistenteException;
import com.smartservice.core.port.entrada.usuario.UsuarioAutenticaPort;

@AdapterUseCase
public class UsuarioAutenticaBusiness implements UsuarioAutenticaPort {


    public final UsuarioRepository repository;
    public final UsuarioMapper usuarioMapper;
    public final com.smartservice.core.port.saida.usuario.UsuarioAutenticaPort usuarioAutenticaPort;

    public UsuarioAutenticaBusiness(UsuarioRepository repository, UsuarioMapper usuarioMapper, com.smartservice.core.port.saida.usuario.UsuarioAutenticaPort usuarioAutenticaPort) {
        this.repository = repository;
        this.usuarioMapper = usuarioMapper;
        this.usuarioAutenticaPort = usuarioAutenticaPort;
    }

    @Override
    public AutenticaUsuarioResponse autenticaUsuario(String email, String senha){
        var userExists = repository.findByEmail(email).orElseThrow(()-> new UsuarioNaoExistenteException("Usuario inexistente"));
        var passMatchs = usuarioAutenticaPort.verificaSenha(senha,userExists.getPassword());
        if (Boolean.FALSE.equals(passMatchs)) throw new UsuarioNaoAutorizadoException("Senha incorreta");
        return new AutenticaUsuarioResponse("AUTENTICACAO OK",userExists.getNome(),userExists.getTipo().toString(),userExists.getId());
    }
}
