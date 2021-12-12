package com.smartservice.core.port;

import com.smartservice.adapter.http.dto.entrada.CadastraAdministradorRequest;
import com.smartservice.adapter.http.dto.entrada.CadastraClienteRequest;
import org.springframework.http.ResponseEntity;

public interface UsuarioPort {
    ResponseEntity<?> autenticaUsuario(String email, String senha);
    ResponseEntity<?> cadastraCliente(CadastraClienteRequest request);
    ResponseEntity<?> cadastraAdministrador(CadastraAdministradorRequest request);
}
