package com.smartservice.adapter.http.spring;

import com.smartservice.adapter.http.dto.entrada.CadastraAdministradorRequest;
import com.smartservice.adapter.http.dto.entrada.CadastraClienteRequest;
import com.smartservice.core.port.UsuarioPort;
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
    private UsuarioPort port;

    @PostMapping(value = "/cadastra/cliente")
    @CrossOrigin
    ResponseEntity<?> cadastrarCliente(@RequestBody @Valid CadastraClienteRequest request){
        return port.cadastraCliente(request);
    }

    @PostMapping(value = "/cadastra/administrador")
    @CrossOrigin
    ResponseEntity<?> cadastrarAdministrador(@RequestBody @Valid CadastraAdministradorRequest request){
        return port.cadastraAdministrador(request);
    }
}
