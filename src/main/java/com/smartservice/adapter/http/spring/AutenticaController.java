package com.smartservice.adapter.http.spring;

import com.smartservice.adapter.datastore.repositories.UsuarioRepository;
import com.smartservice.adapter.http.dto.entrada.AutenticaUsuarioRequest;
import com.smartservice.core.biz.UsuarioBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AutenticaController {

        @Autowired
        public UsuarioRepository repository;

        @Autowired
        public UsuarioBusiness usuarioBusiness;

        @PostMapping(value = "/auth")
        @CrossOrigin
        ResponseEntity<?> cadastrarCliente(@RequestBody @Valid AutenticaUsuarioRequest request) {
            usuarioBusiness.autenticaUsuario(request.getEmail(),request.getPassword());
            return ResponseEntity.ok().build();
        }
}
