package com.smartservice.core.port.saida;

import com.smartservice.adapter.http.dto.entrada.usuario.CadastraAdministradorRequest;
import com.smartservice.adapter.http.dto.entrada.usuario.CadastraClienteRequest;

public interface UsuarioCadastroPort {
     void cadastraCliente(CadastraClienteRequest request);
     void cadastraAdministrador(CadastraAdministradorRequest request);
}
