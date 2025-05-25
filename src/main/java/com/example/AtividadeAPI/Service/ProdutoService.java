package com.example.AtividadeAPI.Service;


import com.example.AtividadeAPI.Model.ProdutoModel;
import com.example.AtividadeAPI.Repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoModel> listar(){
        return repository.findAll();
    }
    public ProdutoModel salvar(ProdutoModel produtoModel){
        return repository.save(produtoModel);
    }

    public Optional<ProdutoModel> buscarId(Long id){
        return repository.findById(id);

    }
}
