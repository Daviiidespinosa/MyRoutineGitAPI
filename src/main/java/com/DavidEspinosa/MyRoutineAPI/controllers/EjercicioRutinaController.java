package com.DavidEspinosa.MyRoutineAPI.controllers;

import com.DavidEspinosa.MyRoutineAPI.dto.EjercicioRutinaDTO;
import com.DavidEspinosa.MyRoutineAPI.models.Ejercicio;
import com.DavidEspinosa.MyRoutineAPI.models.EjercicioRutina;
import com.DavidEspinosa.MyRoutineAPI.models.Rutina;
import com.DavidEspinosa.MyRoutineAPI.services.EjercicioRutinaService;
import com.DavidEspinosa.MyRoutineAPI.services.EjercicioService;
import com.DavidEspinosa.MyRoutineAPI.services.RutinaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ejercicios-rutina")
public class EjercicioRutinaController {

    private final EjercicioRutinaService service;
    private final RutinaService rutinaService;
    private final EjercicioService ejercicioService;

    public EjercicioRutinaController(
            EjercicioRutinaService service,
            RutinaService rutinaService,
            EjercicioService ejercicioService
    ) {
        this.service = service;
        this.rutinaService = rutinaService;
        this.ejercicioService = ejercicioService;
    }

    @GetMapping
    public List<EjercicioRutina> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EjercicioRutina one(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<EjercicioRutina> create(@RequestBody EjercicioRutinaDTO dto) {
        Rutina r = rutinaService.findById(dto.getRutinaId());
        Ejercicio e = ejercicioService.findById(dto.getEjercicioId());
        EjercicioRutina er = EjercicioRutina.builder()
                .rutina(r)
                .ejercicio(e)
                .seriesPlaneadas(dto.getSeriesPlaneadas())
                .build();
        return ResponseEntity.status(201).body(service.create(er));
    }

    @PutMapping("/{id}")
    public EjercicioRutina update(
            @PathVariable Long id,
            @RequestBody EjercicioRutinaDTO dto
    ) {
        Rutina r = rutinaService.findById(dto.getRutinaId());
        Ejercicio e = ejercicioService.findById(dto.getEjercicioId());
        EjercicioRutina er = EjercicioRutina.builder()
                .id(id)
                .rutina(r)
                .ejercicio(e)
                .seriesPlaneadas(dto.getSeriesPlaneadas())
                .build();
        return service.update(id, er);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Nuevo endpoint: obtener solo los ejerciciosRutina de una rutina
    @GetMapping("/rutina/{rutinaId}")
    public List<EjercicioRutina> findByRutina(@PathVariable Long rutinaId) {
        return service.findByRutinaId(rutinaId);
    }
}
