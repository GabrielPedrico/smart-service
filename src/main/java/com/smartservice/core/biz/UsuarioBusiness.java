package com.smartservice.core.biz;

import com.smartservice.adapter.broker.mapper.UsuarioMapper;
import com.smartservice.adapter.datastore.repositories.UsuarioRepository;
import com.smartservice.adapter.http.dto.ResponseData;
import com.smartservice.adapter.http.dto.entrada.CadastraAdministradorRequest;
import com.smartservice.adapter.http.dto.entrada.CadastraClienteRequest;
import com.smartservice.adapter.http.dto.saida.usuario.CadastraUsuarioResponse;
import com.smartservice.core.model.Usuario;
import com.smartservice.core.port.UsuarioPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class UsuarioBusiness implements UsuarioPort {

    @Autowired
    public UsuarioRepository repository;

    @Autowired
    public UsuarioMapper usuarioMapper;

    public BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<?> autenticaUsuario(String email, String senha){
        var userExists = repository.findByEmail(email);
        if (userExists.isEmpty()) throw new IllegalArgumentException("Usuario inexistente");
        var passMatchs = bCryptPasswordEncoder.matches(senha,userExists.get().getPassword());
        if (!passMatchs) throw new IllegalArgumentException("Senha incorreta");
        return getResponseData(buildResponseData(buildAutenticarUsuarioResponse()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> cadastraCliente(CadastraClienteRequest request){

        Usuario cliente = usuarioMapper.converterParaUsuario(request);
        repository.save(cliente);
        return getResponseData(buildResponseData(buildCadastraUsuarioResponse()), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> cadastraAdministrador(CadastraAdministradorRequest request){
        Usuario administrador = usuarioMapper.converterParaUsuario(request);
        repository.save(administrador);
        return getResponseData(buildResponseData(buildCadastraUsuarioResponse()), HttpStatus.CREATED);
    }

    public CadastraUsuarioResponse buildCadastraUsuarioResponse(){
            return new CadastraUsuarioResponse("PROCESSAMENTO OK");
    }

    public CadastraUsuarioResponse buildAutenticarUsuarioResponse(){
        return new CadastraUsuarioResponse("AUTENTICACAO OK");
    }

    public ResponseEntity<ResponseData> getResponseData(ResponseData responseData, HttpStatus httpStatus){
        return new ResponseEntity<>(responseData,httpStatus);
    }

    private ResponseData buildResponseData(CadastraUsuarioResponse cadastraUsuarioResponse){
        return new ResponseData(Collections.singletonList(cadastraUsuarioResponse));
    }
}
