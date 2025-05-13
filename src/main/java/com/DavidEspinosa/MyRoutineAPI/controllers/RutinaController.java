package com.DavidEspinosa.MyRoutineAPI.controllers;

import com.DavidEspinosa.MyRoutineAPI.dto.RutinaDTO;
import com.DavidEspinosa.MyRoutineAPI.models.Rutina;
import com.DavidEspinosa.MyRoutineAPI.models.Usuario;
import com.DavidEspinosa.MyRoutineAPI.services.RutinaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rutinas")
public class RutinaController {

    private final RutinaService service;

    public RutinaController(RutinaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Rutina> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Rutina one(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Rutina> create(@RequestBody RutinaDTO dto) {
        // mapear DTO -> entidad
        Rutina toCreate = Rutina.builder()
                .nombre(dto.getNombre())
                .usuario(Usuario.builder().id(dto.getUsuarioId()).build())
                .build();
        Rutina created = service.create(toCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public Rutina update(@PathVariable Long id, @RequestBody RutinaDTO dto) {
        Rutina toUpdate = Rutina.builder()
                .id(id)
                .nombre(dto.getNombre())
                .usuario(Usuario.builder().id(dto.getUsuarioId()).build())
                .build();
        return service.update(id, toUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Rutina> getRutinasPorUsuario(@PathVariable Long usuarioId) {
        return service.findByUsuarioId(usuarioId);
    }
}       