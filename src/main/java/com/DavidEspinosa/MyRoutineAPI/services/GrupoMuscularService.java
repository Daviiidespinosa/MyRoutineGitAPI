package com.DavidEspinosa.MyRoutineAPI.services;

import com.DavidEspinosa.MyRoutineAPI.models.GrupoMuscular;
import java.util.List;

public interface GrupoMuscularService {
    List<GrupoMuscular> findAll();
    GrupoMuscular findById(Long id);
}
