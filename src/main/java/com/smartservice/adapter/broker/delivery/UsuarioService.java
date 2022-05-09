package com.smartservice.adapter.broker.delivery;

import com.smartservice.adapter.broker.mapper.UsuarioMapper;
import com.smartservice.core.port.entrada.UsuarioAutenticaPort;
import com.smartservice.core.port.entrada.UsuarioEditaPort;
import com.smartservice.core.port.saida.UsuarioCadastroPort;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioCadastroPort usuarioCadastroPort;

    private final UsuarioAutenticaPort usuarioAutenticaPort;

    private final UsuarioMapper usuarioMapper;

    private final UsuarioEditaPort usuarioEditaPort;

    public UsuarioService(UsuarioCadastroPort usuarioCadastroPort, UsuarioAutenticaPort usuarioAutenticaPort, UsuarioMapper usuarioMapper,UsuarioEditaPort usuarioEditaPort) {
        this.usuarioEditaPort = usuarioEditaPort;
        this.usuarioCadastroPort = usuarioCadastroPort;
        this.usuarioAutenticaPort = usuarioAutenticaPort;
        this.usuarioMapper = usuarioMapper;
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
}
