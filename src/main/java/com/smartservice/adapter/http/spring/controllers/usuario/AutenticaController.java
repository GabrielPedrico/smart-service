package com.smartservice.adapter.http.spring.controllers.usuario;

import com.smartservice.adapter.broker.delivery.UsuarioService;
import com.smartservice.adapter.http.spring.dto.ResponseData;
import com.smartservice.adapter.http.spring.dto.entrada.usuario.AutenticaUsuarioRequest;
import com.smartservice.adapter.http.spring.dto.saida.usuario.AutenticaUsuarioResponse;
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
        private UsuarioService usuarioService;

        @PostMapping(value = "/auth")
        @CrossOrigin
        ResponseEntity<?> autentica(@RequestBody @Valid AutenticaUsuarioRequest request) {
                var response = usuarioService.usuarioAutenticaPort().autenticaUsuario(request.getEmail(), request.getPassword());
                return getResponseData(buildResponseData(response), HttpStatus.OK);
        }

        public ResponseEntity<ResponseData> getResponseData(ResponseData responseData, HttpStatus httpStatus){
                return new ResponseEntity<>(responseData,httpStatus);
        }

        private ResponseData buildResponseData(AutenticaUsuarioResponse autenticaUsuarioResponse){
                return new ResponseData(Collections.singletonList(autenticaUsuarioResponse));
        }
}
