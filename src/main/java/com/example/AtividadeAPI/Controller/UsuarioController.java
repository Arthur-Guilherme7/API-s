package com.example.AtividadeAPI.Controller;

import com.example.AtividadeAPI.Model.ProdutoModel;
import com.example.AtividadeAPI.Model.UsuarioModel;
import com.example.AtividadeAPI.Service.ProdutoService;
import com.example.AtividadeAPI.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<UsuarioModel> listar(){
        return service.listar();
    }

    @PostMapping
    public UsuarioModel salvar(@RequestBody UsuarioModel usuarioModel){
        return service.salvar(usuarioModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> buscarId(@PathVariable Long id){
        return service.buscarId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
