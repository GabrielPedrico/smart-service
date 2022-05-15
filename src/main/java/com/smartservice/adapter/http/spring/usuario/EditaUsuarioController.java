package com.smartservice.adapter.http.spring.usuario;

import com.smartservice.adapter.broker.delivery.UsuarioService;
import com.smartservice.adapter.http.dto.DefaultResponse;
import com.smartservice.adapter.http.dto.ResponseData;
import com.smartservice.adapter.http.dto.entrada.usuario.RequestEditaUsuario;
import com.smartservice.core.model.usuario.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.Collections;

@RestController
public class EditaUsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/resetar_senha/{email}")
    @CrossOrigin
    ResponseEntity<?> resetaSenhaUsuario(@PathVariable("email") String email) throws MessagingException {
        usuarioService.usuarioEditaPort().resetarSenha(email);
        return getResponseData(buildResponseData(buildDefaultResponse()), HttpStatus.OK);
    }

    @PatchMapping("/edita/{email}")
    @CrossOrigin
    ResponseEntity<?> editaUsuario(@PathVariable("email") String email,@RequestBody @Valid RequestEditaUsuario request) throws MessagingException {
        UsuarioModel requestConvertido = usuarioService.usuarioMapper().converterParaUsuarioModel(request);
        usuarioService.usuarioEditaPort().editaUsuario(requestConvertido,email);
        return getResponseData(buildResponseData(buildDefaultResponse()), HttpStatus.OK);
    }

    public DefaultResponse buildDefaultResponse(){
        return new DefaultResponse("PROCESSAMENTO OK");
    }

    public ResponseEntity<ResponseData> getResponseData(ResponseData responseData, HttpStatus httpStatus){
        return new ResponseEntity<>(responseData,httpStatus);
    }

    private ResponseData buildResponseData(DefaultResponse defaultResponse){
        return new ResponseData(Collections.singletonList(defaultResponse));
    }
}
