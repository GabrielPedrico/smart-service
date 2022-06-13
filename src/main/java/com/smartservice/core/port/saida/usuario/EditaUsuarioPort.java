package com.smartservice.core.port.saida.usuario;

import com.smartservice.core.model.usuario.UsuarioModel;

public interface EditaUsuarioPort {

    void crudUpdateUsuario(UsuarioModel usuarioModel,String email);
}
