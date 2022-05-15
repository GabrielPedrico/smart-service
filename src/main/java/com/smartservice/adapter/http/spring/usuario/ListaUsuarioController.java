package com.smartservice.adapter.http.spring.usuario;

import com.smartservice.adapter.broker.delivery.UsuarioService;
import com.smartservice.adapter.http.dto.ResponseData;
import com.smartservice.adapter.http.dto.saida.usuario.ListaUsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.Collections;

@RestController
public class ListaUsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuario/{id}")
    @CrossOrigin
    ResponseEntity<?> listaUsuarioById(@PathVariable("id") String id) throws MessagingException {
        ListaUsuarioResponse response= usuarioService.usuarioListaPort().listaUsuario(id);
        return getResponseData(buildResponseData(response), HttpStatus.OK);
    }

    public ResponseEntity<ResponseData> getResponseData(ResponseData responseData, HttpStatus httpStatus){
        return new ResponseEntity<>(responseData,httpStatus);
    }

    private ResponseData buildResponseData(ListaUsuarioResponse listaUsuarioResponse){
        return new ResponseData(Collections.singletonList(listaUsuarioResponse));
    }
}
