package com.example.rh_tech.Controller;

import com.example.rh_tech.Model.FuncionariosPorCargoModel;
import com.example.rh_tech.Service.FuncionariosPorCargoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/funcionarioscargo")
public class FuncionariosPorCargoController {

    FuncionariosPorCargoService service;

    @PostMapping
    public FuncionariosPorCargoModel CriarVinculo( @RequestBody FuncionariosPorCargoModel funcionariosPorCargoModel){
        return service.criarVinculo(funcionariosPorCargoModel);
    }

    @GetMapping
    public List<FuncionariosPorCargoModel>listarTodos(){
        return service.ListarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionariosPorCargoModel> detalharUm(@PathVariable Long id) {
        return service.DetalharUm(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionariosPorCargoModel> atualizar (@PathVariable Long id, @RequestBody FuncionariosPorCargoModel funcionariosPorCargoModel) {
        try{
            FuncionariosPorCargoModel funcionariosCargo = service.Atualizar(id, funcionariosPorCargoModel);
            return ResponseEntity.ok(funcionariosCargo);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(params = "cargoId")
    public ResponseEntity<List<FuncionariosPorCargoModel>> filtrarPorCargo(@RequestParam Long cargoId) {
        List<FuncionariosPorCargoModel> funcCarg = service.FiltrarPorCargo(cargoId);
        if(funcCarg.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(funcCarg);
    }

    @GetMapping(params = "funcionarioId")
    public ResponseEntity<List<FuncionariosPorCargoModel>> filtrarPorFuncionario(@RequestParam Long funcionarioId) {
        List<FuncionariosPorCargoModel> funcId = service.FiltrarPorFuncionario(funcionarioId);
        if(funcId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(funcId);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeletarUsuario(@PathVariable Long id) {
        try {
            service.Excluir(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }

    }


}
