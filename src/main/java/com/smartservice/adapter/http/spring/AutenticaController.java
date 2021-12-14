package com.smartservice.adapter.http.spring;

import com.smartservice.adapter.http.dto.ResponseData;
import com.smartservice.adapter.http.dto.entrada.AutenticaUsuarioRequest;
import com.smartservice.adapter.http.dto.saida.usuario.CadastraUsuarioResponse;
import com.smartservice.core.port.entrada.UsuarioAutenticaPort;
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
public class AutenticaController {

        @Autowired
        private UsuarioAutenticaPort port;

        @PostMapping(value = "/auth")
        @CrossOrigin
        ResponseEntity<?> cadastrarCliente(@RequestBody @Valid AutenticaUsuarioRequest request) {
                port.autenticaUsuario(request.getEmail(), request.getPassword());
                return getResponseData(buildResponseData(buildAutenticarUsuarioResponse()), HttpStatus.OK);
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
