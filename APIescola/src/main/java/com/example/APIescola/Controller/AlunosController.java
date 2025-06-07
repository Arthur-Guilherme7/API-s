package com.example.APIescola.Controller;

import com.example.APIescola.Model.AlunosModel;
import com.example.APIescola.Service.AlunosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/alunos")
public class AlunosController {

    @Autowired
    private AlunosService service;

    @GetMapping
    public List<AlunosModel> listar(){
        return service.listar();
    }

    @PostMapping
    public AlunosModel salvar(@RequestBody AlunosModel alunosModel){
        return service.salvar(alunosModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunosModel> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        if (!service.buscarPorId(id).isPresent()) {

            return ResponseEntity.notFound().build();
        }

        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
