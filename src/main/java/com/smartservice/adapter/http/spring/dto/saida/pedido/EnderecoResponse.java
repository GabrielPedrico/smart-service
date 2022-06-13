package com.smartservice.adapter.http.spring.dto.saida.pedido;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"logradouro","numero","bairro","complemento","cidade","estado","cep"})
public class EnderecoResponse {

    private String logradouro;
    private String numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String estado;
    private String cep;

    public EnderecoResponse(String logradouro, String numero, String bairro, String complemento, String cidade, String estado, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }
}
