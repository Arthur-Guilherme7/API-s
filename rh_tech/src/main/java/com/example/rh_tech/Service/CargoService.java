package com.example.rh_tech.Service;

import com.example.rh_tech.Model.CargoModel;
import com.example.rh_tech.Model.UsuarioModel;
import com.example.rh_tech.Repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {

    private CargoRepository repository;

    public CargoModel AdicionarUsuario(CargoModel cargoModel){
        return repository.save(cargoModel);
    }

    public List<CargoModel> ListarTodosUsuarios(){
        return repository.findAll();
    }

    public void DeletarUsuario(Long id){
        repository.deleteById(id);
    }
    public CargoModel AtualizarUsuario(Long id, CargoModel cargoModel) {
        CargoModel cargo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        cargo.setNome_cargo(cargoModel.getNome_cargo());
        cargo.setId_cargo(cargoModel.getId_cargo());

        return repository.save(cargo);
    }
    public Optional<CargoModel> BuscarPorId(Long id){
        return repository.findById(id);
    }
}
