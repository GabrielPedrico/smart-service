package com.smartservice.core.model.usuario;

import com.smartservice.core.model.enums.Perfil;

import java.util.UUID;

public class UsuarioModel {

    private UUID id;

    private String nome;

    private String email;

    private String password;

    private Perfil tipo;

    private String telefone;

    private String logradouro;

    private String numero;

    private String complemento;

    private String cep;

    private String bairro;

    private String cidade;

    private String estado;

    public UsuarioModel(UUID id, String nome, String email, String password, Perfil tipo, String telefone, String logradouro, String numero, String complemento, String cep, String bairro, String cidade, String estado) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.tipo = tipo;
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public UsuarioModel(){}

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Perfil getTipo() {
        return tipo;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCep() {
        return cep;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }
}
