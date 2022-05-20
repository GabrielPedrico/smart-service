package com.smartservice.adapter.broker.mapper;

import com.smartservice.adapter.datastore.entities.Usuario;
import com.smartservice.adapter.http.spring.dto.entrada.usuario.CadastraAdministradorRequest;
import com.smartservice.adapter.http.spring.dto.entrada.usuario.CadastraClienteRequest;
import com.smartservice.adapter.http.spring.dto.entrada.usuario.RequestEditaUsuario;
import com.smartservice.config.general.ModelMapperConfig;
import com.smartservice.core.model.usuario.UsuarioModel;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {


    private final ModelMapperConfig modelMapper;

    public UsuarioMapper(ModelMapperConfig modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Usuario converterParaUsuario(CadastraAdministradorRequest cadastraAdministradorRequest){
        cadastraAdministradorRequest.executaRotina();
        return this.modelMapper.modelMapper().map(cadastraAdministradorRequest,Usuario.class);
    }

    public Usuario converterParaUsuario(CadastraClienteRequest cadastraClienteRequest){
        cadastraClienteRequest.executaRotina();
        return this.modelMapper.modelMapper().map(cadastraClienteRequest,Usuario.class);
    }

    public Usuario converterParaUsuario(UsuarioModel request){
        return new Usuario(request.getNome(),request.getEmail(),request.getPassword(),request.getTipo(), request.getTelefone(),request.getLogradouro(),request.getNumero(),request.getComplemento(),request.getCep(),request.getBairro(),request.getCidade(),request.getEstado());
    }

    public UsuarioModel converterParaUsuarioModel(RequestEditaUsuario request){
        return new UsuarioModel(
                null,
                request.getNome(),
                request.getEmail(),
                request.getPassword(),
                null,
                request.getTelefone(),
                request.getLogradouro(),
                request.getNumero(),
                request.getComplemento(),
                request.getCep(),
                request.getBairro(),
                request.getCidade(),
                request.getEstado());
    }

    public ModelMapperConfig getModelMapper() {
        return modelMapper;
    }
}
