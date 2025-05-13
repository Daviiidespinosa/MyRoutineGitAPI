package com.DavidEspinosa.MyRoutineAPI.services;

import com.DavidEspinosa.MyRoutineAPI.models.Serie;
import java.util.List;

public interface SerieService {
    List<Serie> findAll();
    Serie findById(Long id);
    Serie create(Serie s);
    Serie update(Long id, Serie s);
    void delete(Long id);
    List<Serie> findByEjercicioRutinaId(Long ejercicioRutinaId);
}
