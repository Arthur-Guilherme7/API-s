package com.example.AtividadeAPI.Repository;

import com.example.AtividadeAPI.Model.SaidaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



    @Repository
    public interface SaidaRepository extends JpaRepository<SaidaModel, Long>{

    }

