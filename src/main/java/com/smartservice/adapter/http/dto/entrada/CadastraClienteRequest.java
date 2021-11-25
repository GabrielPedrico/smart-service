package com.smartservice.adapter.http.dto.entrada;

import com.smartservice.core.model.Perfil;
import com.smartservice.core.model.Usuario;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

public class CadastraClienteRequest {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @Size(min = 6)
    private String password;

    @NotBlank
    private String telefone;

    @NotBlank
    private String logradouro;

    @NotBlank
    private String numero;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cep;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public CadastraClienteRequest(String nome, String email, String password, String telefone, String logradouro, String numero, String complemento, String cep, String bairro, String cidade, String estado) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Usuario toModel(){
        var _password = bCryptPasswordEncoder.encode(this.password);
        return new Usuario(this.nome,this.email,_password,Perfil.CLIENTE,this.telefone,this.logradouro,this.numero,this.complemento,this.cep,this.bairro,this.cidade,this.estado);
    }
}
