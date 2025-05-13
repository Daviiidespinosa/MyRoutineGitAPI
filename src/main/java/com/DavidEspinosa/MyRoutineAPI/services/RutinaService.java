package com.DavidEspinosa.MyRoutineAPI.services;

import com.DavidEspinosa.MyRoutineAPI.models.Rutina;
import java.util.List;

public interface RutinaService {
    List<Rutina> findAll();
    Rutina findById(Long id);
    Rutina create(Rutina r);
    Rutina update(Long id, Rutina r);
    void delete(Long id);
    List<Rutina> findByUsuarioId(Long usuarioId);
}
