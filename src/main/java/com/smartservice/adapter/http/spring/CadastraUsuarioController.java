package com.smartservice.adapter.http.spring;

import com.smartservice.adapter.datastore.entity.UsuarioRepository;
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

    @PostMapping
    @CrossOrigin
    ResponseEntity<?> cadastrar(@RequestBody @Valid Usuario request){

        Usuario usuario = request;

        repository.save(request);

        return ResponseEntity.ok().body(request.toString());
    }
}
