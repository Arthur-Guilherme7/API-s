package com.example.AtividadeAPI.Service;

import com.example.AtividadeAPI.Model.SaidaModel;
import com.example.AtividadeAPI.Model.UsuarioModel;
import com.example.AtividadeAPI.Repository.SaidaRepository;
import com.example.AtividadeAPI.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<UsuarioModel> listar(){
        return repository.findAll();
    }
    public UsuarioModel salvar(UsuarioModel usuarioModel){
        return repository.save(usuarioModel);
    }

    public Optional<UsuarioModel> buscarId(Long id){
        return repository.findById(id);
    }
}
