package com.smartservice.adapter.broker.delivery;

import com.smartservice.adapter.broker.mapper.UsuarioMapper;
import com.smartservice.core.port.entrada.usuario.UsuarioAutenticaPort;
import com.smartservice.core.port.entrada.usuario.UsuarioEditaPort;
import com.smartservice.core.port.entrada.usuario.UsuarioListaPort;
import com.smartservice.core.port.saida.usuario.UsuarioCadastroPort;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioCadastroPort usuarioCadastroPort;

    private final UsuarioAutenticaPort usuarioAutenticaPort;

    private final UsuarioMapper usuarioMapper;

    private final UsuarioEditaPort usuarioEditaPort;

    private final UsuarioListaPort usuarioListaPort;

    public UsuarioService(UsuarioCadastroPort usuarioCadastroPort, UsuarioAutenticaPort usuarioAutenticaPort, UsuarioMapper usuarioMapper,UsuarioEditaPort usuarioEditaPort,UsuarioListaPort usuarioListaPort) {
        this.usuarioEditaPort = usuarioEditaPort;
        this.usuarioCadastroPort = usuarioCadastroPort;
        this.usuarioAutenticaPort = usuarioAutenticaPort;
        this.usuarioMapper = usuarioMapper;
        this.usuarioListaPort = usuarioListaPort;
    }

    public UsuarioCadastroPort usuarioCadastroPort() {
        return usuarioCadastroPort;
    }

    public UsuarioAutenticaPort usuarioAutenticaPort() {
        return usuarioAutenticaPort;
    }

    public UsuarioMapper usuarioMapper() {
        return usuarioMapper;
    }

    public UsuarioEditaPort usuarioEditaPort() {
        return usuarioEditaPort;
    }

    public UsuarioListaPort usuarioListaPort() {
        return usuarioListaPort;
    }
}
