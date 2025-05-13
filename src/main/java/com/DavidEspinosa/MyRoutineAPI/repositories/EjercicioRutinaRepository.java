package com.DavidEspinosa.MyRoutineAPI.repositories;

import com.DavidEspinosa.MyRoutineAPI.models.EjercicioRutina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EjercicioRutinaRepository extends JpaRepository<EjercicioRutina, Long> {
    List<EjercicioRutina> findAllByRutinaId(Long rutinaId);
}

