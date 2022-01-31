package com.smartservice.adapter.http.spring;

import com.smartservice.adapter.http.dto.ResponseData;
import com.smartservice.adapter.http.dto.entrada.AutenticaUsuarioRequest;
import com.smartservice.adapter.http.dto.saida.usuario.AutenticaUsuarioResponse;
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
                var response = port.autenticaUsuario(request.getEmail(), request.getPassword());
                return getResponseData(buildResponseData(response), HttpStatus.OK);
        }

        public ResponseEntity<ResponseData> getResponseData(ResponseData responseData, HttpStatus httpStatus){
                return new ResponseEntity<>(responseData,httpStatus);
        }

        private ResponseData buildResponseData(AutenticaUsuarioResponse autenticaUsuarioResponse){
                return new ResponseData(Collections.singletonList(autenticaUsuarioResponse));
        }
}
