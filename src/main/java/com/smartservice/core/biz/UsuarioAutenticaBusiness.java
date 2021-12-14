package com.smartservice.core.biz;

import com.smartservice.adapter.broker.mapper.UsuarioMapper;
import com.smartservice.adapter.datastore.repositories.UsuarioRepository;
import com.smartservice.core.port.entrada.UsuarioAutenticaPort;
import org.springframework.stereotype.Component;

@Component
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
    public void autenticaUsuario(String email, String senha){
        var userExists = repository.findByEmail(email);
        if (userExists.isEmpty()) throw new IllegalArgumentException("Usuario inexistente");
        var passMatchs = usuarioAutenticaPort.verificaSenha(senha,userExists.get().getPassword());
        if (!passMatchs) throw new IllegalArgumentException("Senha incorreta");
    }
}
