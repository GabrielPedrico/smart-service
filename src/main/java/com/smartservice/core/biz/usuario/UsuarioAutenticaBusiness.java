package com.smartservice.core.biz.usuario;

import com.smartservice.adapter.broker.mapper.UsuarioMapper;
import com.smartservice.adapter.datastore.repositories.UsuarioRepository;
import com.smartservice.adapter.http.dto.saida.usuario.AutenticaUsuarioResponse;
import com.smartservice.config.annotations.AdapterUseCase;
import com.smartservice.core.exceptions.UsuarioNaoAutorizadoException;
import com.smartservice.core.exceptions.UsuarioNaoExistenteException;
import com.smartservice.core.port.entrada.UsuarioAutenticaPort;

@AdapterUseCase
public class UsuarioAutenticaBusiness implements UsuarioAutenticaPort {


    public final UsuarioRepository repository;
    public final UsuarioMapper usuarioMapper;
    public final com.smartservice.core.port.saida.UsuarioAutenticaPort usuarioAutenticaPort;

    public UsuarioAutenticaBusiness(UsuarioRepository repository, UsuarioMapper usuarioMapper, com.smartservice.core.port.saida.UsuarioAutenticaPort usuarioAutenticaPort) {
        this.repository = repository;
        this.usuarioMapper = usuarioMapper;
        this.usuarioAutenticaPort = usuarioAutenticaPort;
    }

    @Override
    public AutenticaUsuarioResponse autenticaUsuario(String email, String senha){
        var userExists = repository.findByEmail(email);
        if (userExists.isEmpty()) throw new UsuarioNaoExistenteException("Usuario inexistente");
        var passMatchs = usuarioAutenticaPort.verificaSenha(senha,userExists.get().getPassword());
        if (!passMatchs) throw new UsuarioNaoAutorizadoException("Senha incorreta");
        return new AutenticaUsuarioResponse("AUTENTICACAO OK",userExists.get().getNome(),userExists.get().getTipo().toString());
    }
}
