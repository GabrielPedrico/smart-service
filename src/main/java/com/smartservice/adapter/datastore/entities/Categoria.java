package com.smartservice.adapter.datastore.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(unique = true,columnDefinition="VARCHAR(40)")
    private String id;

    @Column(unique = true)
    private String nome;

    public Categoria(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Deprecated
    public Categoria(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
