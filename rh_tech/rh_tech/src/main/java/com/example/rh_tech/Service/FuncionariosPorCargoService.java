package com.example.rh_tech.Service;

import com.example.rh_tech.Model.FuncionariosPorCargoModel;
import com.example.rh_tech.Repository.FuncionariosPorCargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionariosPorCargoService {

    @Autowired
    private FuncionariosPorCargoRepository repository;

    public FuncionariosPorCargoModel criarVinculo(FuncionariosPorCargoModel funcionariosPorCargoModel){
        return repository.save(funcionariosPorCargoModel);
    }

    public List<FuncionariosPorCargoModel> ListarTodos(){
        return repository.findAll();
    }

    public void Excluir(Long id){
        repository.deleteById(id);
    }

    public FuncionariosPorCargoModel Atualizar(Long id, FuncionariosPorCargoModel funcionariosPorCargoModel) {
        FuncionariosPorCargoModel funcionarioCargo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));

        funcionarioCargo.setCargo(funcionariosPorCargoModel.getCargo());
        funcionarioCargo.setFuncionario(funcionariosPorCargoModel.getFuncionario());

        return repository.save(funcionarioCargo);
    }
    public Optional<FuncionariosPorCargoModel> DetalharUm(Long id){
        return repository.findById(id);
    }

    public List<FuncionariosPorCargoModel> FiltrarPorCargo(Long cargoId) {
        return repository.findByCargo_Id(cargoId);
    }


    public List<FuncionariosPorCargoModel> FiltrarPorFuncionario(Long funcionarioId){
        return repository.findByFuncionario_Id(funcionarioId);
    }

    public List<FuncionariosPorCargoModel> FiltrarPorFuncionarioECargo(Long funcionarioId, Long cargoId) {
        return repository.findByFuncionario_IdAndCargo_Id(funcionarioId, cargoId);
    }



}
