package com.smartservice.core.biz;

import com.smartservice.adapter.datastore.repositories.UsuarioRepository;
import com.smartservice.core.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioBusiness {

    @Autowired
    public UsuarioRepository usuarioRepository;

    public BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public void autenticaUsuario(String email, String senha){
        var userExists = usuarioRepository.findByEmail(email);
        if (userExists.isEmpty()) throw new IllegalArgumentException("Usuario inexistente");
        var passMatchs = bCryptPasswordEncoder.matches(senha,userExists.get().getPassword());
        if (!passMatchs) throw new IllegalArgumentException("Senha incorreta");
    }
}
