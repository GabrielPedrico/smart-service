package com.smartservice.adapter.http.spring;

import com.smartservice.adapter.datastore.repositories.UsuarioRepository;
import com.smartservice.adapter.http.dto.entrada.CadastraAdministradorRequest;
import com.smartservice.adapter.http.dto.entrada.CadastraClienteRequest;
import com.smartservice.core.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CadastraUsuarioController {

    @Autowired
    public UsuarioRepository repository;

    @PostMapping(value = "/cadastra/cliente")
    @CrossOrigin
    ResponseEntity<?> cadastrarCliente(@RequestBody @Valid CadastraClienteRequest request){

        Usuario cliente = request.toModel();
        repository.save(cliente);
        return ResponseEntity.ok().body("Cliente " + cliente.getNome() + " cadastrado com sucesso!");
    }

    @PostMapping(value = "/cadastra/administrador")
    @CrossOrigin
    ResponseEntity<?> cadastrarAdministrador(@RequestBody @Valid CadastraAdministradorRequest request){

        Usuario administrador = request.toModel();
        repository.save(administrador);
        return ResponseEntity.ok().body("Administrador " + administrador.getNome() + " cadastrado com sucesso!");
    }
}
