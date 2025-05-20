package com.DavidEspinosa.MyRoutineAPI.controllers;

import com.DavidEspinosa.MyRoutineAPI.dto.LoginDTO;
import com.DavidEspinosa.MyRoutineAPI.dto.UsuarioDTO;
import com.DavidEspinosa.MyRoutineAPI.models.Usuario;
import com.DavidEspinosa.MyRoutineAPI.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Usuario one(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody UsuarioDTO dto) {
        Usuario u = Usuario.builder()
                .nombre(dto.getNombre())
                .contrasena(dto.getContrasena())
                .administrador(dto.getAdministrador())
                .altura(dto.getAltura())
                .pesoActual(dto.getPesoActual())
                .edad(dto.getEdad())
                .nivelActividad(dto.getNivelActividad())
                .objetivo(dto.getObjetivo())
                .sexo(dto.getSexo())
                .build();
        return ResponseEntity.status(201).body(service.create(u));
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody UsuarioDTO dto) {
        Usuario u = Usuario.builder()
                .id(id)
                .nombre(dto.getNombre())
                .contrasena(dto.getContrasena())
                .administrador(dto.getAdministrador())
                .altura(dto.getAltura())
                .pesoActual(dto.getPesoActual())
                .edad(dto.getEdad())
                .nivelActividad(dto.getNivelActividad())
                .objetivo(dto.getObjetivo())
                .sexo(dto.getSexo())
                .build();
        return service.update(id, u);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // ─── NUEVO LOGIN ──────────────────────────────────────────────────────

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody LoginDTO dto) {
        Usuario u = service.login(dto.getNombre(), dto.getContrasena());
        return ResponseEntity.ok(u);
    }
}
