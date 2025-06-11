package com.example.rh_tech.Repository;

import com.example.rh_tech.Model.FuncionariosPorCargoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionariosPorCargoRepository extends JpaRepository<FuncionariosPorCargoModel,Long> {

    List<FuncionariosPorCargoModel> findByCargo_id_Id(Long id);
    List<FuncionariosPorCargoModel> findByFuncionario_id_Id(Long funcionarioId);
}
