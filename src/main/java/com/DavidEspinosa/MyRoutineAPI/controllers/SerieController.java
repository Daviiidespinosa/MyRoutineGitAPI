package com.DavidEspinosa.MyRoutineAPI.controllers;

import com.DavidEspinosa.MyRoutineAPI.dto.SerieDTO;
import com.DavidEspinosa.MyRoutineAPI.models.EjercicioRutina;
import com.DavidEspinosa.MyRoutineAPI.models.Serie;
import com.DavidEspinosa.MyRoutineAPI.services.EjercicioRutinaService;
import com.DavidEspinosa.MyRoutineAPI.services.SerieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/series")
public class SerieController {

    private final SerieService service;
    private final EjercicioRutinaService erService;

    public SerieController(SerieService service, EjercicioRutinaService erService) {
        this.service = service;
        this.erService = erService;
    }

    @GetMapping
    public List<Serie> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Serie one(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Serie> create(@RequestBody SerieDTO dto) {
        EjercicioRutina er = erService.findById(dto.getEjercicioRutinaId());
        Serie s = Serie.builder()
                .ejercicioRutina(er)
                .repeticiones(dto.getRepeticiones())
                .pesoLevantado(dto.getPesoLevantado())
                .build();
        return ResponseEntity.status(201).body(service.create(s));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Serie> update(
            @PathVariable Long id,
            @RequestBody SerieDTO dto
    ) {
        EjercicioRutina er = erService.findById(dto.getEjercicioRutinaId());
        Serie s = Serie.builder()
                // NO seteamos .id(id)
                .ejercicioRutina(er)
                .repeticiones(dto.getRepeticiones())
                .pesoLevantado(dto.getPesoLevantado())
                .build();
        Serie updated = service.update(id, s);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ejercicio-rutina/{erId}")
    public List<Serie> byEjercicioRutina(@PathVariable Long erId) {
        return service.findByEjercicioRutinaId(erId);
    }
}
