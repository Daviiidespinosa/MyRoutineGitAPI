package com.DavidEspinosa.MyRoutineAPI.services;

import com.DavidEspinosa.MyRoutineAPI.models.EjercicioRutina;
import java.util.List;

public interface EjercicioRutinaService {
    List<EjercicioRutina> findAll();
    EjercicioRutina findById(Long id);
    EjercicioRutina create(EjercicioRutina er);
    EjercicioRutina update(Long id, EjercicioRutina er);
    void delete(Long id);
    List<EjercicioRutina> findByRutinaId(Long rutinaId);
}
