package com.example.rh_tech.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CargoModel {
    @Id

    @GeneratedValue
            (strategy = GenerationType.IDENTITY)

    private Long id_cargo;
    private String nome_cargo;
    private String descricao_cargo;

    public Long getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(Long id_cargo) {
        this.id_cargo = id_cargo;
    }

    public String getNome_cargo() {
        return nome_cargo;
    }

    public void setNome_cargo(String nome_cargo) {
        this.nome_cargo = nome_cargo;
    }

    public String getDescricao_cargo() {
        return descricao_cargo;
    }

    public void setDescricao_cargo(String descricao_cargo) {
        this.descricao_cargo = descricao_cargo;
    }
}
