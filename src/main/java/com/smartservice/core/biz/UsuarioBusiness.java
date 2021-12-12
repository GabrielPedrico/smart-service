package com.smartservice.core.biz;

import com.smartservice.adapter.datastore.repositories.UsuarioRepository;
import com.smartservice.adapter.http.dto.entrada.CadastraAdministradorRequest;
import com.smartservice.adapter.http.dto.entrada.CadastraClienteRequest;
import com.smartservice.core.model.Usuario;
import com.smartservice.core.port.UsuarioPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioBusiness implements UsuarioPort {

    @Autowired
    public UsuarioRepository repository;

    public BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<?> autenticaUsuario(String email, String senha){
        var userExists = repository.findByEmail(email);
        if (userExists.isEmpty()) throw new IllegalArgumentException("Usuario inexistente");
        var passMatchs = bCryptPasswordEncoder.matches(senha,userExists.get().getPassword());
        if (!passMatchs) throw new IllegalArgumentException("Senha incorreta");
        return ResponseEntity.ok().body("Autenticação Ok");
    }

    @Override
    public ResponseEntity<?> cadastraCliente(CadastraClienteRequest request){

        Usuario cliente = request.toModel();
        repository.save(cliente);
        return ResponseEntity.ok().body("Cliente " + cliente.getNome() + " cadastrado com sucesso!");
    }

    @Override
    public ResponseEntity<?> cadastraAdministrador(CadastraAdministradorRequest request){
        Usuario administrador = request.toModel();
        repository.save(administrador);
        return ResponseEntity.ok().body("Administrador " + administrador.getNome() + " cadastrado com sucesso!");
    }
}
