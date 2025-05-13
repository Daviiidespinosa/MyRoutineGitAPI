package com.DavidEspinosa.MyRoutineAPI.services;

import com.DavidEspinosa.MyRoutineAPI.models.EjercicioRutina;
import com.DavidEspinosa.MyRoutineAPI.repositories.EjercicioRutinaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EjercicioRutinaServiceImpl implements EjercicioRutinaService {
    private final EjercicioRutinaRepository repo;

    public EjercicioRutinaServiceImpl(EjercicioRutinaRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<EjercicioRutina> findAll() {
        return repo.findAll();
    }

    @Override
    public EjercicioRutina findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "EjercicioRutina no encontrado")
                );
    }

    @Override
    public EjercicioRutina create(EjercicioRutina er) {
        er.setId(null);
        return repo.save(er);
    }

    @Override
    public EjercicioRutina update(Long id, EjercicioRutina er) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "EjercicioRutina no encontrado");
        }
        er.setId(id);
        return repo.save(er);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "EjercicioRutina no encontrado");
        }
        repo.deleteById(id);
    }

    @Override
    public List<EjercicioRutina> findByRutinaId(Long rutinaId) {
        return repo.findAllByRutinaId(rutinaId);
    }
}
