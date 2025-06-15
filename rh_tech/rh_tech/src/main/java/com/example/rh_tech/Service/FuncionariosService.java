package com.example.rh_tech.Service;

import com.example.rh_tech.Model.FuncionariosModel;
import com.example.rh_tech.Repository.FuncionariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionariosService {

    @Autowired
    private FuncionariosRepository repository;

    public FuncionariosModel adicionarUsuario(FuncionariosModel funcionariosModel){
        return repository.save(funcionariosModel);
    }
    public List<FuncionariosModel> listarTodosUsuarios(){
        return repository.findAll();
    }
    public void deletarUsuario(Long id){
        repository.deleteById(id);
    }
    public FuncionariosModel atualizarUsuario(Long id, FuncionariosModel funcionariosModel) {
        FuncionariosModel usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setNome(funcionariosModel.getNome());
        usuario.setEmail(funcionariosModel.getEmail());

        return repository.save(usuario);
    }
    public Optional<FuncionariosModel> buscarPorId(Long id){
        return repository.findById(id);
    }
}
