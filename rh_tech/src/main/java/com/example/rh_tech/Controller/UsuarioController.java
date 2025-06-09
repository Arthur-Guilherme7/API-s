package com.example.rh_tech.Controller;

import com.example.rh_tech.Model.UsuarioModel;
import com.example.rh_tech.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @PostMapping
    public UsuarioModel salvarUsuario(UsuarioModel usuarioModel){
        return service.adicionarUsuario(usuarioModel);
    }
    @GetMapping
    public List<UsuarioModel> listarTodos(){
        return service.listarTodosUsuarios();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id){
        try{
            service.deletarUsuario(id);
            return ResponseEntity.noContent().build();
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> atulizar (@PathVariable Long id, @RequestBody UsuarioModel usuarioModel){
        try{
            UsuarioModel usuarioAtt = service.atualizarUsuario(id,usuarioModel);
            return ResponseEntity.ok(usuarioAtt);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
