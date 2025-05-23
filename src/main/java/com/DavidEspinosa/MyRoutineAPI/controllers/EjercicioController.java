package com.DavidEspinosa.MyRoutineAPI.controllers;

import com.DavidEspinosa.MyRoutineAPI.dto.EjercicioDTO;
import com.DavidEspinosa.MyRoutineAPI.models.Ejercicio;
import com.DavidEspinosa.MyRoutineAPI.models.GrupoMuscular;
import com.DavidEspinosa.MyRoutineAPI.services.EjercicioService;
import com.DavidEspinosa.MyRoutineAPI.services.GrupoMuscularService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ejercicios")
public class EjercicioController {

    private final EjercicioService service;
    private final GrupoMuscularService gmService;

    public EjercicioController(EjercicioService service, GrupoMuscularService gmService) {
        this.service = service;
        this.gmService = gmService;
    }

    @GetMapping public List<Ejercicio> all() { return service.findAll(); }
    @GetMapping("/{id}") public Ejercicio one(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public ResponseEntity<Ejercicio> create(@RequestBody EjercicioDTO dto) {
        GrupoMuscular gm = gmService.findById(dto.getGrupoMuscularId());
        Ejercicio e = Ejercicio.builder()
                .nombre(dto.getNombre())
                .grupoMuscular(gm)
                .build();
        return ResponseEntity.status(201).body(service.create(e));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ejercicio> update(
            @PathVariable Long id,
            @RequestBody EjercicioDTO dto
    ) {
        // 1) recupera el ejercicio existente (lanza 404 si no existe)
        Ejercicio existente = service.findById(id);

        // 2) cambia sólo el nombre
        existente.setNombre(dto.getNombre());

        // 3) si en el DTO viene un grupo distinto, lo aplicas
        if (dto.getGrupoMuscularId() != null) {
            GrupoMuscular gm = gmService.findById(dto.getGrupoMuscularId());
            existente.setGrupoMuscular(gm);
        }

        // 4) guardas y devuelves 200 OK
        Ejercicio actualizado = service.update(id, existente);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/grupo/{grupoId}")
    public List<Ejercicio> ejerciciosPorGrupo(@PathVariable Long grupoId) {
        return service.findByGrupoMuscularId(grupoId);
    }
}
