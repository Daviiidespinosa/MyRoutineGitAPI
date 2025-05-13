package com.DavidEspinosa.MyRoutineAPI.services;

import com.DavidEspinosa.MyRoutineAPI.models.GrupoMuscular;
import com.DavidEspinosa.MyRoutineAPI.repositories.GrupoMuscularRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GrupoMuscularServiceImpl implements GrupoMuscularService {
    private final GrupoMuscularRepository repo;

    public GrupoMuscularServiceImpl(GrupoMuscularRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<GrupoMuscular> findAll() {
        return repo.findAll();
    }

    @Override
    public GrupoMuscular findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "GrupoMuscular no encontrado"));
    }
}
