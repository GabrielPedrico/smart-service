package com.smartservice.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "whatsapp")
public class WppProperties {

    private String api;
    private String telefone;

    public WppProperties(String api, String telefone) {
        this.api = api;
        this.telefone = telefone;
    }

    @Deprecated
    public WppProperties(){}

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
