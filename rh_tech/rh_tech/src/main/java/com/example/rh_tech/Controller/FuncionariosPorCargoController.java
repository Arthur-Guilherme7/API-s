package com.example.rh_tech.Controller;

import com.example.rh_tech.Model.FuncionariosPorCargoModel;
import com.example.rh_tech.Service.FuncionariosPorCargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/funcionarioscargo")
public class FuncionariosPorCargoController {

    @Autowired
    private FuncionariosPorCargoService service;

    @PostMapping
    public FuncionariosPorCargoModel criarVinculo(@RequestBody FuncionariosPorCargoModel funcionariosPorCargoModel){
        return service.criarVinculo(funcionariosPorCargoModel);
    }

    @GetMapping
    public ResponseEntity<List<FuncionariosPorCargoModel>> filtrar(
            @RequestParam(required = false) Long funcionarioId,
            @RequestParam(required = false) Long cargoId) {

        List<FuncionariosPorCargoModel> resultados;

        if (funcionarioId != null && cargoId != null) {
            resultados = service.FiltrarPorFuncionarioECargo(funcionarioId, cargoId);
        } else if (funcionarioId != null) {
            resultados = service.FiltrarPorFuncionario(funcionarioId);
        } else if (cargoId != null) {
            resultados = service.FiltrarPorCargo(cargoId);
        } else {
            resultados = service.ListarTodos();
        }

        if (resultados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionariosPorCargoModel> detalharUm(@PathVariable Long id) {
        return service.DetalharUm(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionariosPorCargoModel> atualizar (@PathVariable Long id, @RequestBody FuncionariosPorCargoModel funcionariosPorCargoModel) {
        try {
            FuncionariosPorCargoModel funcionariosCargo = service.Atualizar(id, funcionariosPorCargoModel);
            return ResponseEntity.ok(funcionariosCargo);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            service.Excluir(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
