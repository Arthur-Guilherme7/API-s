package com.example.rh_tech.Controller;

import com.example.rh_tech.Model.CargoModel;
import com.example.rh_tech.Service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/cargos")
public class CargoController {
    @Autowired
    CargoService service;

    @PostMapping
    public CargoModel SalvarUsuario( @RequestBody CargoModel cargoModel){
        return service.AdicionarCargo(cargoModel);
    }
    @GetMapping
    public List<CargoModel> ListarTodos(){
        return service.ListarTodos();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeletarUsuario(@PathVariable Long id){
        try{
            service.DeletarCargo(id);
            return ResponseEntity.noContent().build();
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<CargoModel> Atulizar (@PathVariable Long id, @RequestBody CargoModel cargoModel){
        try{
            CargoModel cargoAtt = service.AtualizarCargo(id, cargoModel);
            return ResponseEntity.ok(cargoAtt);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<CargoModel> BuscarPorId(@PathVariable Long id) {
        return service.BuscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}

