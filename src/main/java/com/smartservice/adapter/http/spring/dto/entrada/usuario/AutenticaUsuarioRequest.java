package com.smartservice.adapter.http.spring.dto.entrada.usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AutenticaUsuarioRequest {

    @Email
    private String email;

    @NotBlank
    private String password;

    public AutenticaUsuarioRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "AutenticaUsuarioRequest{" +
                "email='" + email + '\'' +
                '}';
    }

    @Deprecated
    public AutenticaUsuarioRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
