package com.smartservice.core.port.saida.usuario;

import com.smartservice.adapter.http.spring.dto.entrada.usuario.CadastraAdministradorRequest;
import com.smartservice.adapter.http.spring.dto.entrada.usuario.CadastraClienteRequest;

public interface UsuarioCadastroPort {
     void cadastraCliente(CadastraClienteRequest request);
     void cadastraAdministrador(CadastraAdministradorRequest request);
}
