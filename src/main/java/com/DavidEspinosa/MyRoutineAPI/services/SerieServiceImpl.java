package com.DavidEspinosa.MyRoutineAPI.services;

import com.DavidEspinosa.MyRoutineAPI.models.Serie;
import com.DavidEspinosa.MyRoutineAPI.repositories.SerieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SerieServiceImpl implements SerieService {
    private final SerieRepository repo;

    public SerieServiceImpl(SerieRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Serie> findAll() {
        return repo.findAll();
    }

    @Override
    public Serie findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serie no encontrada"));
    }

    @Override
    public Serie create(Serie s) {
        s.setId(null);
        return repo.save(s);
    }

    @Override
    public Serie update(Long id, Serie s) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Serie no encontrada");
        }
        s.setId(id);
        return repo.save(s);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Serie no encontrada");
        }
        repo.deleteById(id);
    }
    @Override
    public List<Serie> findByEjercicioRutinaId(Long ejercicioRutinaId) {
        return repo.findByEjercicioRutinaId(ejercicioRutinaId);
    }
}
