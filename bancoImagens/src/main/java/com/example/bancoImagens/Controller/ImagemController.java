package com.example.bancoImagens.Controller;

import com.example.bancoImagens.Model.ImagemModel;
import com.example.bancoImagens.Service.ImagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imagens")
public class  ImagemController {

    @Autowired
    private ImagemService service;

    @PostMapping
    public ImagemModel salvarImagens(ImagemModel imagemModel) {
        return service.adicionarImagens(imagemModel);
    }

    @GetMapping
    public List<ImagemModel> listarTodasImagens() {
        return service.listarTodasImagens();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarImagem(@PathVariable Long id){
        try {
            service.deletarImagens(id);
            return ResponseEntity.noContent().build();
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

        @PutMapping("/{id}")
        public ResponseEntity<ImagemModel> atualizarImagem (@PathVariable Long id, @RequestBody ImagemModel imagemModel)
        {
            try {
                ImagemModel imagemAtualizada = service.atualizarImagem(id, imagemModel);
                return ResponseEntity.ok(imagemAtualizada);
            } catch (RuntimeException e) {
                return ResponseEntity.notFound().build();
            }
        }
    }

