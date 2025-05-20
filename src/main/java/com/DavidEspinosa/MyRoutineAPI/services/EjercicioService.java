package com.DavidEspinosa.MyRoutineAPI.services;

import com.DavidEspinosa.MyRoutineAPI.models.Ejercicio;
import java.util.List;

public interface EjercicioService {
    List<Ejercicio> findAll();
    Ejercicio findById(Long id);
    Ejercicio create(Ejercicio e);
    Ejercicio update(Long id, Ejercicio e);
    void delete(Long id);
    List<Ejercicio> findByGrupoMuscularId(Long grupoMuscularId);
}
