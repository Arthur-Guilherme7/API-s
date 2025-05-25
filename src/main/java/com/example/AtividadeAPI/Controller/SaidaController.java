package com.example.AtividadeAPI.Controller;

import com.example.AtividadeAPI.Model.ProdutoModel;
import com.example.AtividadeAPI.Model.SaidaModel;
import com.example.AtividadeAPI.Service.ProdutoService;
import com.example.AtividadeAPI.Service.SaidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/saidas")
public class SaidaController {
    @Autowired
    private SaidaService service;

    @GetMapping
    public List<SaidaModel> listar(){
        return service.listar();
    }

    @PostMapping
    public SaidaModel salvar(@RequestBody SaidaModel saidaModel){
        return service.salvar(saidaModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaidaModel> buscarId(@PathVariable Long id){
        return service.buscarId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
