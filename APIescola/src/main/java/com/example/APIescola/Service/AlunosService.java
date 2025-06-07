package com.example.APIescola.Service;

import com.example.APIescola.Model.AlunosModel;
import com.example.APIescola.Repository.AlunosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunosService {

    private final AlunosRepository repository;

    public AlunosService(AlunosRepository repository) {
        this.repository = repository;
    }

    public List<AlunosModel> listar() {
        return repository.findAll();
    }

    public Optional<AlunosModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public AlunosModel salvar(AlunosModel alunosModel) {
        return repository.save(alunosModel);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
