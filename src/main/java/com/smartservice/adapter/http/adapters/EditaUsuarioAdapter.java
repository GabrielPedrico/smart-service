package com.smartservice.adapter.http.adapters;

import com.smartservice.adapter.broker.mapper.UsuarioMapper;
import com.smartservice.adapter.datastore.entities.Produto;
import com.smartservice.adapter.datastore.entities.Usuario;
import com.smartservice.adapter.datastore.repositories.UsuarioRepository;
import com.smartservice.config.security.BcryptConfig;
import com.smartservice.core.exceptions.ProdutoNaoExistenteException;
import com.smartservice.core.exceptions.UsuarioNaoExistenteException;
import com.smartservice.core.model.usuario.UsuarioModel;
import com.smartservice.core.port.saida.EditaUsuarioPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EditaUsuarioAdapter implements EditaUsuarioPort {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    public BCryptPasswordEncoder bCrypt;

    @Override
    public void crudUpdateUsuario(UsuarioModel usuarioModel,String email) {
        Optional<Usuario> possivelUsuario = usuarioRepository.findByEmail(email);
        if(possivelUsuario.isEmpty()) throw new UsuarioNaoExistenteException("Usuário não cadastrado na nossa base de dados.");

        Usuario usuarioFinal = usuarioMapper.converterParaUsuario(usuarioModel);

        if(usuarioFinal.getId() == null) usuarioFinal.setId(possivelUsuario.get().getId());
        if(usuarioFinal.getNome().isBlank()) usuarioFinal.setNome(possivelUsuario.get().getNome());
        if(usuarioFinal.getTipo() == null) usuarioFinal.setTipo(possivelUsuario.get().getTipo());
        if(usuarioFinal.getBairro().isBlank()) usuarioFinal.setBairro(possivelUsuario.get().getBairro());
    if(usuarioFinal.getLogradouro().isBlank()) usuarioFinal.setLogradouro(possivelUsuario.get().getLogradouro());
        if(usuarioFinal.getNumero().isBlank()) usuarioFinal.setNumero(possivelUsuario.get().getNumero());
        if(usuarioFinal.getEmail().isBlank()) usuarioFinal.setEmail(possivelUsuario.get().getEmail());
        if(usuarioFinal.getTelefone().isBlank()) usuarioFinal.setTelefone(possivelUsuario.get().getTelefone());
        if(usuarioFinal.getCep().isBlank()) usuarioFinal.setCep(possivelUsuario.get().getCep());
        if(usuarioFinal.getComplemento().isBlank()) usuarioFinal.setComplemento(possivelUsuario.get().getComplemento());
        if(usuarioFinal.getEstado().isBlank()) usuarioFinal.setEstado(possivelUsuario.get().getEstado());
        if(usuarioFinal.getNome().isBlank()) usuarioFinal.setNome(possivelUsuario.get().getNome());
        if(!usuarioFinal.getPassword().isBlank()) usuarioFinal.setPassword(bCrypt.encode(possivelUsuario.get().getPassword()));
        if(usuarioFinal.getPassword().isBlank()) usuarioFinal.setPassword(possivelUsuario.get().getPassword());
        if(usuarioFinal.getCidade().isBlank()) usuarioFinal.setCidade(possivelUsuario.get().getCidade());

        usuarioRepository.save(usuarioFinal);

    }
}
