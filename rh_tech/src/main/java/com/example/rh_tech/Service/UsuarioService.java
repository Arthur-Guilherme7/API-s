package com.example.rh_tech.Service;

import com.example.rh_tech.Model.UsuarioModel;
import com.example.rh_tech.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioModel adicionarUsuario(UsuarioModel usuarioModel){
        return repository.save(usuarioModel);
    }
    public List<UsuarioModel> listarTodosUsuarios(){
        return repository.findAll();
    }
    public void deletarUsuario(Long id){
        repository.deleteById(id);
    }
    public UsuarioModel atualizarUsuario(Long id, UsuarioModel usuarioModel) {
        UsuarioModel usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setNome(usuarioModel.getNome());
        usuario.setEmail(usuarioModel.getEmail());

        return repository.save(usuario);
    }
    public Optional<UsuarioModel> buscarPorId(Long id){
        return repository.findById(id);
    }
}
