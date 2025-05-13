package com.DavidEspinosa.MyRoutineAPI.controllers;

import com.DavidEspinosa.MyRoutineAPI.models.GrupoMuscular;
import com.DavidEspinosa.MyRoutineAPI.services.GrupoMuscularService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos-musculares")
public class GrupoMuscularController {

    private final GrupoMuscularService service;

    public GrupoMuscularController(GrupoMuscularService service) {
        this.service = service;
    }

    @GetMapping
    public List<GrupoMuscular> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public GrupoMuscular one(@PathVariable Long id) {
        return service.findById(id);
    }
}
