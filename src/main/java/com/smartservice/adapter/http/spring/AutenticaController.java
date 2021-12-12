package com.smartservice.adapter.http.spring;

import com.smartservice.adapter.http.dto.entrada.AutenticaUsuarioRequest;
import com.smartservice.core.port.UsuarioPort;
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
        private UsuarioPort port;

        @PostMapping(value = "/auth")
        @CrossOrigin
        ResponseEntity<?> cadastrarCliente(@RequestBody @Valid AutenticaUsuarioRequest request) {
            return port.autenticaUsuario(request.getEmail(), request.getPassword());
        }
}
