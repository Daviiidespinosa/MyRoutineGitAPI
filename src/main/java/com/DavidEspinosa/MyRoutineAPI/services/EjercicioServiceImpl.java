package com.DavidEspinosa.MyRoutineAPI.services;

import com.DavidEspinosa.MyRoutineAPI.models.Ejercicio;
import com.DavidEspinosa.MyRoutineAPI.repositories.EjercicioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EjercicioServiceImpl implements EjercicioService {
    private final EjercicioRepository repo;

    public EjercicioServiceImpl(EjercicioRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Ejercicio> findAll() {
        return repo.findAll();
    }

    @Override
    public Ejercicio findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ejercicio no encontrado"));
    }

    @Override
    public Ejercicio create(Ejercicio e) {
        e.setId(null);
        return repo.save(e);
    }

    @Override
    public Ejercicio update(Long id, Ejercicio e) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ejercicio no encontrado");
        }
        e.setId(id);
        return repo.save(e);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ejercicio no encontrado");
        }
        repo.deleteById(id);
    }
    @Override
    public List<Ejercicio> findByGrupoMuscularId(Long grupoMuscularId) {
        return repo.findByGrupoMuscularId(grupoMuscularId);
    }
}
