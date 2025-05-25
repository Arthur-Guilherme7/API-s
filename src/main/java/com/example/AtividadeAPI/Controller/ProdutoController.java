package com.example.AtividadeAPI.Controller;

import com.example.AtividadeAPI.Model.ProdutoModel;
import com.example.AtividadeAPI.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<ProdutoModel> listar(){
        return service.listar();
    }

    @PostMapping
    public ProdutoModel salvar(@RequestBody ProdutoModel produtoModel){
        return service.salvar(produtoModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> buscarId(@PathVariable Long id){
        return service.buscarId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
