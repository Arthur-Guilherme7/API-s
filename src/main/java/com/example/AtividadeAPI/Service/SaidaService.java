package com.example.AtividadeAPI.Service;

import com.example.AtividadeAPI.Model.SaidaModel;
import com.example.AtividadeAPI.Repository.SaidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaidaService {

    @Autowired
    private SaidaRepository repository;

    public List<SaidaModel> listar(){
        return repository.findAll();
    }
    public SaidaModel salvar(SaidaModel saidaModel){
        return repository.save(saidaModel);
    }

    public Optional<SaidaModel> buscarId(Long id){
        return repository.findById(id);
    }
}
