package com.example.rh_tech.Service;

import com.example.rh_tech.Model.CargoModel;
import com.example.rh_tech.Repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {

    @Autowired
    private CargoRepository repository;

    public CargoModel AdicionarCargo(CargoModel cargoModel) {
        return repository.save(cargoModel);
    }

    public List<CargoModel> ListarTodos() {
        return repository.findAll();
    }

    public void DeletarCargo(Long id) {
        repository.deleteById(id);
    }

    public CargoModel AtualizarCargo(Long id, CargoModel cargoModel) {
        CargoModel cargo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cargo não encontrado"));

        cargo.setNome(cargoModel.getNome());
        cargo.setDescricao(cargoModel.getDescricao());

        return repository.save(cargo);
    }

    public Optional<CargoModel> BuscarPorId(Long id) {
        return repository.findById(id);
    }
}
