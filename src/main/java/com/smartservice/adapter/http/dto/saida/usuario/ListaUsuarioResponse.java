package com.smartservice.adapter.http.dto.saida.usuario;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id","nivel_usuario","nome","email","telefone","logradouro","bairro","numero","complemento","cidade","estado","cep"})
public class ListaUsuarioResponse {

    private String id;

    private String nome;

    private String email;

    @JsonProperty("nivel_usuario")
    private String tipo;

    private String telefone;

    private String logradouro;

    private String numero;

    private String complemento;

    private String cep;

    private String bairro;

    private String cidade;

    private String estado;

    public ListaUsuarioResponse(String id, String nome, String email, String tipo, String telefone, String logradouro, String numero, String complemento, String cep, String bairro, String cidade, String estado) {
        this.id = id;
        this.nome = nome;
        this.email = email;
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

    @Deprecated
    public ListaUsuarioResponse(){}

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTipo() {
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
