package com.example.rh_tech.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity

@Table(name = "Funcionarios")
public class FuncionariosPorCargoModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        @ManyToOne
        @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
        private FuncionariosModel funcionario_id;


        @ManyToOne
        @JoinColumn(name = "cargo_id", referencedColumnName = "id")
        private CargoModel cargo_id;

        private String detalhes;

        @Column(name = "data_inicio")
        private Date dataInicio;

        @Column(name = "data_fim")
        private Date dataFim;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FuncionariosModel getFuncionario_id() {
        return funcionario_id;
    }

    public void setFuncionario_id(FuncionariosModel funcionario_id) {
        this.funcionario_id = funcionario_id;
    }

    public CargoModel getCargo_id() {
        return cargo_id;
    }

    public void setCargo_id(CargoModel cargo_id) {
        this.cargo_id = cargo_id;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
}
