package com.DavidEspinosa.MyRoutineAPI.services;

import com.DavidEspinosa.MyRoutineAPI.models.Rutina;
import com.DavidEspinosa.MyRoutineAPI.repositories.RutinaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RutinaServiceImpl implements RutinaService {
    private final RutinaRepository repo;

    public RutinaServiceImpl(RutinaRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Rutina> findAll() {
        return repo.findAll();
    }

    @Override
    public Rutina findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rutina no encontrada"));
    }

    @Override
    public Rutina create(Rutina r) {
        r.setId(null);
        return repo.save(r);
    }

    @Override
    public Rutina update(Long id, Rutina r) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rutina no encontrada");
        }
        r.setId(id);
        return repo.save(r);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rutina no encontrada");
        }
        repo.deleteById(id);
    }

    @Override
    public List<Rutina> findByUsuarioId(Long usuarioId) {
        return repo.findByUsuarioId(usuarioId);
    }

}
