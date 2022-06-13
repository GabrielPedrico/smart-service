package com.smartservice.adapter.http.spring.dto.entrada.usuario;

import com.smartservice.core.model.enums.Perfil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CadastraAdministradorRequest {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @Size(min = 6)
    private String password;


    private Perfil tipo;

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

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public CadastraAdministradorRequest(String nome, String email, String password, String telefone, String logradouro, String numero, String complemento, String cep, String bairro, String cidade, String estado) {
        this.nome = nome;
        this.email = email;
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
    public CadastraAdministradorRequest (){}

    public void executaRotina(){
        this.password = bCryptPasswordEncoder.encode(this.password);
        this.tipo = Perfil.ADMINISTRADOR;
    }

    @Override
    public String toString() {
        return "CadastraAdministradorRequest{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tipo=" + tipo +
                ", telefone='" + telefone + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cep='" + cep + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", bCryptPasswordEncoder=" + bCryptPasswordEncoder +
                '}';
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

    public Perfil getTipo() {
        return tipo;
    }
}
