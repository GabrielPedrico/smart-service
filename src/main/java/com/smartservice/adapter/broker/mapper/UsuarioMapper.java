package com.smartservice.adapter.broker.mapper;

import com.smartservice.adapter.datastore.entities.Usuario;
import com.smartservice.adapter.http.dto.entrada.usuario.CadastraAdministradorRequest;
import com.smartservice.adapter.http.dto.entrada.usuario.CadastraClienteRequest;
import com.smartservice.config.general.ModelMapperConfig;
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

    public ModelMapperConfig getModelMapper() {
        return modelMapper;
    }
}
