package com.smartservice.adapter.http.spring.usuario;

import com.smartservice.adapter.http.dto.ResponseData;
import com.smartservice.adapter.http.dto.entrada.CadastraAdministradorRequest;
import com.smartservice.adapter.http.dto.entrada.CadastraClienteRequest;
import com.smartservice.adapter.http.dto.saida.usuario.CadastraUsuarioResponse;
import com.smartservice.core.port.saida.UsuarioCadastroPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;


@RestController
public class CadastraUsuarioController {

    @Autowired
    private UsuarioCadastroPort port;

    @PostMapping(value = "/cadastra/cliente")
    @CrossOrigin
    ResponseEntity<?> cadastrarCliente(@RequestBody @Valid CadastraClienteRequest request){
        port.cadastraCliente(request);
        return getResponseData(buildResponseData(buildCadastraUsuarioResponse()), HttpStatus.CREATED);
    }

    @PostMapping(value = "/cadastra/administrador")
    @CrossOrigin
    ResponseEntity<?> cadastrarAdministrador(@RequestBody @Valid CadastraAdministradorRequest request){
        port.cadastraAdministrador(request);
        return getResponseData(buildResponseData(buildCadastraUsuarioResponse()), HttpStatus.CREATED);
    }

    public CadastraUsuarioResponse buildCadastraUsuarioResponse(){
        return new CadastraUsuarioResponse("PROCESSAMENTO OK");
    }

    public ResponseEntity<ResponseData> getResponseData(ResponseData responseData, HttpStatus httpStatus){
        return new ResponseEntity<>(responseData,httpStatus);
    }

    private ResponseData buildResponseData(CadastraUsuarioResponse cadastraUsuarioResponse){
        return new ResponseData(Collections.singletonList(cadastraUsuarioResponse));
    }
}
