package com.smartservice.adapter.http.adapters.usuario;

import com.smartservice.config.security.BcryptConfig;
import com.smartservice.core.port.saida.usuario.UsuarioAutenticaPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioAutenticaAdapter implements UsuarioAutenticaPort {

    @Autowired
    public BcryptConfig bcryptConfig;

    @Override
    public Boolean verificaSenha(String senhaInformada,String senhaUsuario){
       return bcryptConfig.bCryptPasswordEncoder().matches(senhaInformada,senhaUsuario);
    }
}
