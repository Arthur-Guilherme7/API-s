package com.example.rh_tech.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity

@Table(name = "funcionarios_por_cargo")
public class FuncionariosPorCargoModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        @ManyToOne
        @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
        private FuncionariosModel funcionario;


        @ManyToOne
        @JoinColumn(name = "cargo_id", referencedColumnName = "id")
        private CargoModel cargo;

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

    public FuncionariosModel getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionariosModel funcionario) {
        this.funcionario = funcionario;
    }

    public CargoModel getCargo() {
        return cargo;
    }

    public void setCargo(CargoModel cargo) {
        this.cargo = cargo;
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
