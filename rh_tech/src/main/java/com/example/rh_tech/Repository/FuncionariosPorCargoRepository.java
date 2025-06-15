package com.example.rh_tech.Repository;

import com.example.rh_tech.Model.FuncionariosPorCargoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionariosPorCargoRepository extends JpaRepository<FuncionariosPorCargoModel,Long> {

    List<FuncionariosPorCargoModel> findByCargo_Id(Long cargoId);
    List<FuncionariosPorCargoModel> findByFuncionario_Id(Long funcionarioId);
    List<FuncionariosPorCargoModel> findByFuncionario_IdAndCargo_Id(Long funcionarioId, Long cargoId);

}
