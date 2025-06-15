package com.example.rh_tech.Controller;

import com.example.rh_tech.Model.FuncionariosModel;
import com.example.rh_tech.Service.FuncionariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/usuarios")
public class FuncionariosController {

    @Autowired
    FuncionariosService service;

    @PostMapping
    public FuncionariosModel salvarUsuario( @RequestBody FuncionariosModel funcionariosModel){
        return service.adicionarUsuario(funcionariosModel);
    }
    @GetMapping
    public List<FuncionariosModel> listarTodos(){
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
    public ResponseEntity<FuncionariosModel> atualizar (@PathVariable Long id, @RequestBody FuncionariosModel funcionariosModel){
        try{
            FuncionariosModel usuarioAtt = service.atualizarUsuario(id, funcionariosModel);
            return ResponseEntity.ok(usuarioAtt);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<FuncionariosModel> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
